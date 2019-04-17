package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Medicallist;

public interface MedicallistDao {
	
	//根据处方单号 查找医疗项目
	List<Medicallist> findByppid(String ppid);

}
