package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.util.DBHelper;

public class UserInfosDaoImpl implements UserInfosDao {
	/**
	 * String uid;//varchar(32)
		String cid; //(32)
		String upassword;	//varchar(50)
		String uname;	//varchar(50)
		String ujobtitle;	//varchar(50)
		int  uage;	//int(11)
		String usex;	//char(2)
		String uphonenumber;	//varchar(50)
		int ustatus;	 //int(11)
		String uemail;	//varchar(100)
		String udescription;	//varchar(500)
	 */
	
	@Override
	public void addUserInfos(UserInfos userInfos) {
		String sql = "insert into userinfos values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfos.getUid());
			ps.setString(2, userInfos.getCid());
			ps.setString(3, userInfos.getUpassword());
			ps.setString(4, userInfos.getUname());
			ps.setString(5, userInfos.getUjobtitle());
			ps.setInt(6, userInfos.getUage());
			ps.setString(7, userInfos.getUsex());
			ps.setString(8, userInfos.getUphonenumber());
			ps.setInt(9, userInfos.getUstatus());
			ps.setString(10, userInfos.getUemail());
			ps.setString(11, userInfos.getUdescription());
			ps.setString(12, userInfos.getJobnumber());
			
			rs = ps.executeUpdate();
			
			if(rs>0) {
				System.out.println("UserInfos插入成功");
			}else {
				System.out.println("UserInfos插入失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
	}

	@Override
	public void deleteUserInfos(String uid) {
		Connection conn =DBHelper.getConn();
		String sql = "delete from userinfos where uid = ?";
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeUpdate();
			
			if(rs > 0) {
				System.out.println("UserInfos删除成功");
			}else {
				System.out.println("UserInfos删除失败");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
	}

	@Override
	public UserInfos findByUid(String uid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from userinfos where uid = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String uid1 = rs.getString(1);//varchar(32)
				String cid = rs.getString(2); //(32)
				String upassword= rs.getString(3);	//varchar(50)
				String uname = rs.getString(4);	//varchar(50)
				String ujobtitle = rs.getString(5);	//varchar(50)
				int  uage = rs.getInt(6);	//int(11)
				String usex = rs.getString(7);	//char(2)
				String uphonenumber = rs.getString(8);	//varchar(50)
				int ustatus = rs.getInt(9);	 //int(11)
				String uemail = rs.getString(10);	//varchar(100)
				String udescription = rs.getString(11);	//varchar(500)
				String jobnumber = rs.getString(12);
				
				UserInfos userInfos = new UserInfos(uid1, cid, upassword, uname, ujobtitle, uage, usex, uphonenumber, ustatus, uemail, udescription, jobnumber);
				return userInfos;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		
		
		
		return null;
	}

	@Override
	public List<UserInfos> findAll() {
		String sql = "select * from userinfos";
		List<UserInfos> uList = new ArrayList<UserInfos>();
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				String uid1 = rs.getString(1);//varchar(32)
				String cid = rs.getString(2); //(32)
				String upassword= rs.getString(3);	//varchar(50)
				String uname = rs.getString(4);	//varchar(50)
				String ujobtitle = rs.getString(5);	//varchar(50)
				int  uage = rs.getInt(6);	//int(11)
				String usex = rs.getString(7);	//char(2)
				String uphonenumber = rs.getString(8);	//varchar(50)
				int ustatus = rs.getInt(9);	 //int(11)
				String uemail = rs.getString(10);	//varchar(100)
				String udescription = rs.getString(11);	//varchar(500)
				String jobnumber = rs.getString(12);
				
				UserInfos userInfos = new UserInfos(uid1, cid, upassword, uname, ujobtitle, uage, usex, uphonenumber, ustatus, uemail, udescription, jobnumber);
				uList.add(userInfos);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return uList;
	}

	@Override
	public void modifyUserInfos(UserInfos userInfos) {
		String sql = "update userinfos set cid = ?, upassword = ?, uname = ?, ujobtitle = ?, uage = ?, usex = ?, uphonenumber = ?, ustatus = ?, uemail = ?, udescription = ?, jobnumber = ? where uid = ?";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(12, userInfos.getUid());
			ps.setString(1, userInfos.getCid());
			ps.setString(2, userInfos.getUpassword());
			ps.setString(3, userInfos.getUname());
			ps.setString(4, userInfos.getUjobtitle());
			ps.setInt(5, userInfos.getUage());
			ps.setString(6, userInfos.getUsex());
			ps.setString(7, userInfos.getUphonenumber());
			ps.setInt(8, userInfos.getUstatus());
			ps.setString(9, userInfos.getUemail());
			ps.setString(10, userInfos.getUdescription());
			ps.setString(11, userInfos.getJobnumber());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("UserInfos修改成功");
			}else {
				System.out.println("UserInfos修改失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
		
	}
	
}
