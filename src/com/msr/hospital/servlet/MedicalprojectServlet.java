package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Medicalproject;
import com.msr.hospital.dao.MedicalprojectDao;
import com.msr.hospital.dao.impl.MedicalprojectDaoImpl;

/**
 * Servlet implementation class MedicalprojectServlet
 */
@WebServlet("/MedicalprojectServlet")
public class MedicalprojectServlet extends BaseServlet {
	MedicalprojectDao  medicalprojectDao = new MedicalprojectDaoImpl();
	//查看信息
	public String MedicalprojectFinAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Medicalproject> mpList = new ArrayList<Medicalproject>();
		
		
		String mpid = request.getParameter("mpid");
		String mpname = request.getParameter("mpname");
		String suffix = "";
		
		if(!"".equals(mpid)&&mpid!=null) {
			suffix = suffix + "and mpid = '"+mpid+"'"; 
			mpList = medicalprojectDao.mpfindAll(suffix);
		}
		if(!"".equals(mpname)&&mpname!=null) {
			suffix = suffix + "and mpname = '"+mpname+"'"; 
			mpList = medicalprojectDao.mpfindAll(suffix);
		}
		mpList = medicalprojectDao.mpfindAll(suffix);
		request.getSession().setAttribute("mpList", mpList);
		
		return "html/medicalproject/medicalproject.jsp";
	}
	
	//添加数据
	public String addMedicalproject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpid = request.getParameter("mpid");
		String mpname = request.getParameter("mpname");
		double mpprice = Double.valueOf(request.getParameter("mpprice"));
		Medicalproject medicalproject = new Medicalproject(mpid,mpname,mpprice);
		
		medicalprojectDao.addMedicalproject(medicalproject);
		return "/MedicalprojectServlet?method=MedicalprojectFinAll";
	}
	//带参数去修改页面
	public String modifyMedicalproject01(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpid = request.getParameter("mpid");
		Medicalproject medicalproject = medicalprojectDao.mpByid(mpid);
		request.getSession().setAttribute("medicalproject", medicalproject);
		return "html/medicalproject/medicalprojectModify.jsp";
	}
	
	//修改数据
	public String modifyMedicalproject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpid = request.getParameter("mpid");
		String mpname = request.getParameter("mpname");
		double mpprice = Double.valueOf(request.getParameter("mpprice"));
		Medicalproject medicalproject = new Medicalproject(mpid,mpname,mpprice);
		
		medicalprojectDao.modifyMedicalproject(medicalproject);
		return "/MedicalprojectServlet?method=MedicalprojectFinAll";
	}
	//删除数据
	public String deleteMedicalproject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mpid = request.getParameter("mpid");
		medicalprojectDao.deleteMedicalproject(mpid);
		return "/MedicalprojectServlet?method=MedicalprojectFinAll";
	}
	

}
