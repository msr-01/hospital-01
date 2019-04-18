package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Medicalproject;



//医疗项目
public interface MedicalprojectDao {
	//查询医疗项目信息
	List<Medicalproject> mpfindAll(String suffix);
	
	//用mpid查询
	Medicalproject mpByid(String mpid);
	
	//删除一条医疗项目数据
	void deleteMedicalproject(String mpid);
		
	//增加一条医疗项目数据
	void addMedicalproject(Medicalproject medicalproject);
		
	//根据传入的医疗项目对象，修改数据库中医疗项目数据
	void modifyMedicalproject(Medicalproject medicalproject);

}
