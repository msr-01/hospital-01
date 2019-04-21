package com.msr.hospital.bean;

public class Drug {
	private String drid;
	private String drname;
	private String drformat;
	private double drunitprice;
	private String drfunction;
	private String drmanufacturer;
	private String dreffectiveperiod;
	private String drinstock;
	public Drug(String drid, String drname, String drformat, double drunitprice, String drfunction,
			String drmanufacturer, String dreffectiveperiod, String drinstock) {
		super();
		this.drid = drid;
		this.drname = drname;
		this.drformat = drformat;
		this.drunitprice = drunitprice;
		this.drfunction = drfunction;
		this.drmanufacturer = drmanufacturer;
		this.dreffectiveperiod = dreffectiveperiod;
		this.drinstock = drinstock;
	}
	public Drug() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getDrid() {
		return drid;
	}
	public void setDrid(String drid) {
		this.drid = drid;
	}
	public String getDrname() {
		return drname;
	}
	public void setDrname(String drname) {
		this.drname = drname;
	}
	public String getDrformat() {
		return drformat;
	}
	public void setDrformat(String drformat) {
		this.drformat = drformat;
	}
	public double getDrunitprice() {
		return drunitprice;
	}
	public void setDrunitprice(double drunitprice) {
		this.drunitprice = drunitprice;
	}
	public String getDrfunction() {
		return drfunction;
	}
	public void setDrfunction(String drfunction) {
		this.drfunction = drfunction;
	}
	public String getDrmanufacturer() {
		return drmanufacturer;
	}
	public void setDrmanufacturer(String drmanufacturer) {
		this.drmanufacturer = drmanufacturer;
	}
	public String getDreffectiveperiod() {
		return dreffectiveperiod;
	}
	public void setDreffectiveperiod(String dreffectiveperiod) {
		this.dreffectiveperiod = dreffectiveperiod;
	}
	public String getDrinstock() {
		return drinstock;
	}
	public void setDrinstock(String drinstock) {
		this.drinstock = drinstock;
	}
	
	
}
