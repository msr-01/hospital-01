package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.bean.Doctors;
import com.msr.hospital.bean.Doctortitle;
import com.msr.hospital.bean.Typeoftreatment;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.util.DBHelper;

public class DoctorsDaoImpl implements DoctorsDao {

	@Override
	public List<Doctors> findByBrid(String brid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.brid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, brid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public List<Doctors> findByTyid(String tyid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.tyid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, tyid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public List<Doctors> findByBT(String brid, String tyid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.brid = ? and d.tyid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, brid);
			ps.setString(2, tyid);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public List<Doctors> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public Doctors findByDoid(String doid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		String sql = "select * from doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.doid=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, doid);
			rs = ps.executeQuery();
			while(rs.next()) {
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				return doctors;
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
	public List<Doctors> findByName(String uname) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from userInfos u , doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.uid = u.uid and u.uname like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+uname+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public List<Doctors> findByJobnumber(String jobnumber) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		List<Doctors> dlist = new ArrayList<Doctors>();
		
		String sql = "select * from userInfos u , doctors d , branch b , doctortitle dt , typeoftreatment tt where d.brid=b.brid and d.dtid = dt.dtid and  d.tyid=tt.tyid and d.uid = u.uid and u.jobnumber like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+jobnumber+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Typeoftreatment typeoftreatment = new Typeoftreatment(rs.getString("tyid"), rs.getString("tyname"));
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				Doctortitle doctortitle = new Doctortitle(rs.getString("dtid"), rs.getString("dtname"));
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				Doctors doctors = new Doctors(rs.getString("doid"), branch, doctortitle, userInfos, typeoftreatment);
				dlist.add(doctors);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return dlist;
	}

	@Override
	public void addDoctor(Doctors doctor) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "insert into doctors set doid = ? , brid = ? , dtid = ? , uid = ? , tyid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, doctor.getDoid());
			ps.setString(2, doctor.getBranch().getBrid());
			ps.setString(3, doctor.getDoctortitle().getDtid());
			ps.setString(4, doctor.getUserInfos().getUid());
			ps.setString(5, doctor.getTypeoftreatment().getTyid());
			rs = ps.executeUpdate();
			
			if(rs > 0) {
				System.out.println("doctor添加成功");
			}else {
				System.out.println("doctor添加失败");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void modifyDoctors(Doctors doctors) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "update  doctors set  brid = ? , dtid = ? , uid = ? , tyid = ? where doid = ? ";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(5, doctors.getDoid());
			ps.setString(1, doctors.getBranch().getBrid());
			ps.setString(2, doctors.getDoctortitle().getDtid());
			ps.setString(3, doctors.getUserInfos().getUid());
			ps.setString(4, doctors.getTypeoftreatment().getTyid());
			rs = ps.executeUpdate();
			
			if(rs > 0) {
				System.out.println("doctor修改成功");
			}else {
				System.out.println("doctor修改失败");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void deleteDoctors(String doid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "delete from doctors where doid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, doid);
			rs = ps.executeUpdate();
			
			if(rs > 0) {
				System.out.println("doctor删除成功");
			}else {
				System.out.println("doctor删除失败");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
	}

}
