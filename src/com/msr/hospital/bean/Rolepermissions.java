package com.msr.hospital.bean;

public class Rolepermissions {
	private String cid ; 
	private String popedom;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getPopedom() {
		return popedom;
	}
	public void setPopedom(String popedom) {
		this.popedom = popedom;
	}
	public Rolepermissions(String cid, String popedom) {
		super();
		this.cid = cid;
		this.popedom = popedom;
	}
	public Rolepermissions() {
		super();
		// TODO Auto-generated constructor stub
	}
}
