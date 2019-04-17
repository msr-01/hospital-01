package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Druglist;

public interface DruglistDao {
	
	//根据药单号 查找药单
	List<Druglist> findByppid(String ppid);

}
