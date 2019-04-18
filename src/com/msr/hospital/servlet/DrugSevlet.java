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

		if (!"".equals(drid) && drid != null) {
			Drug drug = drugDao.findByDrid(drid);
			drList.add(drug);
		}

		if (!"".equals(drname) && drname != null) {
			drList = drugDao.findbyDrname(drname);
		}

		if ("".equals(drid) && "".equals(drname)) {
			drList = drugDao.findAll();
		}
		req.setAttribute("drList", drList);

		return "/html/Guahao/medicalInfo2.jsp";
	}

	public String medicinefindAll(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String drid = req.getParameter("drid");
		String drname = req.getParameter("drname");
		List<Drug> drList = new ArrayList<Drug>();

		DrugDao drugDao = new DrugDaoImpl();
		System.out.println("=============DrugSevlet=================");

		if (!"".equals(drid) && drid != null) {
			Drug drug = drugDao.findByDrid(drid);
			drList.add(drug);
		}

		if (!"".equals(drname) && drname != null) {
			drList = drugDao.findbyDrname(drname);
		}

		if ("".equals(drid) && "".equals(drname)) {
			drList = drugDao.findAll();
		}
		req.setAttribute("drList", drList);

		return "/html/medicine/medicine.jsp";
	}

	public String addDrug(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String drid = req.getParameter("drid");
		String drname = req.getParameter("drname");
		String drformat = req.getParameter("drformat");
		double drunitprice = Double.parseDouble(req.getParameter("drunitprice"));
		String drfunction = req.getParameter("drfunction");
		String drmanufacturer = req.getParameter("rmanufacturer");
		String dreffectiveperiod = req.getParameter("dreffectiveperiod");
		String drinstock = req.getParameter("drinstock");

		Drug drug = new Drug();
		drug.setDrid(drid);
		drug.setDrname(drname);
		drug.setDrformat(drformat);
		drug.setDrunitprice(drunitprice);
		drug.setDrfunction(drfunction);
		drug.setDrmanufacturer(drmanufacturer);
		drug.setDreffectiveperiod(dreffectiveperiod);
		drug.setDrinstock(drinstock);

		DrugDao drugdao = new DrugDaoImpl();
		drugdao.addDrug(drug);

		return "/html/medicine/medicine.jsp";
	}

	public String ModifyDrug(HttpServletRequest req, HttpServletResponse resp) {
		String drid = req.getParameter("drid");
		String drname = req.getParameter("drname");
		String drformat = req.getParameter("drformat");
		double drunitprice = Double.parseDouble(req.getParameter("drunitprice"));
		String drfunction = req.getParameter("drfunction");
		String drmanufacturer = req.getParameter("drmanufacturer");
		String dreffectiveperiod = req.getParameter("dreffectiveperiod");
		String drinstock = req.getParameter("drinstock");
	     
	     
	    Drug drug = new Drug(drid, drname, drformat, drunitprice, drfunction, drmanufacturer, dreffectiveperiod, drinstock);
	    
		DrugDao drugdao = new DrugDaoImpl();
		drugdao.modifyDrug(drug);
		
		return "/html/medicine/medicine.jsp";
	}
	
	public String ModifyDrug1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String drid = req.getParameter("drid");
		
		DrugDao drugDao = new DrugDaoImpl();
		
		Drug drug = drugDao.findByDrid(drid);
		
		req.setAttribute("drug", drug);
		
		return "/html/medicine/medicineModify.jsp";
	}

	public String deleteDrug(HttpServletRequest req, HttpServletResponse resp) {
		
		String drid = req.getParameter("drid");
        	
        DrugDao drugdao = new DrugDaoImpl();
        
        drugdao.deleteByDrid(drid);

		return "/html/medicine/medicine.jsp";
	}
	
	
}
