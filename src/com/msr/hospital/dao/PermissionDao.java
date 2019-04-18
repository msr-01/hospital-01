package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Permission;

public interface PermissionDao {
	
	//查询所有的权限信息
	List<Permission> findAllPermission();
}
