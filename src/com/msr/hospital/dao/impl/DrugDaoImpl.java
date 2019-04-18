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
	public List<Drug> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from drug ";
		List<Drug> drlist = new ArrayList<Drug>(); 
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Drug drug = new Drug(rs.getString("drid"), rs.getString("drname"), rs.getString("drformat"), Double.parseDouble(rs.getString("drunitprice")), rs.getString("drfunction"), rs.getString("drmanufacturer"), rs.getString("dreffectiveperiod"), rs.getString("drinstock"));
				drlist.add(drug);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return drlist;
	}

	@Override
	public Drug findByDrid(String drid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from drug where drid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, drid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				return new Drug(drid, rs.getString("drname"), rs.getString("drformat"), Double.parseDouble(rs.getString("drunitprice")), rs.getString("drfunction"), rs.getString("drmanufacturer"), rs.getString("dreffectiveperiod"), rs.getString("drinstock"));
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
	public List<Drug> findbyDrname(String drname) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from drug where drname like ?";
		List<Drug> drlist = new ArrayList<Drug>(); 
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+drname+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Drug drug = new Drug(rs.getString("drid"), rs.getString("drname"), rs.getString("drformat"), Double.parseDouble(rs.getString("drunitprice")), rs.getString("drfunction"), rs.getString("drmanufacturer"), rs.getString("dreffectiveperiod"), rs.getString("drinstock"));
				drlist.add(drug);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return drlist;
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
				System.out.println("drug娣诲姞鎴愬姛");
			}else {
				System.out.println("drug娣诲姞澶辫触");
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
				System.out.println("drug鍒犻櫎鎴愬姛");
			}else {
				System.out.println("drug鍒犻櫎澶辫触");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}

		
	}

}
