package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Medicalproject;
import com.msr.hospital.dao.MedicalprojectDao;
import com.msr.hospital.util.DBHelper;

public class MedicalprojectDaoImpl implements MedicalprojectDao {

	@Override
	public List<Medicalproject> findAll() {
		List<Medicalproject> mlist = new ArrayList<Medicalproject>();
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from medicalproject";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Medicalproject medicalproject = new Medicalproject(rs.getString("mpid"),rs.getString("mpname") , rs.getDouble("mpprice"));
				mlist.add(medicalproject);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return mlist;
	}

	@Override
	public List<Medicalproject> findByMpid(String mpid) {
		List<Medicalproject> mlist = new ArrayList<Medicalproject>();
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from medicalproject where mpid like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+mpid+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Medicalproject medicalproject = new Medicalproject(rs.getString("mpid"),rs.getString("mpname") , rs.getDouble("mpprice"));
				mlist.add(medicalproject);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return mlist;
	}

	@Override
	public List<Medicalproject> findByMpname(String mpname) {
		List<Medicalproject> mlist = new ArrayList<Medicalproject>();
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from medicalproject where mpname like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+mpname+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Medicalproject medicalproject = new Medicalproject(rs.getString("mpid"),rs.getString("mpname") , rs.getDouble("mpprice"));
				mlist.add(medicalproject);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return mlist;
	}

}
