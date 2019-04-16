package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.util.DBHelper;

public class DrugDaoImpl implements DrugDao {

	@Override
	public List<Drug> findAll() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
