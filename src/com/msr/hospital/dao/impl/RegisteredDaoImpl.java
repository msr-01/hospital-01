package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.msr.hospital.bean.Registered;
import com.msr.hospital.dao.RegisteredDao;
import com.msr.hospital.util.DBHelper;

public class RegisteredDaoImpl implements RegisteredDao {

	@Override
	public void addRegistered(Registered registered) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "insert into registered values(?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, registered.getReid());
			ps.setString(2, registered.getTypeoftreatment().getTyid());
			ps.setString(3, registered.getPatientinformation().getPiid());
			ps.setString(4, registered.getBranch().getBrid());
			ps.setString(5, registered.getRegistrationfee().getRfid());
			ps.setString(6, registered.getRetime());
			ps.setString(7, registered.getDoctors().getDoid());
			
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("registered插入成功");
			}else {
				System.out.println("registered插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

}
