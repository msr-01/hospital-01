package com.msr.hospital.test;


import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.dao.impl.UserInfosDaoImpl;
import com.msr.hospital.util.DBHelper;

public class Test {
	public static void main(String[] args) {
		UserInfosDao ud =  new UserInfosDaoImpl();
		UserInfos userInfos = new UserInfos("2", "2", "123456", "李晋宇", "教授", 27, "男", "18555556666", 1, "lijinyu123@qq.com", "冥土追魂","0002");
		
		ud.modifyUserInfos(userInfos);
	}
}
