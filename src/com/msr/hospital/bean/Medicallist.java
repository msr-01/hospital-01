package com.msr.hospital.bean;

import java.util.List;

public class Medicallist {
	private String mlid;
	private Medicalproject medicalproject;
	private Prescription prescription;
	private double total;
	public Medicallist(String mlid, Medicalproject medicalproject, Prescription prescription, double total) {
		super();
		this.mlid = mlid;
		this.medicalproject = medicalproject;
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
	public Medicalproject getMedicalproject() {
		return medicalproject;
	}
	public void setMedicalproject(Medicalproject medicalproject) {
		this.medicalproject = medicalproject;
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
