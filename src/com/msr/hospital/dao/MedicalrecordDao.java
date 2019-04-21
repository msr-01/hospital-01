package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Medicalrecord;

public interface MedicalrecordDao {
	//根据患者就诊卡号模糊查询患者所有就诊记录
	List<Medicalrecord> findByPiid(String piid);
	
	//查询所有病例信息
	List<Medicalrecord> findAll();
	
	
	//添加病例信息
	void addMedicalrecord(Medicalrecord medicalrecord);
	
	//根据病例编号查询病例信息
	Medicalrecord findByMrid(String mrid);
	
	//根据传入的病例对象删除病例信息
	void deleteMedicalrecord(Medicalrecord medicalrecord);
}
