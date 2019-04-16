package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.impl.BranchDaoImple;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.RegisteredDaoImpl;
import com.msr.hospital.dao.impl.RegistrationfeeDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class PatientinformationServlet
 */
@WebServlet("/PatientinformationServlet")
public class PatientinformationServlet extends BaseServlet {
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
	 * 
	 * 查询所有的患者记录
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAll(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		List<Patientinformation> plist = pd.findAll();
		
		req.setAttribute("plist", plist);
		
		//15代表查询患者信息
		addRecord("15", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/patientInfo.jsp";
		case 1:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 修改用户信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String ModifyPatientinformation(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String piid = req.getParameter("piid");
		Patientinformation patientinformation = pd.findByPiid(piid);
				
		switch (site) {
		case 0:	
			req.setAttribute("patientinformation", patientinformation);
			//15代表查询患者信息
			addRecord("15", req, resp);
			return "/html/Guahao/patientModify.jsp";
		case 1:
			patientinformation.setPiage(Integer.parseInt(req.getParameter("piage")));
			patientinformation.setPiname(req.getParameter("piname"));
			patientinformation.setPiphonenumber(req.getParameter("piphonenumber"));
			patientinformation.setPisex(req.getParameter("pisex"));
			
			pd.modify(patientinformation);
			//16代表修改患者信息
			addRecord("16", req, resp);
			return "PatientinformationServlet?method=findAll&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 根据就诊卡号删除患者信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String deletePatientinformation(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String piid = req.getParameter("piid");
		pd.deleteByPiid(piid);
		
		
		//17代表删除患者信息
		addRecord("17", req, resp);
		switch (site) {
		case 0:
			return "PatientinformationServlet?method=findAll&site=0";
		case 1:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 增加一条患者信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String addPatientinformation(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		Patientinformation patientinformation = new Patientinformation(null, req.getParameter("piname"), req.getParameter("pisex"), Integer.parseInt(req.getParameter("piage")), req.getParameter("piphonenumber"), null);
		pd.addPatientinformation(patientinformation);
		
		//18代表增加患者信息
		addRecord("18", req, resp);
		switch (site) {
		case 0:
			return "PatientinformationServlet?method=findAll&site=0";
		case 1:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 根据患者卡号，患者姓名，患者手机号码查询患者信息
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String searchPatientinformation(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String piid = req.getParameter("piid");
		String piname = req.getParameter("piname");
		String piphonenumber = req.getParameter("piphonenumber");
		
		if((piid==null || piid.equals(""))&&(piname==null || piname.equals(""))&&(piphonenumber==null || piphonenumber.equals(""))) {
			site =1;
		}else if((piname==null || piname.equals(""))&&(piphonenumber==null || piphonenumber.equals(""))){
			Patientinformation patientinformation = pd.findByPiid(piid);
			List<Patientinformation> plist = new ArrayList<Patientinformation>();
			plist.add(patientinformation);
			req.setAttribute("plist", plist);
		}else if((piid==null || piid.equals(""))&&(piname==null || piname.equals(""))) {
			List<Patientinformation> plist = pd.findByPhone(piphonenumber);
			req.setAttribute("plist", plist);
		}else if((piid==null || piid.equals(""))&&(piphonenumber==null || piphonenumber.equals(""))) {
			List<Patientinformation> plist = pd.findByPiname(piname);
			req.setAttribute("plist", plist);
		}
		
		
		//15代表查询患者信息
		addRecord("15", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/patientInfo.jsp";
		case 1:
			return "PatientinformationServlet?method=findAll&site=0";
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
