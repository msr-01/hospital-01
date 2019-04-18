package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.UserInfos;

public interface UserInfosDao {
	//增加一条用户数据
	void addUserInfos(UserInfos userInfos);
	
	//删除一条用户数据
	void deleteUserInfos(String uid);
	
	//根据用户编号查询一个用户数据， 并返回用户对象
	UserInfos findByUid(String uid);
	
	//查询所有的用户数据
	List<UserInfos> findAll();
	
	//根据传入的用户对象，修改数据库中用户数据
	void modifyUserInfos(UserInfos userInfos);
	
	//根据工号查询用户数据
	UserInfos findByjobnumber(String jobnumber);
	
	//根据姓名模糊查找用户
	List<UserInfos> findByUname(String uname);
}
