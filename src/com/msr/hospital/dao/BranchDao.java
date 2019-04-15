package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Branch;

public interface BranchDao {
	//查询所有科室信息
	List<Branch> findAll();
}
