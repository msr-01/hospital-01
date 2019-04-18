package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Doctortitle;
import com.msr.hospital.dao.DoctortitleDao;
import com.msr.hospital.util.DBHelper;

public class DoctortitleDaoImpl implements DoctortitleDao {

	@Override
	public List<Doctortitle> findAllDoctortitle() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Doctortitle> dtlist = new ArrayList<Doctortitle>();
		
		String sql = "select * from doctortitle";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				
				dtlist.add(doctortitle);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		
		return dtlist;
	}
	
}
