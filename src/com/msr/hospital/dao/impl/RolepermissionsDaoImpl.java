package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.msr.hospital.bean.Rolepermissions;
import com.msr.hospital.dao.RolepermissionsDao;
import com.msr.hospital.util.DBHelper;

public class RolepermissionsDaoImpl implements RolepermissionsDao {

	@Override
	public void modifyRolepermissions(Rolepermissions rolepermissions) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		String sql = "update rolepermissions set popedom = ? where cid = ?";
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, rolepermissions.getPopedom());
			ps.setString(2, rolepermissions.getCid());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("rolepermissions修改成功");
			}else {
				System.out.println("rolepermissions修改失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
	}

}
