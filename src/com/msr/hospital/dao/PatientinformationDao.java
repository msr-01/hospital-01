package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Patientinformation;

public interface PatientinformationDao {
	//增加一名患者信息
	void addPatientinformation(Patientinformation patientinformation);
	
	//根据就诊卡号返回患者信息
	Patientinformation findByPiid(String piid);
	
	//查询所有的患者信息
	List<Patientinformation> findAll();
	
	//修改患者信息
	void modify(Patientinformation patientinformation);
	
	//根据就诊卡号删除患者信息
	void deleteByPiid(String piid);
	
	//根据患者手机号码模糊查询患者信息
	List<Patientinformation> findByPhone(String piphonenumber);
	
	//根据患者姓名模糊查询患者信息
	List<Patientinformation> findByPiname(String piname);
	
	
	
}
