package com.msr.hospital.test;


import com.msr.hospital.bean.Characte;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.dao.impl.OperationRecordDaoImpl;
import com.msr.hospital.dao.impl.UserInfosDaoImpl;
import com.msr.hospital.util.TimeUtil;

public class Test {
	public static void main(String[] args) {
		UserInfosDao uifd = new UserInfosDaoImpl();
		Characte characte = new Characte("1", null, null);
		UserInfos userInfos = new UserInfos("2", characte, "123456", "李晋宇", "院长", 29, "男", "18566666666", 1, "jinyu@qq.com", "独孤九剑", "0002", null);
		uifd.addUserInfos(userInfos);
	}
}
