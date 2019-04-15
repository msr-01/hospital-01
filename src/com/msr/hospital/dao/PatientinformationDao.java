package com.msr.hospital.dao;

import com.msr.hospital.bean.Patientinformation;

public interface PatientinformationDao {
	//增加一名患者信息
	void addPatientinformation(Patientinformation patientinformation);
	
	//根据就诊卡号返回患者信息
	Patientinformation findByPiid(String piid);
	
	
	
}
