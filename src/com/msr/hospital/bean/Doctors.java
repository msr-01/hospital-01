package com.msr.hospital.bean;

public class Doctors {
	private String doid;
	private Branch branch;
	private Doctortitle doctortitle;
	private UserInfos userInfos;
	private Typeoftreatment typeoftreatment;
	
	
	public String getDoid() {
		return doid;
	}
	public void setDoid(String doid) {
		this.doid = doid;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Doctortitle getDoctortitle() {
		return doctortitle;
	}
	public void setDoctortitle(Doctortitle doctortitle) {
		this.doctortitle = doctortitle;
	}
	public UserInfos getUserInfos() {
		return userInfos;
	}
	public void setUserInfos(UserInfos userInfos) {
		this.userInfos = userInfos;
	}
	public Typeoftreatment getTypeoftreatment() {
		return typeoftreatment;
	}
	public void setTypeoftreatment(Typeoftreatment typeoftreatment) {
		this.typeoftreatment = typeoftreatment;
	}
	public Doctors(String doid, Branch branch, Doctortitle doctortitle, UserInfos userInfos,
			Typeoftreatment typeoftreatment) {
		super();
		this.doid = doid;
		this.branch = branch;
		this.doctortitle = doctortitle;
		this.userInfos = userInfos;
		this.typeoftreatment = typeoftreatment;
	}
	public Doctors() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
