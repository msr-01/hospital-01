package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Typeoftreatment;
import com.msr.hospital.dao.TypeoftreatmentDao;
import com.msr.hospital.util.DBHelper;

public class TypeoftreatmentDaoImple implements TypeoftreatmentDao{

	@Override
	public List<Typeoftreatment> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Typeoftreatment> tlist = new ArrayList<Typeoftreatment>();
		String sql = "select * from typeoftreatment";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				tlist.add(typeoftreatment);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
				
		return tlist;
	}

	@Override
	public Typeoftreatment findByTyid(String tyid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from typeoftreatment where tyid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tyid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				return typeoftreatment;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
				
		return null;
	}

}
