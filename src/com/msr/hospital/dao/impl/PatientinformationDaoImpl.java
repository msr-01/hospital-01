package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Medicalrecord;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.dao.MedicalrecordDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.util.DBHelper;

public class PatientinformationDaoImpl implements PatientinformationDao {

	@Override
	public void addPatientinformation(Patientinformation patientinformation) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "insert into patientinformation  (piname,pisex,piage,piphonenumber) values(?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, patientinformation.getPiname());
			ps.setString(2, patientinformation.getPisex());
			ps.setInt(3, patientinformation.getPiage());
			ps.setString(4, patientinformation.getPiphonenumber());
			rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("patientinformation插入成功");
			}else {
				System.out.println("patientinformation插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}

	@Override
	public Patientinformation findByPiid(String piid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalrecordDao md = new MedicalrecordDaoImpl();
		String sql = "select * from patientinformation where piid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, piid);
			rs = ps.executeQuery();
			
			List<Medicalrecord> mrList = md.findByPiid(piid);
			if(rs.next()) {
				return new Patientinformation(piid, rs.getString("piname"),rs.getString("pisex"), rs.getInt("piage"), rs.getString("piphonenumber"), mrList);
			}else {
				System.out.println("patientinformation查询失败");
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
	public List<Patientinformation> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalrecordDao md = new MedicalrecordDaoImpl();
		String sql = "select * from patientinformation";
		List<Patientinformation> plist = new ArrayList<Patientinformation>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				List<Medicalrecord> mrList = md.findByPiid(rs.getString("piid"));
				Patientinformation patientinformation = new Patientinformation(rs.getString("piid"), rs.getString("piname"),rs.getString("pisex"), rs.getInt("piage"), rs.getString("piphonenumber"), mrList);
				plist.add(patientinformation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		
		return plist;
	}

	@Override
	public void modify(Patientinformation patientinformation) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "update  patientinformation set piname = ? ,pisex = ?,piage = ? ,piphonenumber = ? where piid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, patientinformation.getPiname());
			ps.setString(2, patientinformation.getPisex());
			ps.setInt(3, patientinformation.getPiage());
			ps.setString(4, patientinformation.getPiphonenumber());
			ps.setString(5, patientinformation.getPiid());
			rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("patientinformation修改成功");
			}else {
				System.out.println("patientinformation修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void deleteByPiid(String piid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "delete from patientinformation where piid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, piid);
			rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("patientinformation删除成功");
			}else {
				System.out.println("patientinformation删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public List<Patientinformation> findByPhone(String piphonenumber) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalrecordDao md = new MedicalrecordDaoImpl();
		String sql = "select * from patientinformation where piphonenumber like ?";
		List<Patientinformation> plist = new ArrayList<Patientinformation>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+piphonenumber+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				List<Medicalrecord> mrList = md.findByPiid(rs.getString("piid"));
				Patientinformation patientinformation = new Patientinformation(rs.getString("piid"), rs.getString("piname"),rs.getString("pisex"), rs.getInt("piage"), rs.getString("piphonenumber"), mrList);
				plist.add(patientinformation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		
		return plist;
	}

	@Override
	public List<Patientinformation> findByPiname(String piname) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MedicalrecordDao md = new MedicalrecordDaoImpl();
		String sql = "select * from patientinformation where piname like ?";
		List<Patientinformation> plist = new ArrayList<Patientinformation>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+piname+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				List<Medicalrecord> mrList = md.findByPiid(rs.getString("piid"));
				Patientinformation patientinformation = new Patientinformation(rs.getString("piid"), rs.getString("piname"),rs.getString("pisex"), rs.getInt("piage"), rs.getString("piphonenumber"), mrList);
				plist.add(patientinformation);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		
		return plist;
	}

}
