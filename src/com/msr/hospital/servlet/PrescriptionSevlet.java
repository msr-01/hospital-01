package com.msr.hospital.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Medicalrecord;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Prescription;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.MedicalrecordDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PrescriptionDao;
import com.msr.hospital.dao.impl.MedicalrecordDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PrescriptionDaoImpl;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class PrescriptionSevlet
 */
@WebServlet("/PrescriptionSevlet")
public class PrescriptionSevlet extends BaseServlet {
	private PrescriptionDao ppd = null;
	private OperationRecordDao ord = null;
	private MedicalrecordDao md = null;
	
	@Override
	public void init() throws ServletException {
		ppd = new PrescriptionDaoImpl();
		ord = new OperationRecordDaoImpl();
		md = new MedicalrecordDaoImpl();
	}
	
	/**
	 * 查询所有处方记录
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAllPrescription(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		List<Prescription> plist = ppd.findAll();
		req.setAttribute("plist", plist);
		
		//40代表查询处方信息
		addRecord("40", req, resp);
		switch (site) {
		case 0:
			return "/html/PriceManage/charge.jsp";
		case 1:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 根据处方编号查询药品信息 或查询医疗项目信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findDruglist(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String ppid = req.getParameter("ppid");
		Prescription prescription = ppd.findByppid(ppid);
		
		req.setAttribute("prescription", prescription);
		
		//40代表查询处方信息
		addRecord("40", req, resp);
		switch (site) {
		case 0:
			return "/html/PriceManage/chufang_yaoEdit.jsp";
		case 1:
			return "/html/PriceManage/chufang_yiliaoEdit.jsp";
		default:
			return "index.jsp";
		}
	}
	
	
	
	/**
	 * 转发req对象
	 * @param req
	 * @param resp
	 * @return
	 */
	public String redirect(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		//40代表查询处方信息
		addRecord("40", req, resp);
		switch (site) {
		case 0:
			return "/html/PriceManage/chufang_yaoEdit.jsp";
		case 1:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 修改处方状态 state 变为1  付款时间设置成现在
	 * @param req
	 * @param resp
	 * @return
	 */
	public String payOrder(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String ppid = req.getParameter("ppid");
		Prescription prescription = ppd.findByppid(ppid);
		prescription.setPpstatus(1);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String pppaymenttime = sdf.format(date);
		prescription.setPppaymenttime(pppaymenttime);
		
		ppd.modifyprescription(prescription);
		
		//41代表修改处方信息
		addRecord("41", req, resp);
		switch (site) {
		case 0:
			return "PrescriptionSevlet?method=findAllPrescription&site=0";
		case 1:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 根据就诊卡号查询患者的处方信息
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String findOrderBypiid(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String piid = req.getParameter("piid");
		if(piid==null || piid.equals("")) {
			site=1;
		}
		
		switch (site) {
		case 0:
			List<Medicalrecord> mlist = md.findByPiid(piid);
			List<Prescription> plist = new ArrayList<Prescription>();
			
			for(int i=0 ; i<mlist.size() ; i++) {
				plist.add(mlist.get(i).getPrescription());
			}
			
			req.setAttribute("plist", plist);
			
			//40代表查询处方信息
			addRecord("40", req, resp);
			return "//html/PriceManage/charge.jsp";
		case 1:
			return "PrescriptionSevlet?method=findAllPrescription&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 增加操作记录
	 * @param otid 操作类型
	 * @param uid 用户编号 正在操作的得人
	 */
	private void addRecord(String otid,HttpServletRequest req , HttpServletResponse resp) {
		String orid = UUIDUtils.getId();
		String ortime = TimeUtil.getNowDateTime();
		UserInfos userInfos = (UserInfos)req.getSession().getAttribute("userInfos");
		OperationType operationType = new OperationType(otid, "");
		OperationRecord operationRecord = new OperationRecord(orid, operationType, ortime, userInfos);
		ord.addOperationRecord(operationRecord);
	}
}
