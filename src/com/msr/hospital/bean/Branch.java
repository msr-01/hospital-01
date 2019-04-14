package com.msr.hospital.bean;

public class Branch {
	private String brid;
	private String brname;
	private String brlocation;
	public String getBrid() {
		return brid;
	}
	public void setBrid(String brid) {
		this.brid = brid;
	}
	public String getBrname() {
		return brname;
	}
	public void setBrname(String brname) {
		this.brname = brname;
	}
	public String getBrlocation() {
		return brlocation;
	}
	public void setBrlocation(String brlocation) {
		this.brlocation = brlocation;
	}
	public Branch(String brid, String brname, String brlocation) {
		super();
		this.brid = brid;
		this.brname = brname;
		this.brlocation = brlocation;
	}
	public Branch() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
