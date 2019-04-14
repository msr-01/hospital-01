package com.msr.hospital.bean;

public class Registrationfee {
	private String rfid;
	private double rfcost;
	private Doctors doctors;
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public double getRfcost() {
		return rfcost;
	}
	public void setRfcost(double rfcost) {
		this.rfcost = rfcost;
	}
	public Doctors getDoctors() {
		return doctors;
	}
	public void setDoctors(Doctors doctors) {
		this.doctors = doctors;
	}
	public Registrationfee(String rfid, double rfcost, Doctors doctors) {
		super();
		this.rfid = rfid;
		this.rfcost = rfcost;
		this.doctors = doctors;
	}
	public Registrationfee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
