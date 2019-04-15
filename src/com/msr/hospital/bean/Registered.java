package com.msr.hospital.bean;

public class Registered {
	private String reid;
	private Typeoftreatment typeoftreatment;
	private Patientinformation patientinformation;
	private Branch branch;
	private Registrationfee registrationfee;
	private String retime;
	private Doctors doctors;
	public String getReid() {
		return reid;
	}
	public void setReid(String reid) {
		this.reid = reid;
	}
	public Typeoftreatment getTypeoftreatment() {
		return typeoftreatment;
	}
	public void setTypeoftreatment(Typeoftreatment typeoftreatment) {
		this.typeoftreatment = typeoftreatment;
	}
	public Patientinformation getPatientinformation() {
		return patientinformation;
	}
	public void setPatientinformation(Patientinformation patientinformation) {
		this.patientinformation = patientinformation;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Registrationfee getRegistrationfee() {
		return registrationfee;
	}
	public void setRegistrationfee(Registrationfee registrationfee) {
		this.registrationfee = registrationfee;
	}
	public String getRetime() {
		return retime;
	}
	public void setRetime(String retime) {
		this.retime = retime;
	}
	public Doctors getDoctors() {
		return doctors;
	}
	public void setDoctors(Doctors doctors) {
		this.doctors = doctors;
	}
	public Registered(String reid, Typeoftreatment typeoftreatment, Patientinformation patientinformation,
			Branch branch, Registrationfee registrationfee, String retime, Doctors doctors) {
		super();
		this.reid = reid;
		this.typeoftreatment = typeoftreatment;
		this.patientinformation = patientinformation;
		this.branch = branch;
		this.registrationfee = registrationfee;
		this.retime = retime;
		this.doctors = doctors;
	}
	public Registered() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
