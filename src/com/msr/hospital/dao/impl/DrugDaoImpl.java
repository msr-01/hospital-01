package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.util.DBHelper;

public class DrugDaoImpl implements DrugDao {

	@Override
	public List<Drug> findAll() {//查询所有药物，返回所有药物的集合
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
				String drid= rs.getString("drid");
				String drname= rs.getString("drname");
				String drformat= rs.getString("drformat");
				double drunitprice= rs.getDouble("drunitprice");
				String drfunction= rs.getString("drfunction");
				String drmanufacturer= rs.getString("drmanufacturer");
				String dreffectiveperiod= rs.getString("dreffectiveperiod");
				String drinstock= rs.getString("drinstock");
				Drug drug = new Drug(drid,drname,drformat,drunitprice,drfunction,drmanufacturer,dreffectiveperiod,drinstock);
				drList.add(drug);
			}
			return drList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public Drug findByDrid(String drid) {//根据药品编号查询药品
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
				String drid1= rs.getString("drid");
				String drname= rs.getString("drname");
				String drformat= rs.getString("drformat");
				double drunitprice= rs.getDouble("drunitprice");
				String drfunction= rs.getString("drfunction");
				String drmanufacturer= rs.getString("drmanufacturer");
				String dreffectiveperiod= rs.getString("dreffectiveperiod");
				String drinstock= rs.getString("drinstock");
				Drug drug = new Drug(drid1,drname,drformat,drunitprice,drfunction,drmanufacturer,dreffectiveperiod,drinstock);
				return drug;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}

	@Override
	public List<Drug> findbyDrname(String drname) {//根据药品名模糊查询药品，返回药品集合
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
				String drid= rs.getString("drid");
				String drname1= rs.getString("drname");
				String drformat= rs.getString("drformat");
				double drunitprice= rs.getDouble("drunitprice");
				String drfunction= rs.getString("drfunction");
				String drmanufacturer= rs.getString("drmanufacturer");
				String dreffectiveperiod= rs.getString("dreffectiveperiod");
				String drinstock= rs.getString("drinstock");
				Drug drug = new Drug(drid,drname1,drformat,drunitprice,drfunction,drmanufacturer,dreffectiveperiod,drinstock);
				drList.add(drug);
			}
			return drList;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return null;
	}

}
