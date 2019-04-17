package com.msr.hospital.dao;

import com.msr.hospital.bean.Prescription;

public interface PrescriptionDao {
	//根据处方ID查询处方表
	Prescription findByppid(String ppid);

}
