package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.dao.impl.DrugDaoImpl;

/**
 * Servlet implementation class DrugSevlet
 */
@WebServlet("/DrugSevlet")
public class DrugSevlet extends BaseServlet {
	
	public String drugfindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String drid = req.getParameter("drid");
		String drname = req.getParameter("drname");
		List<Drug> drList = new ArrayList<Drug>();
		
		DrugDao drugDao = new DrugDaoImpl();
		System.out.println("=============DrugSevlet=================");
		
		if(!"".equals(drid) && drid!=null) {
			Drug drug = drugDao.findByDrid(drid);
			drList.add(drug);
		}
		
		
		if(!"".equals(drname) && drname!=null ) {
			drList = drugDao.findbyDrname(drname);
		}
		
		
		if("".equals(drid) && "".equals(drname)) {
			drList =  drugDao.findAll();
		}
		req.getSession().setAttribute("drList", drList);
		
		return "/html/Guahao/medicalInfo2.jsp"; 
	}
}