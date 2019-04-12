package com.msr.hospital.bean;

public class OperationRecord {
	private String orid;	//varchar(32)
	private OperationType operationType;	//varchar(32)
	private String ortime;	//datetime
	private UserInfos userInfos;	//varchar(32)
	public String getOrid() {
		return orid;
	}
	public void setOrid(String orid) {
		this.orid = orid;
	}
	public OperationType getOperationType() {
		return operationType;
	}
	public void setOperationType(OperationType operationType) {
		this.operationType = operationType;
	}
	public String getOrtime() {
		return ortime;
	}
	public void setOrtime(String ortime) {
		this.ortime = ortime;
	}
	public UserInfos getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(UserInfos userInfos) {
		this.userInfos = userInfos;
	}
	public OperationRecord(String orid, OperationType operationType, String ortime, UserInfos userInfos) {
		super();
		this.orid = orid;
		this.operationType = operationType;
		this.ortime = ortime;
		this.userInfos = userInfos;
	}
	public OperationRecord() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
