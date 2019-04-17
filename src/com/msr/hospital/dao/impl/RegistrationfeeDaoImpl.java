package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.msr.hospital.bean.Doctors;
import com.msr.hospital.bean.Registrationfee;
import com.msr.hospital.dao.DoctorsDao;
import com.msr.hospital.dao.RegistrationfeeDao;
import com.msr.hospital.util.DBHelper;

public class RegistrationfeeDaoImpl implements RegistrationfeeDao {

	@Override
	public Registrationfee findByDoid(String doid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		DoctorsDao dd = new DoctorsDaoImpl();
		String sql = "select * from registrationfee where doid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, doid);
			rs = ps.executeQuery();
			if(rs.next()) {
				Doctors doctors = dd.findByDoid(doid);
				Registrationfee registrationfee = new Registrationfee(rs.getString("rfid"), rs.getDouble("rfcost"), doctors);
				return registrationfee;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return null;
	}

}
