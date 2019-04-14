package com.msr.hospital.dao;

import com.msr.hospital.bean.Characte;

public interface CharacteDao {
	
	//根据角色ID查询一个角色表信息
	Characte findByCid(String cid);
}
