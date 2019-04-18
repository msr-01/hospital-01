package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.msr.hospital.bean.Branch;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.dao.impl.BranchDaoImple;

/**
 * Servlet implementation class BranchServlet
 */
@WebServlet("/BranchServlet")
public class BranchServlet extends BaseServlet {
	BranchDao BranchDao = new BranchDaoImple();
	/*
	 * 查看科室信息
	 */
	
		
	public String branchFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String brid = req.getParameter("brid");
		String brname = req.getParameter("brname");
		
		List<Branch> brlist = new ArrayList<Branch>();
		
		if(("".equals(brid)||brid==null)&&("".equals(brname)||brname==null)) {
			 brlist = BranchDao.findAll();
		}
		
		if(!"".equals(brid)&&brid!=null) {
			Branch branch =BranchDao.findByBrid(brid);
			brlist.add(branch);
		}
		if(!"".equals(brname)&&brname!=null) {
			 brlist = BranchDao.findByBrname(brname);
		}
		
		req.getSession().setAttribute("brlist", brlist);
		
		return "html/operationRoom/operationRoom.jsp";
	}
	
	/*
	 * 添加科室数据
	 */
	public String branchAddBranch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brid = req.getParameter("brid");
		String brname = req.getParameter("brname");
		String brlocation = req.getParameter("brlocation");
		Branch branch = new Branch(brid,brname,brlocation);
		BranchDao.addBranch(branch);
		System.out.println("branch:"+branch);
		return "BranchServlet?method=branchFindAll";

	}
	
	/*
	 * 删除科室信息
	 */
	public String branchDeleteBranch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brid = req.getParameter("brid");
		BranchDao.deleteBranch(brid);
		return "BranchServlet?method=branchFindAll";
	}
	
	/*
	 * 修改科室信息
	 */
	public String branchModifyBranch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brid = req.getParameter("brid");
		String brname = req.getParameter("brname");
		String brlocation = req.getParameter("brlocation");
		Branch branch = new Branch(brid,brname,brlocation);
		System.out.println("branch:"+branch);
		BranchDao.modifyBranch(branch);
		return "BranchServlet?method=branchFindAll";

	}
	/*
	 * 点击修改跳转页面时传对象
	 */
	public String keshiModify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String brid = req.getParameter("brid");
		if(!"".equals(brid)&&brid!=null) {
			Branch branch =BranchDao.findByBrid(brid);
			req.getSession().setAttribute("branch", branch);
		}
		
		return "/html/operationRoom/keshiModify.jsp";
	}
	
	

}
