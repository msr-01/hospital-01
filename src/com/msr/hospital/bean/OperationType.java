package com.msr.hospital.bean;

public class OperationType {
	private String otid;	//varchar(32)
	private String otname;	//varchar(50)
	public String getOtid() {
		return otid;
	}
	public void setOtid(String otid) {
		this.otid = otid;
	}
	public String getOtname() {
		return otname;
	}
	public void setOtname(String otname) {
		this.otname = otname;
	}
	public OperationType(String otid, String otname) {
		super();
		this.otid = otid;
		this.otname = otname;
	}
	public OperationType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
