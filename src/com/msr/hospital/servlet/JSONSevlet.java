package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.Doctors;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.Registrationfee;
import com.msr.hospital.bean.Typeoftreatment;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.dao.impl.BranchDaoImpl;
import com.msr.hospital.dao.impl.DoctorsDaoImpl;
import com.msr.hospital.dao.impl.PatientinformationDaoImpl;
import com.msr.hospital.dao.impl.RegistrationfeeDaoImpl;
import com.msr.hospital.dao.impl.TypeoftreatmentDaoImple;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class JSONSevlet
 */
@WebServlet("/JSONSevlet")
public class JSONSevlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		System.out.println("==============JSONSevlet=============");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		DoctorsDao dd = new DoctorsDaoImpl();
		BranchDao bd = new BranchDaoImpl();
		RegistrationfeeDao rd = new RegistrationfeeDaoImpl();
		PatientinformationDao pd = new PatientinformationDaoImpl();
		
		String method = req.getParameter("method");
		
		if("1".equals(method)) {
			String tyid = req.getParameter("tyid");
			String brid = req.getParameter("brid");
			
			System.out.println("tyid："+tyid);
			System.out.println("brid："+brid);
			
			if(tyid==null || tyid.trim().equals("")) {
				List<Doctors> dlist = dd.findByTyid(tyid);
				JSONArray jr = JSONArray.fromObject(dlist);
				resp.getWriter().println(jr);
				resp.getWriter().flush();
				resp.getWriter().close();
				return;
			}else if(brid==null || brid.trim().equals("")) {
				List<Doctors> dlist = dd.findByBrid(brid);
				JSONArray jr = JSONArray.fromObject(dlist);
				resp.getWriter().println(jr);
				resp.getWriter().flush();
				resp.getWriter().close();
				return;
			}else {
				List<Doctors> dlist = dd.findByBT(brid, tyid);
				JSONArray jr = JSONArray.fromObject(dlist);
				resp.getWriter().println(jr);
				resp.getWriter().flush();
				resp.getWriter().close();
				return;
			}
		}else if("2".equals(method)) {
			String brid = req.getParameter("brid");
			Branch branch = bd.findByBrid(brid);
			JSONObject jsonobj = JSONObject.fromObject(branch);
			resp.getWriter().println(jsonobj);
			resp.getWriter().flush();
			resp.getWriter().close();
		}else if("3".equals(method)) {
			String doid = req.getParameter("doid");
			Registrationfee cost = rd.findByDoid(doid);
			JSONObject jsonobj = JSONObject.fromObject(cost);
			resp.getWriter().println(jsonobj);
			resp.getWriter().flush();
			resp.getWriter().close();
		}else if("4".equals(method)) {
			String piid = req.getParameter("piid");
			Patientinformation patientinformation = pd.findByPiid(piid);
			System.out.println(patientinformation);
			if(patientinformation==null) {
				
			}else {
				JSONObject jsonobj = JSONObject.fromObject(patientinformation);
				resp.getWriter().println(jsonobj);
				resp.getWriter().flush();
				resp.getWriter().close();
			}
			
		}
		
	}
}
