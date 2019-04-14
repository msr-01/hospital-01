package com.msr.hospital.bean;

import java.util.List;

public class Druglist {
	private String dlid;
	private Prescription prescription;
	private List<Drug> dlist;
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
	public List<Drug> getDlist() {
		return dlist;
	}
	public void setDlist(List<Drug> dlist) {
		this.dlist = dlist;
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
	public Druglist(String dlid, Prescription prescription, List<Drug> dlist, int drnum, double total) {
		super();
		this.dlid = dlid;
		this.prescription = prescription;
		this.dlist = dlist;
		this.drnum = drnum;
		this.total = total;
	}
	public Druglist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
