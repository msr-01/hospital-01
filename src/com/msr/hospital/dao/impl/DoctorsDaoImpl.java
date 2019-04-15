package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.Doctors;
import com.msr.hospital.bean.Doctortitle;
import com.msr.hospital.bean.Typeoftreatment;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.util.DBHelper;

public class DoctorsDaoImpl implements DoctorsDao {

	@Override
	public List<Doctors> findByBrid(String brid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.brid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, brid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public List<Doctors> findByTyid(String tyid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.tyid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tyid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public List<Doctors> findByBT(String brid, String tyid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.brid = ? and d.tyid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, brid);
			ps.setString(2, tyid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public List<Doctors> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

}
