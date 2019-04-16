package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Medicalproject;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.MedicalprojectDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.impl.BranchDaoImpl;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.MedicalprojectDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.RegisteredDaoImpl;
import com.msr.hospital.dao.impl.RegistrationfeeDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class MedicalprojectSevlet
 */
@WebServlet("/MedicalprojectSevlet")
public class MedicalprojectSevlet extends BaseServlet {
	
	private OperationRecordDao ord = null;
	private PatientinformationDao pd = null;
	private TypeoftreatmentDao td = null;
	private BranchDao bd = null;
	private DoctorsDao dd =null;
	private RegistrationfeeDao rd = null;
	private RegisteredDao rrd = null;
	private MedicalprojectDao md = null;
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
		md = new MedicalprojectDaoImpl();
	}
	
	/**
	 * 查询所有医疗项目信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAllmd(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		List<Medicalproject> mlist = md.findAll();
		req.setAttribute("mlist", mlist);
		
		//30代表查询医疗项目记录
		addRecord("30", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/yiliaoxiangmu.jsp";
		case 1:
			return "BranchServlet?site=0&method=findAllBranch";
		default:
			return "index.jsp";
		}
	}
	
	
	public String searchmd(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String mpid = req.getParameter("mpid");
		String mpname = req.getParameter("mpname");
		
		if((mpid==null || mpid.equals(""))&&(mpname==null || mpname.equals(""))) {
			site = 1;
		}else if(mpid==null || mpid.equals("")) {
			List<Medicalproject> mlist = md.findByMpname(mpname);
			req.setAttribute("mlist", mlist);
		}else if(mpname==null || mpname.equals("")) {
			List<Medicalproject> mlist = md.findByMpid(mpid);
			req.setAttribute("mlist", mlist);
		}
		
		
		//30代表查询医疗项目记录
		addRecord("30", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/yiliaoxiangmu.jsp";
		case 1:
			return "MedicalprojectSevlet?site=0&method=findAllmd";
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
