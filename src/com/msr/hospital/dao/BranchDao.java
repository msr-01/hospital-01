package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.UserInfos;

public interface BranchDao {
	//查询所有科室信息
	List<Branch> findAll();
	
	//根据brid查询科室信息
	Branch findByBrid(String brid);
	
	//删除一条科室数据
	void deleteBranch(String brid);
		
	//增加一条科室数据
	void addBranch(Branch branch);
		
	//根据传入的科室对象，修改数据库中科室数据
	void modifyBranch(Branch branch);
}
