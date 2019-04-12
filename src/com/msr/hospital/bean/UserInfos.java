package com.msr.hospital.bean;

import java.util.List;

public class UserInfos {
	private String uid;//varchar(32)
	private Characte characte; //(32)
	private String upassword;	//varchar(50)
	private String uname;	//varchar(50)
	private String ujobtitle;	//varchar(50)
	private int  uage;	//int(11)
	private String usex;	//char(2)
	private String uphonenumber;	//varchar(50)
	private int ustatus;	 //int(11)
	private String uemail;	//varchar(100)
	private String udescription;	//varchar(500)
	private String jobnumber;
	private List<OperationRecord> oList;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Characte getCharacte() {
		return characte;
	}
	public void setCharacte(Characte characte) {
		this.characte = characte;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUjobtitle() {
		return ujobtitle;
	}
	public void setUjobtitle(String ujobtitle) {
		this.ujobtitle = ujobtitle;
	}
	public int getUage() {
		return uage;
	}
	public void setUage(int uage) {
		this.uage = uage;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public String getUphonenumber() {
		return uphonenumber;
	}
	public void setUphonenumber(String uphonenumber) {
		this.uphonenumber = uphonenumber;
	}
	public int getUstatus() {
		return ustatus;
	}
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUdescription() {
		return udescription;
	}
	public void setUdescription(String udescription) {
		this.udescription = udescription;
	}
	public String getJobnumber() {
		return jobnumber;
	}
	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}
	public List<OperationRecord> getoList() {
		return oList;
	}
	public void setoList(List<OperationRecord> oList) {
		this.oList = oList;
	}
	public UserInfos(String uid, Characte characte, String upassword, String uname, String ujobtitle, int uage,
			String usex, String uphonenumber, int ustatus, String uemail, String udescription, String jobnumber,
			List<OperationRecord> oList) {
		super();
		this.uid = uid;
		this.characte = characte;
		this.upassword = upassword;
		this.uname = uname;
		this.ujobtitle = ujobtitle;
		this.uage = uage;
		this.usex = usex;
		this.uphonenumber = uphonenumber;
		this.ustatus = ustatus;
		this.uemail = uemail;
		this.udescription = udescription;
		this.jobnumber = jobnumber;
		this.oList = oList;
	}
	public UserInfos() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
