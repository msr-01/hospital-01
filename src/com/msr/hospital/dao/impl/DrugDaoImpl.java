package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.util.DBHelper;

public class DrugDaoImpl implements DrugDao {

	@Override
	public List<Drug> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from drug ";
		List<Drug> drlist = new ArrayList<Drug>(); 
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Drug drug = new Drug(rs.getString("drid"), rs.getString("drname"), rs.getString("drformat"), Double.parseDouble(rs.getString("drunitprice")), rs.getString("drfunction"), rs.getString("drmanufacturer"), rs.getString("dreffectiveperiod"), rs.getString("drinstock"));
				drlist.add(drug);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return drlist;
	}

	@Override
	public Drug findByDrid(String drid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from drug where drid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, drid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Drug(drid, rs.getString("drname"), rs.getString("drformat"), Double.parseDouble(rs.getString("drunitprice")), rs.getString("drfunction"), rs.getString("drmanufacturer"), rs.getString("dreffectiveperiod"), rs.getString("drinstock"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return null;
	}

	@Override
	public List<Drug> findbyDrname(String drname) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from drug where drname like ?";
		List<Drug> drlist = new ArrayList<Drug>(); 
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+drname+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Drug drug = new Drug(rs.getString("drid"), rs.getString("drname"), rs.getString("drformat"), Double.parseDouble(rs.getString("drunitprice")), rs.getString("drfunction"), rs.getString("drmanufacturer"), rs.getString("dreffectiveperiod"), rs.getString("drinstock"));
				drlist.add(drug);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return drlist;
	}

}
