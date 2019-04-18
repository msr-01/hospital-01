package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Characte;

public interface CharacteDao {
	
	//根据角色ID查询一个角色表信息
	Characte findByCid(String cid);
	
	//查询所有角色
	List<Characte> findAllCharacte();
	
	
}
