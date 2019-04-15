package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Typeoftreatment;

public interface TypeoftreatmentDao {
	//查询所有的就诊类型信息
	List<Typeoftreatment> findAll();
}
