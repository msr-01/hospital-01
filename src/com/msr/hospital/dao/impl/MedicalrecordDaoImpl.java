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

	@Override
	public void addMedicalrecord(Medicalrecord medicalrecord) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "insert into medicalrecord value(?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, medicalrecord.getMrid());
			ps.setString(2, medicalrecord.getPatientinformation().getPiid());
			ps.setString(3, medicalrecord.getPrescription().getPpid());
			ps.setString(4, medicalrecord.getDoctors().getDoid());
			ps.setString(5, medicalrecord.getDiagnosistime());
			ps.setString(6, medicalrecord.getDiagnosisresult());
			ps.setString(7, medicalrecord.getDiagnosismethod());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("Medicalrecord插入成功");
			}else {
				System.out.println("Medicalrecord插入失败");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public Medicalrecord findByMrid(String mrid) {
		DoctorsDao dd = new DoctorsDaoImpl();
		PatientinformationDao pd = new PatientinformationDaoImpl();
		PrescriptionDao ppd = new PrescriptionDaoImpl();
		
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from medicalrecord where mrid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mrid);
			rs = ps.executeQuery();
			if(rs.next()) {
				
				String ppid = rs.getString("ppid");
				Prescription prescription = ppd.findByppid(ppid);
				Patientinformation patientinformation = pd.findByPiid(rs.getString("piid"));
				Doctors doctors = dd.findByDoid(rs.getString("doid")); 
				Medicalrecord medicalrecord = new Medicalrecord(rs.getString("mrid"), patientinformation, prescription, doctors, rs.getString("diagnosistime"), rs.getString("diagnosisresult"), rs.getString("diagnosismethod"));
				return medicalrecord;
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
	public void deleteMedicalrecord(Medicalrecord medicalrecord) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		String sql1 = "delete from medicallist where ppid = ?";
		String sql2 = "delete from druglist where ppid = ?";
		String sql3 = "delete from Medicalrecord where mrid = ?";
		
		try {
			ps = conn.prepareStatement(sql1);
			ps.setString(1, medicalrecord.getPrescription().getPpid());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("medicallist删除成功");
			}else {
				System.out.println("medicallist删除失败");
			}
			
			ps.close();
			
			ps = conn.prepareStatement(sql2);
			ps.setString(1, medicalrecord.getPrescription().getPpid());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("druglist删除成功");
			}else {
				System.out.println("druglist删除失败");
			}
			
			ps.close();
			
			ps = conn.prepareStatement(sql3);
			ps.setString(1, medicalrecord.getMrid());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("Medicalrecord删除成功");
			}else {
				System.out.println("Medicalrecord删除失败");
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

}
