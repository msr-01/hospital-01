package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Medicallist;
import com.msr.hospital.bean.Medicalproject;
import com.msr.hospital.bean.Prescription;
import com.msr.hospital.dao.MedicallistDao;
import com.msr.hospital.dao.MedicalprojectDao;
import com.msr.hospital.util.DBHelper;

public class MedicallistDaoImpl implements MedicallistDao {

	@Override
	public List<Medicallist> findByppid(String ppid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Medicallist> mlist = new ArrayList<Medicallist>();
		MedicalprojectDao md = new MedicalprojectDaoImpl();
		
		String sql = "select * from medicallist where ppid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ppid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Medicalproject medicalproject = md.findByMpid(rs.getString("mpid")).get(0);
				Prescription prescription = new Prescription();
				prescription.setPpid(ppid);
				Medicallist medicallist = new Medicallist(rs.getString("mlid"), medicalproject, prescription, Double.parseDouble(rs.getString("total")));
				mlist.add(medicallist);
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
