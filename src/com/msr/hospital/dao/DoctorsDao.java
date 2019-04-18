package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.Doctors;

public interface DoctorsDao {
	//根据科室id查询医生集合
	List<Doctors> findByBrid(String brid);
	//根据挂号类型id查找医生集合
	List<Doctors> findByTyid(String tyid);
	//根据科室名称与挂号类型查找医生集合
	List<Doctors> findByBT(String brid,String tyid);
	//查询全部医生
	List<Doctors> findAll();
	//根据医生编号查询医生信息
	Doctors findByDoid(String doid);
	//根据医生姓名模糊查询医生信息
	List<Doctors> findByName(String uname);
	//根据医生工号模糊查询医生信息
	List<Doctors> findByJobnumber(String jobnumber);
	
	
	//添加医生信息记录
	void addDoctor(Doctors doctor);
	
	//修改医生信息
	void modifyDoctors(Doctors doctors1);
	
	//修改医生信息
	void deleteDoctors(String doid);
	
}
