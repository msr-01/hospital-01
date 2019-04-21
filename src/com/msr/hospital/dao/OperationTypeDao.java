package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.OperationType;

public interface OperationTypeDao {
	//根据操作类型编号返回一个 操作类型对象
	OperationType findByOtid(String otid);
	
	//返回所有的操作类型
	List<OperationType> findAll();
	
	//在数据库中增加一条操作类型
	void addOperationType(OperationType operationType);
	
	//根据操作类型编号 在数据库中删除一个操作类型
	void deleteOperationTypeByOtid(String otid);
}
