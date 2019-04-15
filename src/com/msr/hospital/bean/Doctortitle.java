package com.msr.hospital.bean;

public class Doctortitle {
	private String dtid;
	private String dtname;
	public String getDtid() {
		return dtid;
	}
	public void setDtid(String dtid) {
		this.dtid = dtid;
	}
	public String getDtname() {
		return dtname;
	}
	public void setDtname(String dtname) {
		this.dtname = dtname;
	}
	public Doctortitle(String dtid, String dtname) {
		super();
		this.dtid = dtid;
		this.dtname = dtname;
	}
	public Doctortitle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
