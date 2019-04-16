package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Medicalproject;

public interface MedicalprojectDao {
	//查询所有医疗项目
	List<Medicalproject> findAll();
	
	//根据医疗项目编号模糊查询医疗项目信息
	List<Medicalproject> findByMpid(String mpid);
	
	//根据医疗项目名称模糊查询医疗项目信息
	List<Medicalproject> findByMpname(String mpname);
	
}
