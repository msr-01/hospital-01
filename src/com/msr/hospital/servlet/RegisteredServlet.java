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
	 * 根据传入的挂号编号 删除挂号记录
	 * @param req
	 * @param resp
	 * @return
	 */
	public String deleteRegistered(HttpServletRequest req, HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String reid = req.getParameter("reid");
		rrd.deleteByReid(reid);
		
		//12代表删除挂号记录
		addRecord("12", req, resp);
		switch (site) {
		case 0:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
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
		case 1:
			String reid = req.getParameter("reid");
			return "RegisteredServlet?site=1&method=findOneRegistered&reid="+reid;
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 修改挂号信息
	 * @param req
	 * @param resp
	 * @return
	 */
	public String modyfyInfo(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String piid = req.getParameter("piid");
		String retime = req.getParameter("time");
		String doid = req.getParameter("doctor");
		Doctors doctors = dd.findByDoid(doid);
		Typeoftreatment typeoftreatment = doctors.getTypeoftreatment();
		Branch branch = doctors.getBranch();
		Patientinformation patientinformation = pd.findByPiid(piid);
		Registrationfee registrationfee = rd.findByDoid(doid);
		String reid = req.getParameter("reid");
		
		Registered registered = new Registered(reid, typeoftreatment, patientinformation, branch, registrationfee, retime, doctors);
		rrd.modifyRegistered(registered);
		
		//11代表修改挂号记录
		addRecord("11", req, resp);
		
		switch (site) {
		case 0:
			return "RegisteredServlet?method=findAllRegistered&site=0";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 查询所有的挂号记录 返回给页面所有挂号记录集合
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findAllRegistered(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		List<Registered> rlist = rrd.findAll();
		req.setAttribute("rlist", rlist);
		
		
		//10代表查询挂号记录
		addRecord("10", req, resp);
		switch (site) {
		case 0:
			return "/html/Guahao/info.jsp";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 根据挂号单号 返回一个挂号单对象
	 * @param req
	 * @param resp
	 * @return
	 */
	public String findOneRegistered(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String reid = req.getParameter("reid");
		
		Registered registered = rrd.findByReid(reid);
		
		req.setAttribute("registered", registered);
		
		
		addRecord("10", req, resp);
		switch (site) {
		case 0:
			return "html/Guahao/guahaoEdit.jsp";
		case 1:
			return "html/Guahao/guahaoModify.jsp";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 根据就诊卡号与患者姓名查询患者挂号记录
	 * @param req
	 * @param resp
	 * @return
	 */
	public String searchRegistered(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String piid = req.getParameter("piid");
		String piname = req.getParameter("piname");
		System.out.println("piid:"+piid);
		System.out.println("piname:"+piname);
		
		
		if((piid==null || piid.equals("")) && (piname==null || piname.equals(""))) {
			site = 1;
		}else if((piname==null || piname.equals(""))) {
			List<Registered> rlist = rrd.findByPiid(piid);
			req.setAttribute("rlist", rlist);
		}else {
			List<Registered> rlist = rrd.findbyPiname(piname);
			req.setAttribute("rlist", rlist);
		}
		
		//10代表查询挂号记录
		addRecord("10", req, resp);
		
		switch (site) {
		case 0:
			return "/html/Guahao/info.jsp";
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
