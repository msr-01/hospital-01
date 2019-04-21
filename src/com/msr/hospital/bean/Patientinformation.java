package com.msr.hospital.bean;

import java.util.List;

public class Patientinformation {
	private String piid;
	private String piname;
	private String pisex;
	private int piage;
	private String piphonenumber;
	List<Medicalrecord> mrList;
	public String getPiid() {
		return piid;
	}
	public void setPiid(String piid) {
		this.piid = piid;
	}
	public String getPiname() {
		return piname;
	}
	public void setPiname(String piname) {
		this.piname = piname;
	}
	public String getPisex() {
		return pisex;
	}
	public void setPisex(String pisex) {
		this.pisex = pisex;
	}
	public int getPiage() {
		return piage;
	}
	public void setPiage(int piage) {
		this.piage = piage;
	}
	public String getPiphonenumber() {
		return piphonenumber;
	}
	public void setPiphonenumber(String piphonenumber) {
		this.piphonenumber = piphonenumber;
	}
	public List<Medicalrecord> getMrList() {
		return mrList;
	}
	public void setMrList(List<Medicalrecord> mrList) {
		this.mrList = mrList;
	}
	public Patientinformation(String piid, String piname, String pisex, int piage, String piphonenumber,
			List<Medicalrecord> mrList) {
		super();
		this.piid = piid;
		this.piname = piname;
		this.pisex = pisex;
		this.piage = piage;
		this.piphonenumber = piphonenumber;
		this.mrList = mrList;
	}
	public Patientinformation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
