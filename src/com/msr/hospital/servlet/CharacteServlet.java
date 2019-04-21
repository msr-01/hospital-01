package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Characte;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Rolepermissions;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.CharacteDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.RolepermissionsDao;
import com.msr.hospital.dao.impl.CharacteDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.RolepermissionsDaoImpl;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class CharacteServlet
 */
@WebServlet("/CharacteServlet")
public class CharacteServlet extends BaseServlet {
	private OperationRecordDao ord = null;
	private CharacteDao cd = null;
	private RolepermissionsDao rd = null;
	
	
	@Override
	public void init() throws ServletException {
		cd = new CharacteDaoImpl();
		ord = new OperationRecordDaoImpl();
		rd = new RolepermissionsDaoImpl();
	}
	
	/**
	 * 查询所有角色信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String getAllCaracte(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		List<Characte> clist = cd.findAllCharacte();
		req.setAttribute("clist", clist);
		
		
		//50代表查询角色信息
		addRecord("12", req, resp);
		switch (site) {
		case 0:
			return "html/Popedom/popedom.jsp";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 根据传入的Cid  查找对应的角色权限信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String getoneCaracte(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		List<Characte> clist = cd.findAllCharacte();
		req.setAttribute("clist", clist);
		String cid = req.getParameter("cid");
		
		Characte characte = cd.findByCid(cid);
		
		req.setAttribute("characte", characte);
		
		
		//50代表查询角色信息
		addRecord("12", req, resp);
		switch (site) {
		case 0:
			return "html/Popedom/popedom.jsp";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 根据前台复选框改变角色权限
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String changerole(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String cid = req.getParameter("cid");
		
		Characte characte = cd.findByCid(cid);
		StringBuffer sbf = new StringBuffer();
		
		if(req.getParameter("ra")!=null) {
			sbf.append("a");
		}
		if(req.getParameter("rb")!=null) {
			sbf.append("b");
		}
		if(req.getParameter("rc")!=null) {
			sbf.append("c");
		}
		if(req.getParameter("rd")!=null) {
			sbf.append("d");
		}
		if(req.getParameter("re")!=null) {
			sbf.append("e");
		}
		
		if(req.getParameter("rf")!=null) {
			sbf.append("f");
		}
		if(req.getParameter("rg")!=null) {
			sbf.append("g");
		}
		if(req.getParameter("rh")!=null) {
			sbf.append("h");
		}
		if(req.getParameter("ri")!=null) {
			sbf.append("i");
		}
		if(req.getParameter("rj")!=null) {
			sbf.append("j");
		}
		if(req.getParameter("rk")!=null) {
			sbf.append("k");
		}
		if(req.getParameter("rl")!=null) {
			sbf.append("l");
		}
		
		Rolepermissions rolepermissions = characte.getRolepermissions();
		
		rolepermissions.setPopedom(sbf.toString());
		
		rd.modifyRolepermissions(rolepermissions);
		
		
		//60代表改变角色权限
		addRecord("60", req, resp);
		switch (site) {
		case 0:
			return "html/Popedom/popedom.jsp";
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
