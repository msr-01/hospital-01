package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Medicalproject;
import com.msr.hospital.dao.MedicalprojectDao;
import com.msr.hospital.util.DBHelper;
//医疗项目
public class MedicalprojectDaoImpl implements MedicalprojectDao{

	@Override
	public List<Medicalproject> mpfindAll(String suffix) {//查询医疗项目信息
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
	public void deleteMedicalproject(String mpid) {//删除一条医疗项目数据
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		String sql = "delete from medicalproject where mpid = ? ";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mpid);
			int num = ps.executeUpdate();
			if(num!=0) {
				System.out.println("医疗项目数据删除成功！！");
			}else {
				System.out.println("医疗项目数据删除失败！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}

	@Override
	public void addMedicalproject(Medicalproject medicalproject) {//增加一条医疗项目数据
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
				System.out.println("数据添加成功！！");
			}else {
				System.out.println("数据添加失败！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void modifyMedicalproject(Medicalproject medicalproject) {//根据传入的医疗项目对象，修改数据库中医疗项目数据
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
				System.out.println("修改成功！！");
			} else {
				System.out.println("修改失败！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}



	@Override
	public Medicalproject mpByid(String mpid) {//查询医疗项目信息
		
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
