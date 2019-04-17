package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.ParameterParser;

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

	@Override
	public void addMedicallist(Medicallist medicallist) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0 ;
		
		String sql = "insert into medicallist values(?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, medicallist.getMlid());
			ps.setString(2, medicallist.getMedicalproject().getMpid());
			ps.setString(3, medicallist.getPrescription().getPpid());
			ps.setDouble(4, medicallist.getTotal());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("medicallist插入成功");
			}else {
				System.out.println("medicallist插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
	}

	

}
