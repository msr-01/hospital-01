package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Doctors;
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
 * Servlet implementation class DoctorsSevlet
 */
@WebServlet("/DoctorsSevlet")
public class DoctorsSevlet extends BaseServlet {
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
	 * 根据医生工号与医生姓名模糊查询 医生信息
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String searchDoctors(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String jobnumber = req.getParameter("jobnumber");
		String uname = req.getParameter("uname");
		System.out.println("jobnumber:"+jobnumber);
		System.out.println("uname"+uname);
		
		
		if((jobnumber==null || jobnumber.equals(""))&&(uname==null || uname.equals(""))) {
			site = 1 ;
		}else if(jobnumber==null || jobnumber.equals("")) {
			List<Doctors> dList = dd.findByName(uname);
			req.setAttribute("dList", dList);
		}else if(uname==null || uname.equals("")) {
			List<Doctors> dList = dd.findByJobnumber(jobnumber);
			req.setAttribute("dList", dList);
		}
		
		
		//20代表查询医生信息
		addRecord("20", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/doctorInfo.jsp";
		case 1:
			return "DoctorsSevlet?method=findAllDoctors&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 查询所有医生信息 返回医生实体集合
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAllDoctors(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		List<Doctors> dList = dd.findAll();
		req.setAttribute("dList", dList);
		
		
		//20代表查询医生信息
		addRecord("20", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/doctorInfo.jsp";
		case 1:
			return "RegisteredServlet?method=findAllRegistered&site=0";
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
