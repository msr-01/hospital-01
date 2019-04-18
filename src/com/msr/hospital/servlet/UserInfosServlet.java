package com.msr.hospital.servlet;

import java.io.IOException;
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
	 * 传入UID 生成UserInfos 存入Session中 跳转页面
	 * @param req
	 * @param resp
	 * @return
	 */
	public String getUserInfosByUid(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String uid = req.getParameter("uid");
		UserInfos userInfos = ud.findByUid(uid);
		List<Permission> pslist = psd.findAllPermission();
		req.getSession().setAttribute("userInfos", userInfos);
		req.getSession().setAttribute("pslist", pslist);
		//添加操作记录
		addRecord("4",req,resp);
		
		//跳转页面选择
		switch (site) {
		case 0:
			return "test.jsp";
		default:
			return "index.jsp";
		}
		
	}
	
	
	/**
	 * 获取所有UserInfos信息  返回uList集合 存入 req中转发
	 * @param req
	 * @param resp
	 * @return
	 */
	public String getUserInfosAll(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		List<UserInfos> uList = ud.findAll();
		req.setAttribute("uList", uList);
		
		addRecord("4", req, resp);
		switch (site) {
		case 0:
			return "test.jsp";
		default:
			return "index.jsp";
		}
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
		
		
		addRecord("3", req, resp);
		switch (site) {
		case 0:
			return "UserInfosServlet?method=getUserInfosAll&site=0";
		default:
			return "index.jsp";
		}
	}
	
	/**
	 * 根据传入的参数增加一个UserInfos
	 * @param req
	 * @param resp
	 * @return
	 */
	
	public String addUserInfos(HttpServletRequest req , HttpServletResponse resp) {
		int site = Integer.parseInt(req.getParameter("site"));
		String uid = UUIDUtils.getId();
		String cid = req.getParameter("cid"); //(32)
		String upassword = req.getParameter("upassword");	//varchar(50)
		String uname = req.getParameter("uname");	//varchar(50)
		String ujobtitle = req.getParameter("ujobtitle");	//varchar(50)
		int  uage = Integer.parseInt(req.getParameter("uage"));	//int(11)
		String usex = req.getParameter("usex");	//char(2)
		String uphonenumber = req.getParameter("uphonenumber");	//varchar(50)
		int ustatus = Integer.parseInt(req.getParameter("ustatus"));	 //int(11)
		String uemail = req.getParameter("uemail");	//varchar(100)
		String udescription = req.getParameter("udescription");	//varchar(500)
		String jobnumber = req.getParameter("jobnumber");
		
		Characte characte = cd.findByCid(cid); 
		List<OperationRecord> oList = ord.findByUid(uid);
		UserInfos userinfos = new UserInfos(uid, characte, upassword, uname, ujobtitle, uage, usex, uphonenumber, ustatus, uemail, udescription, jobnumber, oList);
		ud.addUserInfos(userinfos);
		
		
		addRecord("1", req, resp);
		switch (site) {
		case 0:
			return "UserInfosServlet?method=getUserInfosAll&site=0";
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
