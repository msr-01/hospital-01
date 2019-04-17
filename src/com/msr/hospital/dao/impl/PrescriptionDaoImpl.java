package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.msr.hospital.bean.Druglist;
import com.msr.hospital.bean.Medicallist;
import com.msr.hospital.bean.Prescription;
import com.msr.hospital.dao.DruglistDao;
import com.msr.hospital.dao.MedicallistDao;
import com.msr.hospital.dao.PrescriptionDao;
import com.msr.hospital.util.DBHelper;

public class PrescriptionDaoImpl implements PrescriptionDao {

	@Override
	public Prescription findByppid(String ppid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DruglistDao dld = new DruglistDaoImpl();
		MedicallistDao mld = new MedicallistDaoImpl();
		
		String sql = "select * from prescription where ppid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ppid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				List<Medicallist> medicallist = mld.findByppid(ppid);				
				List<Druglist> druglist = dld.findByppid(ppid);
				Prescription prescription = new Prescription(ppid, Integer.parseInt(rs.getString("ppstatus")), rs.getString("ppordertime"), rs.getString("pppaymenttime"), druglist, Double.parseDouble(rs.getString("dltotal")), medicallist, Double.parseDouble(rs.getString("mltotal")), Double.parseDouble(rs.getString("total")));
				return prescription;
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
	public void addPrescription(Prescription prescription) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into prescription values(?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, prescription.getPpid());
			ps.setInt(2, prescription.getPpstatus());
			ps.setString(3, prescription.getPpordertime());
			ps.setString(4, prescription.getPppaymenttime());
			ps.setDouble(5, prescription.getDltotal());
			ps.setDouble(6, prescription.getMltotal());
			ps.setDouble(7, prescription.getTotal());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("Prescription插入成功");
			}else {
				System.out.println("Prescription插入失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
	}

}
