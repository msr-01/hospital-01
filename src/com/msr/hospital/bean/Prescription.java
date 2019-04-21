package com.msr.hospital.bean;

import java.util.List;

public class Prescription {
	private String ppid;
	private int ppstatus;
	private String ppordertime;
	private String pppaymenttime;
	private List<Druglist> druglist;
	private double dltotal;
	private List<Medicallist> medicallist;
	private double mltotal;
	private double total;
	public String getPpid() {
		return ppid;
	}
	public void setPpid(String ppid) {
		this.ppid = ppid;
	}
	public int getPpstatus() {
		return ppstatus;
	}
	public void setPpstatus(int ppstatus) {
		this.ppstatus = ppstatus;
	}
	public String getPpordertime() {
		return ppordertime;
	}
	public void setPpordertime(String ppordertime) {
		this.ppordertime = ppordertime;
	}
	public String getPppaymenttime() {
		return pppaymenttime;
	}
	public void setPppaymenttime(String pppaymenttime) {
		this.pppaymenttime = pppaymenttime;
	}
	public List<Druglist> getDruglist() {
		return druglist;
	}
	public void setDruglist(List<Druglist> druglist) {
		this.druglist = druglist;
	}
	public double getDltotal() {
		return dltotal;
	}
	public void setDltotal(double dltotal) {
		this.dltotal = dltotal;
	}
	public List<Medicallist> getMedicallist() {
		return medicallist;
	}
	public void setMedicallist(List<Medicallist> medicallist) {
		this.medicallist = medicallist;
	}
	public double getMltotal() {
		return mltotal;
	}
	public void setMltotal(double mltotal) {
		this.mltotal = mltotal;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Prescription(String ppid, int ppstatus, String ppordertime, String pppaymenttime, List<Druglist> druglist,
			double dltotal, List<Medicallist> medicallist, double mltotal, double total) {
		super();
		this.ppid = ppid;
		this.ppstatus = ppstatus;
		this.ppordertime = ppordertime;
		this.pppaymenttime = pppaymenttime;
		this.druglist = druglist;
		this.dltotal = dltotal;
		this.medicallist = medicallist;
		this.mltotal = mltotal;
		this.total = total;
	}
	public Prescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
