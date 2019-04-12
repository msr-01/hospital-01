package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.msr.hospital.bean.Characte;
import com.msr.hospital.bean.RoleName;
import com.msr.hospital.dao.CharacteDao;
import com.msr.hospital.util.DBHelper;

public class CharacteDaoImpl implements CharacteDao {

	@Override
	public Characte findByCid(String cid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from characte c , rolename r where cid = ? and r.cid = c.cid";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cid);
			rs = ps.executeQuery();
			while(rs.next()) {
				String rname = rs.getString("rname");
				RoleName roleName = new RoleName(cid, rname) ;	//varchar(32)
				String cdescription = rs.getString("cdescription");	//varchar(500)
				
				return new Characte(cid, roleName, cdescription);
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
