package com.msr.hospital.bean;

public class RoleName {
	private String rid;//	varchar(32)
	private String rname;//	varchar(50)
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public RoleName(String rid, String rname) {
		super();
		this.rid = rid;
		this.rname = rname;
	}
	public RoleName() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
