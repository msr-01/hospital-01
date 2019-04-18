package com.msr.hospital.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.msr.hospital.bean.Characte;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.Permission;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.CharacteDao;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.PermissionDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.dao.impl.CharacteDaoImpl;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.PermissionDaoImpl;
import com.msr.hospital.dao.impl.UserInfosDaoImpl;
import com.msr.hospital.util.TimeUtil;
import com.msr.hospital.util.UUIDUtils;

/**
 * Servlet implementation class UserInfosServlet
 */
@WebServlet("/UserInfosServlet")
public class UserInfosServlet extends BaseServlet {
	private UserInfosDao  ud = null;
	private CharacteDao cd = null;
	private OperationRecordDao ord = null;
	private PermissionDao psd = null;
	
	/**
	 * 初始化 私有变量接口
	 */
	@Override
	public void init() throws ServletException {
		ud = new UserInfosDaoImpl();
		cd = new CharacteDaoImpl();
		ord = new OperationRecordDaoImpl();
		psd = new PermissionDaoImpl();
	}
	
	
	
	
	/**
	 * 根据传入的uid 删除对应的UserInfos
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String deleteUserInfosByUid(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String uid = req.getParameter("uid");
		ud.deleteUserInfos(uid);
		
		//3代表删除用户信息
		addRecord("3", req, resp);
		switch (site) {
		case 0:
			return "UserInfosServlet?method=findAllUser&site=0";
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
	
	public String modifyUser(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		

		switch (site) {
		case 0:
			UserInfos userinfos = ud.findByUid(req.getParameter("uid"));
			req.setAttribute("userinfos", userinfos);
			
			return "html/User/userModify.jsp";
		case 1:
			
			Characte characte = cd.findByCid(req.getParameter("cid"));
			
			UserInfos userInfos = new UserInfos(req.getParameter("uid"), characte, req.getParameter("upassword"), req.getParameter("uname"), req.getParameter("ujobtitle"), Integer.parseInt(req.getParameter("uage")), req.getParameter("usex"), req.getParameter("uphonenumber"), Integer.parseInt(req.getParameter("ustatus")), req.getParameter("uemail"), req.getParameter("udescription"), req.getParameter("jobnumber"), null);
			
			ud.modifyUserInfos(userInfos);
			//2代表修改用户信息
			addRecord("2", req, resp);
			return "UserInfosServlet?method=findAllUser&site=0";
		default:
			return "index.jsp";
		}
	}
	
	
	/**
	 * 登陆模块
	 * @param req
	 * @param resp
	 * @return
	 */
	public String login(HttpServletRequest req , HttpServletResponse resp) {
		String jobnumber = req.getParameter("jobnumber");
		String upassword = req.getParameter("upassword");
		
		UserInfos userInfos = ud.findByjobnumber(jobnumber);
		
		if(userInfos==null) {
			System.out.println("工号不存在");
			req.setAttribute("err", 1);
			return "/html/login.jsp";
		}else if(userInfos.getUpassword().equals(upassword)){
			req.getSession().setAttribute("userInfos", userInfos);
			//操作记录类型编号5 为登录
			addRecord("5", req, resp);
			System.out.println("登录成功");
			return "/html/index.jsp";
		}
		System.out.println("密码错误");
		req.setAttribute("err", 2);
		return "/html/login.jsp";
	}
	
	/**
	 * 退出登录 从session中移除 用户信息 并且返回登录页面
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String outlogin(HttpServletRequest req , HttpServletResponse resp) {
		//操作记录编号6为 退出登录
		addRecord("6", req, resp);
		req.getSession().removeAttribute("userInfos");
		System.out.println("退出登录成功");
		return "/html/login.jsp";
	}
	
	/**
	 * 查询所有的用户记录 并返回
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String findAllUser(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		List<UserInfos> ulist = ud.findAll();
		req.setAttribute("ulist", ulist);
		
		
		//1代表查询用户信息
		addRecord("1", req, resp);
		switch (site) {
		case 0:
			return "/html/User/users.jsp";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 添加一条用户信息记录
	 * @param req
	 * @param resp
	 * @return
	 */
	public String addUser(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		
		
		Characte characte = cd.findByCid(req.getParameter("cid"));
		String uid = UUIDUtils.getId();
		UserInfos userInfos = new UserInfos(uid, characte, req.getParameter("upassword"), req.getParameter("uname"), req.getParameter("ujobtitle"), Integer.parseInt(req.getParameter("uage")), req.getParameter("usex"), req.getParameter("uphonenumber"), Integer.parseInt(req.getParameter("ustatus")), req.getParameter("uemail"), req.getParameter("udescription"), req.getParameter("jobnumber"), null);
		
		ud.addUserInfos(userInfos);
		
		
		//2代表添加用户信息
		addRecord("2", req, resp);
		switch (site) {
		case 0:
			return "/html/User/users.jsp";
		default:
			return "index.jsp";
		}
	}
	
	public String search(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		
		String uname = req.getParameter("uname");
		String jobnumber = req.getParameter("jobnumber");
		
		if((uname==null|| uname.equals(""))&&(jobnumber==null || jobnumber.equals(""))) {
			site = 1;
		}else if(uname==null|| uname.equals("")) {
			List<UserInfos> ulist = new ArrayList<UserInfos>();
			UserInfos user = ud.findByjobnumber(jobnumber);
			ulist.add(user);
			req.setAttribute("ulist", ulist);
			
		}else if(jobnumber==null || jobnumber.equals("")) {
			List<UserInfos> ulist = ud.findByUname(uname);
			req.setAttribute("ulist", ulist);
		}
		
		
		//1代表查询用户信息
		addRecord("1", req, resp);
		switch (site) {
		case 0:
			return "/html/User/users.jsp";
		case 1:
			return "UserInfosServlet?method=findAllUser&site=0";
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
