package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Characte;
import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.RoleName;
import com.msr.hospital.bean.Rolepermissions;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.util.DBHelper;

public class UserInfosDaoImpl implements UserInfosDao {
	
	@Override
	public void addUserInfos(UserInfos userInfos) {
		String sql = "insert into userinfos values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, userInfos.getUid());
			ps.setString(2, userInfos.getCharacte().getCid());
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
		String sql = "select * from userinfos u , characte c , rolename r ,rolepermissions rm where u.uid = ? and u.cid = c.cid and c.cid=rm.cid and c.rid = r.rid";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			OperationRecordDao ord = new OperationRecordDaoImpl();
			if(rs.next()) {
				String cid = rs.getString("cid"); //(32)
				String upassword= rs.getString("upassword");	//varchar(50)
				String uname = rs.getString("uname");	//varchar(50)
				String ujobtitle = rs.getString("ujobtitle");	//varchar(50)
				int  uage = rs.getInt("uage");	//int(11)
				String usex = rs.getString("usex");	//char(2)
				String uphonenumber = rs.getString("uphonenumber");	//varchar(50)
				int ustatus = rs.getInt("ustatus");	 //int(11)
				String uemail = rs.getString("uemail");	//varchar(100)
				String udescription = rs.getString("udescription");	//varchar(500)
				String jobnumber = rs.getString("jobnumber");
				String cdescription = rs.getString("cdescription");
				String rid = rs.getString("rid");
				String rname = rs.getString("rname");
				RoleName roleName = new RoleName(rid, rname);
				
				Rolepermissions rolepermissions = new Rolepermissions(cid, rs.getString("popedom"));
				Characte characte = new Characte(cid, roleName, cdescription, rolepermissions);
				
				UserInfos userInfos = new UserInfos(uid, characte, upassword, uname, ujobtitle, uage, usex, uphonenumber, ustatus, uemail, udescription, jobnumber, null);
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
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from userinfos u , characte c , rolename r ,rolepermissions rm where  u.cid = c.cid and c.cid=rm.cid and c.rid = r.rid";
		List<UserInfos> ulist = new ArrayList<UserInfos>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			OperationRecordDao ord = new OperationRecordDaoImpl();
			while(rs.next()) {
				String uid = rs.getString("uid");
				String cid = rs.getString("cid"); //(32)
				String upassword= rs.getString("upassword");	//varchar(50)
				String uname = rs.getString("uname");	//varchar(50)
				String ujobtitle = rs.getString("ujobtitle");	//varchar(50)
				int  uage = rs.getInt("uage");	//int(11)
				String usex = rs.getString("usex");	//char(2)
				String uphonenumber = rs.getString("uphonenumber");	//varchar(50)
				int ustatus = rs.getInt("ustatus");	 //int(11)
				String uemail = rs.getString("uemail");	//varchar(100)
				String udescription = rs.getString("udescription");	//varchar(500)
				String cdescription = rs.getString("cdescription");
				String rid = rs.getString("rid");
				String rname = rs.getString("rname");
				RoleName roleName = new RoleName(rid, rname);
				
				Rolepermissions rolepermissions = new Rolepermissions(cid, rs.getString("popedom"));
				Characte characte = new Characte(cid, roleName, cdescription, rolepermissions);
				List<OperationRecord> oList = ord.findByUid(uid);
				
				UserInfos userInfos = new UserInfos(uid, characte, upassword, uname, ujobtitle, uage, usex, uphonenumber, ustatus, uemail, udescription, rs.getString("jobnumber"), oList);
				ulist.add(userInfos);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return ulist;
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
			ps.setString(1, userInfos.getCharacte().getCid());
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

	@Override
	public UserInfos findByjobnumber(String jobnumber) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from userinfos u , characte c , rolename r ,rolepermissions rm where u.jobnumber = ? and u.cid = c.cid and c.cid=rm.cid and c.rid = r.rid";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, jobnumber);
			rs = ps.executeQuery();
			OperationRecordDao ord = new OperationRecordDaoImpl();
			if(rs.next()) {
				String uid = rs.getString("uid");
				String cid = rs.getString("cid"); //(32)
				String upassword= rs.getString("upassword");	//varchar(50)
				String uname = rs.getString("uname");	//varchar(50)
				String ujobtitle = rs.getString("ujobtitle");	//varchar(50)
				int  uage = rs.getInt("uage");	//int(11)
				String usex = rs.getString("usex");	//char(2)
				String uphonenumber = rs.getString("uphonenumber");	//varchar(50)
				int ustatus = rs.getInt("ustatus");	 //int(11)
				String uemail = rs.getString("uemail");	//varchar(100)
				String udescription = rs.getString("udescription");	//varchar(500)
				String cdescription = rs.getString("cdescription");
				String rid = rs.getString("rid");
				String rname = rs.getString("rname");
				RoleName roleName = new RoleName(rid, rname);
				
				
				Rolepermissions rolepermissions = new Rolepermissions(cid, rs.getString("popedom"));
				Characte characte = new Characte(cid, roleName, cdescription, rolepermissions);

				UserInfos userInfos = new UserInfos(uid, characte, upassword, uname, ujobtitle, uage, usex, uphonenumber, ustatus, uemail, udescription, jobnumber, null);
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
	public List<UserInfos> findByUname(String uname) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from userinfos u , characte c , rolename r ,rolepermissions rm where  u.cid = c.cid and c.cid=rm.cid and c.rid = r.rid and uname like  ?";
		List<UserInfos> ulist = new ArrayList<UserInfos>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+uname+"%");
			rs = ps.executeQuery();
			OperationRecordDao ord = new OperationRecordDaoImpl();
			while(rs.next()) {
				String uid = rs.getString("uid");
				String cid = rs.getString("cid"); //(32)
				String upassword= rs.getString("upassword");	//varchar(50)
				String ujobtitle = rs.getString("ujobtitle");	//varchar(50)
				int  uage = rs.getInt("uage");	//int(11)
				String usex = rs.getString("usex");	//char(2)
				String uphonenumber = rs.getString("uphonenumber");	//varchar(50)
				int ustatus = rs.getInt("ustatus");	 //int(11)
				String uemail = rs.getString("uemail");	//varchar(100)
				String udescription = rs.getString("udescription");	//varchar(500)
				String cdescription = rs.getString("cdescription");
				String rid = rs.getString("rid");
				String rname = rs.getString("rname");
				RoleName roleName = new RoleName(rid, rname);
				
				Rolepermissions rolepermissions = new Rolepermissions(cid, rs.getString("popedom"));
				Characte characte = new Characte(cid, roleName, cdescription, rolepermissions);
				List<OperationRecord> oList = ord.findByUid(uid);
				
				UserInfos userInfos = new UserInfos(uid, characte, upassword, rs.getString("uname"), ujobtitle, uage, usex, uphonenumber, ustatus, uemail, udescription, rs.getString("jobnumber"), oList);
				ulist.add(userInfos);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return ulist;
	}
	
}
