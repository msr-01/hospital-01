package com.msr.hospital.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.msr.hospital.util.DBHelper;

public class Test {
	public static void main(String[] args) {
		Connection conn = DBHelper.getConn();
		System.out.println(conn);
		String sql = "select * from characte";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
	}
}
