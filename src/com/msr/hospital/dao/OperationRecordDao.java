package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.OperationRecord;

public interface OperationRecordDao {
	//根据用户编号查询该用户所有的操作记录
	List<OperationRecord> findByUid(String uid);
	//根据传进来的用户记录对象 在数据库用户记录表中存储一条操作记录数据
	void addOperationRecord(OperationRecord operationRecord);
	
}
