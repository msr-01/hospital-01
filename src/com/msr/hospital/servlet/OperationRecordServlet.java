package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class OperationRecordServlet
 */
@WebServlet("/OperationRecordServlet")
public class OperationRecordServlet extends BaseServlet {
	private OperationRecordDao ord = null;
	@Override
	public void init() throws ServletException {
		ord = new OperationRecordDaoImpl();
	}
	
	/**
	 * 查询所有操作记录
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAllOR(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		List<OperationRecord> oplist = ord.findAll();
		req.setAttribute("oplist", oplist);
		
		
		//70代表查询操作记录
		addRecord("70", req, resp);
		switch (site) {
		case 0:
			return "/html/OperationRecord/operationRecord.jsp";
		case 1:
			return "BranchServlet?site=0&method=findAllBranch";
		default:
			return "index.jsp";
		}
	}
	/**
	 * 根据用户编号与用户姓名查找用户的操作记录
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String searchOR(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String jobnumber = req.getParameter("jobnumber");
		String uname = req.getParameter("uname");
		
		if((jobnumber==null || jobnumber.equals(""))&&(uname==null || uname.equals(""))) {
			site = 1;
		}else if(uname==null || uname.equals("")) {
			List<OperationRecord> oplist = ord.findByJobnumber(jobnumber);
			req.setAttribute("oplist", oplist);
		}else if((jobnumber==null || jobnumber.equals(""))) {
			List<OperationRecord> oplist = ord.findByUname(uname);
			req.setAttribute("oplist", oplist);
		}
		
		//70代表查询操作记录
		addRecord("70", req, resp);
		switch (site) {
		case 0:
			return "/html/OperationRecord/operationRecord.jsp";
		case 1:
			return "OperationRecordServlet?site=0&method=findAllOR";
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
