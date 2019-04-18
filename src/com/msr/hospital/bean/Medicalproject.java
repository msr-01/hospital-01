package com.msr.hospital.bean;

public class Medicalproject {
	private String mpid;//		医疗项目编号	mpid		varchar(32)primary key,
	private String mpname;//	医疗项目名称	mpname		varchar(50),
	private double mpprice;//	医疗项目价格	mpprice		double
	public String getMpid() {
		return mpid;
		
	}
	public void setMpid(String mpid) {
		this.mpid = mpid;
	}
	public String getMpname() {
		return mpname;
	}
	public void setMpname(String mpname) {
		this.mpname = mpname;
	}
	public double getMpprice() {
		return mpprice;
	}
	public void setMpprice(double mpprice) {
		this.mpprice = mpprice;
	}
	public Medicalproject(String mpid, String mpname, double mpprice) {
		super();
		this.mpid = mpid;
		this.mpname = mpname;
		this.mpprice = mpprice;
	}
	public Medicalproject() {
		super();
		
	}
	
	
}
