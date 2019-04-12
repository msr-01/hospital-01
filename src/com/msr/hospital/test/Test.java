package com.msr.hospital.test;

import java.sql.Connection;

import com.msr.hospital.util.DBHelper;

public class Test {
	public static void main(String[] args) {
		Connection conn = DBHelper.getConn();
		System.out.println(conn);
		
		DBHelper.close(conn, null, null);
		
		
	}
}
