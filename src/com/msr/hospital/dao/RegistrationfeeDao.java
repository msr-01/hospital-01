package com.msr.hospital.dao;

import com.msr.hospital.bean.Registrationfee;

public interface RegistrationfeeDao {
	//根据医生编号查询 挂号费用
	Registrationfee findByDoid(String doid);
}
