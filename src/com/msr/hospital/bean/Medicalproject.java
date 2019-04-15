package com.msr.hospital.bean;

public class Medicalproject {
	private String mpid;
	private String mpname;
	private double mpprice;
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
