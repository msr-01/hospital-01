package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Branch;

public interface BranchDao {
	//查询所有科室信息
	List<Branch> findAll();
	
	//根据brid查询科室信息
	Branch findByBrid(String brid);
	
	//根据科室名称模糊查询科室信息
	List<Branch> findByBrname(String brname);
	
	//根据科室id模糊查询科室信息
	List<Branch> findByBridM(String brid);
	
	
	//删除科室信息
	void deleteBranch(String brid);
	
	//增加科室信息
	void addBranch(Branch branch);
	
	//修改科室信息
	void modifyBranch(Branch branch);
}
