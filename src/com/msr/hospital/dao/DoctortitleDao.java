package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Doctortitle;

public interface DoctortitleDao {
	//查询所有医生职称
	List<Doctortitle> findAllDoctortitle();
}
