package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Drug;

public interface DrugDao {
	//查询所有药物，返回所有药物的集合
	List<Drug> findAll();
	//根据药品编号查询药品
	Drug findByDrid(String drid);
	//根据药品名模糊查询药品，返回药品集合
	List<Drug> findbyDrname(String drname);
	//增加药品信息
	void addDrug(Drug drug);
	//修改药品信息
	void modifyDrug(Drug drug);
	//根据药品编号删除药品信息
	void deleteByDrid(String drid);

}
