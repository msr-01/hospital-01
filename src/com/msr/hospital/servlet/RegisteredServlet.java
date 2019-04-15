package com.msr.hospital.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.impl.CharacteDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.UserInfosDaoImpl;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class RegisteredServlet
 */
@WebServlet("/RegisteredServlet")
public class RegisteredServlet extends BaseServlet {
	
	private OperationRecordDao ord = null;
	private PatientinformationDao pd = null;
	/**
	 * 初始化 私有变量接口
	 */
	@Override
	public void init() throws ServletException {
		ord = new OperationRecordDaoImpl();
		pd = new PatientinformationDaoImpl();
	}
	
	public String getPatByPiid(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String piid = req.getParameter("piid");
		Patientinformation patientinformation = pd.findByPiid(piid);
		req.setAttribute("patientinformation", patientinformation);
		
		
		//查询患者信息
		addRecord("7", req, resp);
		switch (site) {
		case 0:
			return "UserInfosServlet?method=getUserInfosAll&site=0";
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
