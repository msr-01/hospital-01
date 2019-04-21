package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Drug;
import com.msr.hospital.bean.Druglist;
import com.msr.hospital.bean.Prescription;
import com.msr.hospital.dao.DrugDao;
import com.msr.hospital.dao.DruglistDao;
import com.msr.hospital.util.DBHelper;

public class DruglistDaoImpl implements DruglistDao {

	@Override
	public List<Druglist> findByppid(String ppid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DrugDao dd = new DrugDaoImpl();
		List<Druglist> dlist = new ArrayList<Druglist>();
		
		
		String sql = "select * from druglist where ppid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ppid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Prescription prescription = new Prescription();
				prescription.setPpid(ppid);
				String drid = rs.getString("drid");
				Drug drug = dd.findByDrid(drid);
				Druglist druglist = new Druglist(rs.getString("dlid"), prescription, drug, Integer.parseInt(rs.getString("drnum")), Double.parseDouble(rs.getString("total")));
				dlist.add(druglist);
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
	public void addDruglist(Druglist druglist) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into druglist values(?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, druglist.getDlid());
			ps.setString(2, druglist.getPrescription().getPpid());
			ps.setString(3, druglist.getDrug().getDrid());
			ps.setInt(4, druglist.getDrnum());
			ps.setDouble(5, druglist.getTotal());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("druglist插入成功");
			}else {
				System.out.println("druglist插入失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	
	
	
}
