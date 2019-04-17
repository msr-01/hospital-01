package com.msr.hospital.bean;

public class Characte {
	private String cid;	//varchar(32)
	private RoleName roleName;	//varchar(32)
	private String cdescription;	//varchar(500)
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public RoleName getRoleName() {
		return roleName;
	}
	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	public Characte(String cid, RoleName roleName, String cdescription) {
		super();
		this.cid = cid;
		this.roleName = roleName;
		this.cdescription = cdescription;
	}
	public Characte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
