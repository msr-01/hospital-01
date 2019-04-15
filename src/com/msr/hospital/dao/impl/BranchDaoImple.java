package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.util.DBHelper;

public class BranchDaoImple implements BranchDao {

	@Override
	public List<Branch> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Branch> blist = new ArrayList<Branch>();
		String sql = "select * from branch";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				blist.add(branch);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return blist;
	}

}
