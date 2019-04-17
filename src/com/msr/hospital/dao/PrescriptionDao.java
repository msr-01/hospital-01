package com.msr.hospital.dao;

import com.msr.hospital.bean.Prescription;

public interface PrescriptionDao {
	//根据处方ID查询处方表
	Prescription findByppid(String ppid);
	
	//添加处方信息
	void addPrescription(Prescription prescription);

}
