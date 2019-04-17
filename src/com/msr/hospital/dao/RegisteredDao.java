package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Registered;

public interface RegisteredDao {
	//添加一条挂号记录
	void addRegistered(Registered registered);
	
	//查询所有挂号信息
	List<Registered> findAll();
	
	//根据挂号ID查询挂号信息
	Registered findByReid(String reid);
	
	//修改挂号信息
	void modifyRegistered(Registered registered);
	
	
	//根据挂号编号删除挂号记录
	void deleteByReid(String reid);
	
	//根据就诊卡号查询患者的挂号记录
	List<Registered> findByPiid(String piid);
	
	//根据患者姓名模糊查询患者的挂号记录
	List<Registered> findbyPiname(String piname);

}
