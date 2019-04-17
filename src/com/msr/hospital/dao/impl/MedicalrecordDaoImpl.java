package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Doctors;
import com.msr.hospital.bean.Medicalrecord;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.Prescription;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.MedicalrecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.PrescriptionDao;
import com.msr.hospital.util.DBHelper;
import com.mysql.jdbc.ConnectionPropertiesTransform;

public class MedicalrecordDaoImpl implements MedicalrecordDao {

	@Override
	public List<Medicalrecord> findByPiid(String piid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DoctorsDao dd = new DoctorsDaoImpl();
		PatientinformationDao pd = new PatientinformationDaoImpl();
		PrescriptionDao ppd = new PrescriptionDaoImpl();
		String sql = "select * from medicalrecord where piid like ?";
		List<Medicalrecord> mrlist = new ArrayList<Medicalrecord>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+piid+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
			
				String ppid = rs.getString("ppid");
				Prescription prescription = ppd.findByppid(ppid);
				Patientinformation patientinformation = pd.findByPiid(rs.getString("piid"));
				Doctors doctors = dd.findByDoid(rs.getString("doid")); 
				Medicalrecord medicalrecord = new Medicalrecord(rs.getString("mrid"), patientinformation, prescription, doctors, rs.getString("diagnosistime"), rs.getString("diagnosisresult"), rs.getString("diagnosismethod"));
				mrlist.add(medicalrecord);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		
		return mrlist;
	}

	@Override
	public List<Medicalrecord> findAll() {
		List<Medicalrecord> mrlist = new ArrayList<Medicalrecord>();
		DoctorsDao dd = new DoctorsDaoImpl();
		PatientinformationDao pd = new PatientinformationDaoImpl();
		PrescriptionDao ppd = new PrescriptionDaoImpl();
		
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from medicalrecord";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				String ppid = rs.getString("ppid");
				Prescription prescription = ppd.findByppid(ppid);
				Patientinformation patientinformation = pd.findByPiid(rs.getString("piid"));
				Doctors doctors = dd.findByDoid(rs.getString("doid")); 
				Medicalrecord medicalrecord = new Medicalrecord(rs.getString("mrid"), patientinformation, prescription, doctors, rs.getString("diagnosistime"), rs.getString("diagnosisresult"), rs.getString("diagnosismethod"));
				mrlist.add(medicalrecord);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return mrlist;
	}

}
