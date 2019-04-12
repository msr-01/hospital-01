package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.OperationType;

public interface OperationTypeDao {
	OperationType findByOtid(String otid);
	List<OperationType> findAll();
	void addOperationType(OperationType operationType);
	void deleteOperationTypeByOtid(String otid);
}
