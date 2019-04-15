package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Doctors;
import com.msr.hospital.bean.Patientinformation;
import com.msr.hospital.bean.Registered;
import com.msr.hospital.bean.Registrationfee;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.PatientinformationDao;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.util.DBHelper;

public class RegisteredDaoImpl implements RegisteredDao {

	@Override
	public void addRegistered(Registered registered) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "insert into registered values(?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, registered.getReid());
			ps.setString(2, registered.getTypeoftreatment().getTyid());
			ps.setString(3, registered.getPatientinformation().getPiid());
			ps.setString(4, registered.getBranch().getBrid());
			ps.setString(5, registered.getRegistrationfee().getRfid());
			ps.setString(6, registered.getRetime());
			ps.setString(7, registered.getDoctors().getDoid());
			
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("registered插入成功");
			}else {
				System.out.println("registered插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public List<Registered> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Registered> rlist = new ArrayList<Registered>();
		DoctorsDao dd = new DoctorsDaoImpl();
		PatientinformationDao pd = new PatientinformationDaoImpl();
		RegistrationfeeDao rd = new RegistrationfeeDaoImpl();
		String sql = "select * from registered order by retime desc";	
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String doid = rs.getString("doid");
				Doctors doctors = dd.findByDoid(doid);
				String piid = rs.getString("piid");	
				Patientinformation patientinformation = pd.findByPiid(piid);
				Registrationfee registrationfee = rd.findByDoid(doid);
				Registered registered = new Registered(rs.getString("reid"), doctors.getTypeoftreatment(), patientinformation, doctors.getBranch(), registrationfee, rs.getString("retime"), doctors);
				rlist.add(registered);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return rlist;
	}

	@Override
	public Registered findByReid(String reid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Registered> rlist = new ArrayList<Registered>();
		DoctorsDao dd = new DoctorsDaoImpl();
		PatientinformationDao pd = new PatientinformationDaoImpl();
		RegistrationfeeDao rd = new RegistrationfeeDaoImpl();
		String sql = "select * from registered where reid = ?";	
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String doid = rs.getString("doid");
				Doctors doctors = dd.findByDoid(doid);
				String piid = rs.getString("piid");	
				Patientinformation patientinformation = pd.findByPiid(piid);
				Registrationfee registrationfee = rd.findByDoid(doid);
				return new Registered(rs.getString("reid"), doctors.getTypeoftreatment(), patientinformation, doctors.getBranch(), registrationfee, rs.getString("retime"), doctors);
				
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
	public void modifyRegistered(Registered registered) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "update registered set tyid=?,piid=?,brid=?,rfid=?,retime=?,doid=? where reid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(7, registered.getReid());
			ps.setString(1, registered.getTypeoftreatment().getTyid());
			ps.setString(2, registered.getPatientinformation().getPiid());
			ps.setString(3, registered.getBranch().getBrid());
			ps.setString(4, registered.getRegistrationfee().getRfid());
			ps.setString(5, registered.getRetime());
			ps.setString(6, registered.getDoctors().getDoid());
			
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("registered修改成功");
			}else {
				System.out.println("registered修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void deleteByReid(String reid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "delete from registered where reid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, reid);
			rs = ps.executeUpdate();
			if(rs > 0 ) {
				System.out.println("registered删除成功");
			}else {
				System.out.println("registered删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
		
	}

}
