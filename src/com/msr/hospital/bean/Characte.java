package com.msr.hospital.bean;

public class Characte {
	private String cid;	//varchar(32)
	private String rid;	//varchar(32)
	private String cdescription;	//varchar(500)
	public Characte(String cid, String rid, String cdescription) {
		super();
		this.cid = cid;
		this.rid = rid;
		this.cdescription = cdescription;
	}
	public Characte() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getRid() {
		return rid;
	}
	public void setRid(String rid) {
		this.rid = rid;
	}
	public String getCdescription() {
		return cdescription;
	}
	public void setCdescription(String cdescription) {
		this.cdescription = cdescription;
	}
	
	
}
