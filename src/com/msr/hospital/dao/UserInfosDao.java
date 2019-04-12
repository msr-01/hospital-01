package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.UserInfos;

public interface UserInfosDao {
	void addUserInfos(UserInfos userInfos);
	void deleteUserInfos(String uid);
	UserInfos findByUid(String uid);
	List<UserInfos> findAll();
	void modifyUserInfos(UserInfos userInfos);
}
