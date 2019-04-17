package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.impl.BranchDaoImpl;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.RegisteredDaoImpl;
import com.msr.hospital.dao.impl.RegistrationfeeDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class BranchServlet
 */
@WebServlet("/BranchServlet")
public class BranchServlet extends BaseServlet {
	private OperationRecordDao ord = null;
	private PatientinformationDao pd = null;
	private TypeoftreatmentDao td = null;
	private BranchDao bd = null;
	private DoctorsDao dd =null;
	private RegistrationfeeDao rd = null;
	private RegisteredDao rrd = null;
	/**
	 * 初始化 私有变量接口
	 */
	@Override
	public void init() throws ServletException {
		ord = new OperationRecordDaoImpl();
		pd = new PatientinformationDaoImpl();
		td = new TypeoftreatmentDaoImple();
		bd = new BranchDaoImpl();
		dd = new DoctorsDaoImpl();
		rd = new RegistrationfeeDaoImpl();
		rrd = new RegisteredDaoImpl();
	}
	
	/**
	 * 查询所有科室信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAllBranch(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		List<Branch> blist = bd.findAll();
		req.setAttribute("blist", blist);
		
		//25代表查询科室记录
		addRecord("25", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/keshi.jsp";
		default:
			return "index.jsp";
		}
	}
	
	public String searchBranch(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String brid = req.getParameter("brid");
		String brname = req.getParameter("brname");
		
		if((brid==null || brid.equals(""))&&(brname==null || brname.equals(""))) {
			site = 1;
		}else if(brid==null || brid.equals("")) {
			List<Branch> blist = bd.findByBrname(brname);
			req.setAttribute("blist", blist);
		}else if(brname==null || brname.equals("")) {
			List<Branch> blist = bd.findByBridM(brid);
			req.setAttribute("blist", blist);
		}
		
		//25代表查询科室记录
		addRecord("25", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/keshi.jsp";
		case 1:
			return "BranchServlet?site=0&method=findAllBranch";
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
