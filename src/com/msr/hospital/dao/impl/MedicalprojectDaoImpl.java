package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Medicalproject;
import com.msr.hospital.dao.MedicalprojectDao;
import com.msr.hospital.util.DBHelper;

public class MedicalprojectDaoImpl implements MedicalprojectDao {

	@Override
	public List<Medicalproject> findAll() {
		List<Medicalproject> mlist = new ArrayList<Medicalproject>();
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from medicalproject";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Medicalproject medicalproject = new Medicalproject(rs.getString("mpid"),rs.getString("mpname") , rs.getDouble("mpprice"));
				mlist.add(medicalproject);
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
	public List<Medicalproject> findByMpid(String mpid) {
		List<Medicalproject> mlist = new ArrayList<Medicalproject>();
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from medicalproject where mpid like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+mpid+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Medicalproject medicalproject = new Medicalproject(rs.getString("mpid"),rs.getString("mpname") , rs.getDouble("mpprice"));
				mlist.add(medicalproject);
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
	public List<Medicalproject> findByMpname(String mpname) {
		List<Medicalproject> mlist = new ArrayList<Medicalproject>();
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from medicalproject where mpname like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+mpname+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Medicalproject medicalproject = new Medicalproject(rs.getString("mpid"),rs.getString("mpname") , rs.getDouble("mpprice"));
				mlist.add(medicalproject);
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
	public List<Medicalproject> mpfindAll(String suffix) {
		List<Medicalproject> mpList = new ArrayList<Medicalproject>();
		String sql = "select * from Medicalproject where 1=1 "+suffix;
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String mpid = rs.getString("mpid");
				String mpname = rs.getString("mpname");
				double mpprice = rs.getDouble("mpprice");
				Medicalproject medicalproject = new Medicalproject(mpid,mpname,mpprice );
				mpList.add(medicalproject);
			}
			return mpList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}
	
	

	@Override
	public void deleteMedicalproject(String mpid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		String sql = "delete from medicalproject where mpid = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mpid);
			int num = ps.executeUpdate();
			if(num!=0) {
				System.out.println("医疗项目删除成功");
			}else {
				System.out.println("医疗项目删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}

	@Override
	public void addMedicalproject(Medicalproject medicalproject) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		String sql = "insert into medicalproject values (?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, medicalproject.getMpid());
			ps.setString(2, medicalproject.getMpname());
			ps.setDouble(3, medicalproject.getMpprice());
			int num = ps.executeUpdate();
			if(num!=0) {
				System.out.println("医疗项目增加成功");
			}else {
				System.out.println("医疗项目增加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void modifyMedicalproject(Medicalproject medicalproject) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		String sql = "update medicalproject set mpname = ?,mpprice = ? where mpid = ?  ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, medicalproject.getMpname());
			ps.setDouble(2, medicalproject.getMpprice());
			ps.setString(3, medicalproject.getMpid());
			int num = ps.executeUpdate();
			if (num!=0) {
				System.out.println("医疗项目修改成功");
			} else {
				System.out.println("医疗项目修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}



	@Override
	public Medicalproject mpByid(String mpid) {
		
		String sql = "select * from Medicalproject where mpid=?";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mpid);
			rs = ps.executeQuery();
			while (rs.next()) {
				String mpid1 = rs.getString("mpid");
				String mpname = rs.getString("mpname");
				double mpprice = rs.getDouble("mpprice");
				Medicalproject medicalproject = new Medicalproject(mpid1,mpname,mpprice );
				return medicalproject;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}

}
