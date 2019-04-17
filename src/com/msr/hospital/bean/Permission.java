package com.msr.hospital.bean;

public class Permission {
	private String peid;	//varchar(32)
	private String pename;	//varchar(50)
	private String Resourceid;	//varchar(50)
	private String pedescription;	//varchar(50)
	private String pelink;	//varchar(50)
	private String peSuperior;	//varchar(50)
	public String getPeid() {
		return peid;
	}
	public void setPeid(String peid) {
		this.peid = peid;
	}
	public String getPename() {
		return pename;
	}
	public void setPename(String pename) {
		this.pename = pename;
	}
	public String getResourceid() {
		return Resourceid;
	}
	public void setResourceid(String resourceid) {
		Resourceid = resourceid;
	}
	public String getPedescription() {
		return pedescription;
	}
	public void setPedescription(String pedescription) {
		this.pedescription = pedescription;
	}
	public String getPelink() {
		return pelink;
	}
	public void setPelink(String pelink) {
		this.pelink = pelink;
	}
	public String getPeSuperior() {
		return peSuperior;
	}
	public void setPeSuperior(String peSuperior) {
		this.peSuperior = peSuperior;
	}
	public Permission(String peid, String pename, String resourceid, String pedescription, String pelink,
			String peSuperior) {
		super();
		this.peid = peid;
		this.pename = pename;
		Resourceid = resourceid;
		this.pedescription = pedescription;
		this.pelink = pelink;
		this.peSuperior = peSuperior;
	}
	public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
