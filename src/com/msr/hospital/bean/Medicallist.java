package com.msr.hospital.bean;

import java.util.List;

public class Medicallist {
	private String mlid;
	private List<Medicalproject> mList;
	private Prescription prescription;
	private double total;
	public Medicallist(String mlid, List<Medicalproject> mList, Prescription prescription, double total) {
		super();
		this.mlid = mlid;
		this.mList = mList;
		this.prescription = prescription;
		this.total = total;
	}
	public Medicallist() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getMlid() {
		return mlid;
	}
	public void setMlid(String mlid) {
		this.mlid = mlid;
	}
	public List<Medicalproject> getmList() {
		return mList;
	}
	public void setmList(List<Medicalproject> mList) {
		this.mList = mList;
	}
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
