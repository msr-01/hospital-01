package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.util.DBHelper;

public class DrugDaoImpl implements DrugDao {

	@Override
	public List<Drug> findAll() {// 查询所有药物，返回所有药物的集合
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Drug> drList = new ArrayList<Drug>();
		try {
			conn = DBHelper.getConn();
			String sql = "select * from drug";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(1);
				String drid = rs.getString("drid");
				String drname = rs.getString("drname");
				String drformat = rs.getString("drformat");
				double drunitprice = rs.getDouble("drunitprice");
				String drfunction = rs.getString("drfunction");
				String drmanufacturer = rs.getString("drmanufacturer");
				String dreffectiveperiod = rs.getString("dreffectiveperiod");
				String drinstock = rs.getString("drinstock");
				Drug drug = new Drug(drid, drname, drformat, drunitprice, drfunction, drmanufacturer, dreffectiveperiod,
						drinstock);
				drList.add(drug);
			}
			return drList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public Drug findByDrid(String drid) {// 根据药品编号查询药品
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select * from drug where drid=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, drid);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println(2);
				String drid1 = rs.getString("drid");
				String drname = rs.getString("drname");
				String drformat = rs.getString("drformat");
				double drunitprice = rs.getDouble("drunitprice");
				String drfunction = rs.getString("drfunction");
				String drmanufacturer = rs.getString("drmanufacturer");
				String dreffectiveperiod = rs.getString("dreffectiveperiod");
				String drinstock = rs.getString("drinstock");
				Drug drug = new Drug(drid1, drname, drformat, drunitprice, drfunction, drmanufacturer,
						dreffectiveperiod, drinstock);
				return drug;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Drug> findbyDrname(String drname) {// 根据药品名模糊查询药品，返回药品集合
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Drug> drList = new ArrayList<Drug>();
		try {
			conn = DBHelper.getConn();
			String sql = "select * from drug where  drname = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, drname);
			rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println(3);
				String drid = rs.getString("drid");
				String drname1 = rs.getString("drname");
				String drformat = rs.getString("drformat");
				double drunitprice = rs.getDouble("drunitprice");
				String drfunction = rs.getString("drfunction");
				String drmanufacturer = rs.getString("drmanufacturer");
				String dreffectiveperiod = rs.getString("dreffectiveperiod");
				String drinstock = rs.getString("drinstock");
				Drug drug = new Drug(drid, drname1, drformat, drunitprice, drfunction, drmanufacturer,
						dreffectiveperiod, drinstock);
				drList.add(drug);
			}
			return drList;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public void addDrug(Drug drug) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "insert into drug (drid,drname,drformat,drunitprice,drfunction,drmanufacturer,dreffectiveperiod,drinstock) values(?,?,?,?,?,?,?,?)";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, drug.getDrid());
			ps.setString(2, drug.getDrname());
			ps.setString(3, drug.getDrformat());
			ps.setDouble(4, drug.getDrunitprice());
			ps.setString(5, drug.getDrfunction());
			ps.setString(6, drug.getDrmanufacturer());
			ps.setString(7, drug.getDreffectiveperiod());
			ps.setString(8, drug.getDrinstock());
			rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("drug添加成功");
			}else {
				System.out.println("drug添加失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}

	@Override
	public void deleteByDrid(String drid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "delete from drug where drid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, drid);
			rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("drug删除成功");
			}else {
				System.out.println("drug删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}

	@Override
	public void modifyDrug(Drug drug) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update drug set drname = ?,drformat = ?,drunitprice = ?,drfunction = ?,drmanufacturer = ?,dreffectiveperiod = ?,drinstock = ? where drid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, drug.getDrname());
			ps.setString(2, drug.getDrformat());
			ps.setDouble(3, drug.getDrunitprice());
			ps.setString(4, drug.getDrfunction());
			ps.setString(5, drug.getDrmanufacturer());
			ps.setString(6, drug.getDreffectiveperiod());
			ps.setString(7, drug.getDrinstock());
			ps.setString(8, drug.getDrid());
			rs = ps.executeUpdate();
			if(rs>0) {
				System.out.println("drug修改成功");
			}else {
				System.out.println("drug修改失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
	}
}
