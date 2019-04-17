package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.bean.Druglist;
import com.msr.hospital.bean.Prescription;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.dao.DruglistDao;
import com.msr.hospital.util.DBHelper;

public class DruglistDaoImpl implements DruglistDao {

	@Override
	public List<Druglist> findByppid(String ppid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DrugDao dd = new DrugDaoImpl();
		List<Druglist> dlist = new ArrayList<Druglist>();
		
		
		String sql = "select * from druglist where ppid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ppid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Prescription prescription = new Prescription();
				prescription.setPpid(ppid);
				String drid = rs.getString("drid");
				Drug drug = dd.findByDrid(drid);
				Druglist druglist = new Druglist(rs.getString("dlid"), prescription, drug, Integer.parseInt(rs.getString("drnum")), Double.parseDouble(rs.getString("total")));
				dlist.add(druglist);
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
