package com.msr.hospital.servlet;

import java.io.IOException;
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
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.MedicalprojectDao;
import com.msr.hospital.dao.MedicalrecordDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.PrescriptionDao;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.impl.BranchDaoImpl;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.MedicalprojectDaoImpl;
import com.msr.hospital.dao.impl.MedicalrecordDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.PrescriptionDaoImpl;
import com.msr.hospital.dao.impl.RegisteredDaoImpl;
import com.msr.hospital.dao.impl.RegistrationfeeDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class MedicalrecordSevlet
 */
@WebServlet("/MedicalrecordSevlet")
public class MedicalrecordSevlet extends BaseServlet {
	private OperationRecordDao ord = null;
	private PatientinformationDao pd = null;
	private TypeoftreatmentDao td = null;
	private BranchDao bd = null;
	private DoctorsDao dd =null;
	private RegistrationfeeDao rd = null;
	private RegisteredDao rrd = null;
	private MedicalprojectDao md = null;
	private MedicalrecordDao mrd = null;
	private PrescriptionDao ppd = null;
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
		mrd = new MedicalrecordDaoImpl();
		ppd = new PrescriptionDaoImpl();
	}
	
	public String searchByPiid(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String piid = req.getParameter("piid");
		
		if(piid==null || piid.equals("")) {
			site = 1;
		}else {
			List<Medicalrecord> mrlist = mrd.findByPiid(piid);
			req.setAttribute("mrlist", mrlist);
		}
		
		
		
		
		//35代表查询病例项目记录
		addRecord("35", req, resp);
		switch (site) {
		case 0:
			return "/html/disease/diseaseInfo.jsp";
		case 1:
			return "MedicalrecordSevlet?site=0&method=findAllMrecord";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 查询所有的病例信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAllMrecord(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		List<Medicalrecord> mrlist = mrd.findAll();
		req.setAttribute("mrlist", mrlist);
		
		//35代表查询病例项目记录
		addRecord("35", req, resp);
		switch (site) {
		case 0:
			return "/html/disease/diseaseInfo.jsp";
		case 1:
			return "MedicalprojectSevlet?site=0&method=findAllmd";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 根据处方编号 查询处方对象病返回
	 * @param req
	 * @param resp
	 * @return
	 */
	public String getOnePrescription(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String ppid = req.getParameter("ppid");
		
		
		Prescription prescription = ppd.findByppid(ppid);
		req.setAttribute("prescription", prescription);
		
		
		//35代表查询病例项目记录
		addRecord("35", req, resp);
		switch (site) {
		case 0:
			return "/html/disease/chufangEdit.jsp";
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
