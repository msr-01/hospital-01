package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.Doctors;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.Registered;
import com.msr.hospital.bean.Registrationfee;
import com.msr.hospital.bean.Typeoftreatment;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.impl.BranchDaoImple;
import com.msr.hospital.dao.impl.CharacteDaoImpl;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.RegisteredDaoImpl;
import com.msr.hospital.dao.impl.RegistrationfeeDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;
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
		bd = new BranchDaoImple();
		dd = new DoctorsDaoImpl();
		rd = new RegistrationfeeDaoImpl();
		rrd = new RegisteredDaoImpl();
	}
	
	/**
	 * 根据挂号信息 添加一条挂号记录
	 * @param req
	 * @param resp
	 * @return
	 */
	public String addRegistered(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String piid = req.getParameter("piid");
		String retime = req.getParameter("time");
		String doid = req.getParameter("doctor");
		Doctors doctors = dd.findByDoid(doid);
		Typeoftreatment typeoftreatment = doctors.getTypeoftreatment();
		Branch branch = doctors.getBranch();
		Patientinformation patientinformation = pd.findByPiid(piid);
		Registrationfee registrationfee = rd.findByDoid(doid);
		String reid = UUIDUtils.getId();
		
		Registered registered = new Registered(reid, typeoftreatment, patientinformation, branch, registrationfee, retime, doctors);
		rrd.addRegistered(registered);
		
		//9代表增加挂号记录
		addRecord("9", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/guahao.jsp";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 挂号页面科室与挂号类型数据加载
	 * @param req
	 * @param resp
	 * @return
	 */
	public String TypeBranchInfo(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		List<Typeoftreatment> tlist = td.findAll();
		List<Branch> blist = bd.findAll();
		
		req.setAttribute("tlist", tlist);
		req.setAttribute("blist", blist);
		
		
		switch (site) {
		case 0:
			return "/html/Guahao/guahao.jsp";
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
