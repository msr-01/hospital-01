package com.msr.hospital.dao;

import java.util.List;

import com.msr.hospital.bean.OperationRecord;

public interface OperationRecordDao {
	List<OperationRecord> findByUid(String uid);
	void addOperationRecord(OperationRecord operationRecord);
	
}
