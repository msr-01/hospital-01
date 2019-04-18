package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Permission;
import com.msr.hospital.dao.PermissionDao;
import com.msr.hospital.util.DBHelper;

public class PermissionDaoImpl implements PermissionDao {

	@Override
	public List<Permission> findAllPermission() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Permission> plist = new ArrayList<Permission>();
		
		String sql = "select * from permission";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				Permission permission = new Permission(rs.getString("peid"), rs.getString("pename"), rs.getString("resourceid"), rs.getString("pedescription"), rs.getString("pelink"), rs.getString("peSuperior"));
				plist.add(permission);
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
