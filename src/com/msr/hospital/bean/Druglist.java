package com.msr.hospital.bean;

import java.util.List;

public class Druglist {
	private String dlid;
	private Prescription prescription;
	private Drug drug;
	private int drnum;
	private double total;
	public String getDlid() {
		return dlid;
	}
	public void setDlid(String dlid) {
		this.dlid = dlid;
	}
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	public Drug getDrug() {
		return drug;
	}
	public void setDrug(Drug drug) {
		this.drug = drug;
	}
	public int getDrnum() {
		return drnum;
	}
	public void setDrnum(int drnum) {
		this.drnum = drnum;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Druglist(String dlid, Prescription prescription, Drug drug, int drnum, double total) {
		super();
		this.dlid = dlid;
		this.prescription = prescription;
		this.drug = drug;
		this.drnum = drnum;
		this.total = total;
	}
	public Druglist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
