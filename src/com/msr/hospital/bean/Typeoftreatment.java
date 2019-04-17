package com.msr.hospital.bean;

public class Typeoftreatment {
	private String tyid;
	private String tyname;
	public String getTyid() {
		return tyid;
	}
	public void setTyid(String tyid) {
		this.tyid = tyid;
	}
	public String getTyname() {
		return tyname;
	}
	public void setTyname(String tyname) {
		this.tyname = tyname;
	}
	public Typeoftreatment(String tyid, String tyname) {
		super();
		this.tyid = tyid;
		this.tyname = tyname;
	}
	public Typeoftreatment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
