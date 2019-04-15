package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.msr.hospital.bean.Medicalrecord;
import com.msr.hospital.dao.MedicalrecordDao;
import com.msr.hospital.util.DBHelper;
import com.mysql.jdbc.ConnectionPropertiesTransform;

public class MedicalrecordDaoImpl implements MedicalrecordDao {

	@Override
	public List<Medicalrecord> findByPiid(String piid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from medicalrecord where piid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		
		return null;
	}

}
