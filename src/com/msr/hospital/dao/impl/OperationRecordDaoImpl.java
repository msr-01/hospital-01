package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.OperationRecord;
import com.msr.hospital.bean.OperationType;
import com.msr.hospital.bean.UserInfos;
import com.msr.hospital.dao.OperationRecordDao;
import com.msr.hospital.dao.UserInfosDao;
import com.msr.hospital.util.DBHelper;

public class OperationRecordDaoImpl implements OperationRecordDao {

	@Override
	public List<OperationRecord> findByUid(String uid) {
		String sql = "select * from operationrecord opr , operationtype o where opr.uid=? and opr.otid = o.otid";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserInfosDao ud = new UserInfosDaoImpl();
		List<OperationRecord> oList = new ArrayList<OperationRecord>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String orid = rs.getString("orid");	//varchar(32)
				OperationType operationType = new OperationType(rs.getString("otid"), rs.getString("otname"));	//varchar(32)
				String ortime = rs.getString("ortime");	//datetime
				UserInfos userInfos = ud.findByUid(uid);
				OperationRecord operationRecord = new OperationRecord(orid, operationType, ortime, userInfos);
				oList.add(operationRecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return oList;
	}

	@Override
	public void addOperationRecord(OperationRecord operationRecord) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "insert into operationrecord set orid = ?, otid= ? , ortime = ?, uid = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, operationRecord.getOrid());
			ps.setString(2, operationRecord.getOperationType().getOtid());
			ps.setString(3, operationRecord.getOrtime());
			ps.setString(4, operationRecord.getUserInfos().getUid());
			rs = ps.executeUpdate();
			if(rs > 0) {
				System.out.println("OperationRecord插入成功");
			}else {
				System.out.println("OperationRecord插入失败");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public List<OperationRecord> findAll() {
		String sql = "select * from operationrecord opr , operationtype o where opr.otid = o.otid order by ortime desc";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		
		ResultSet rs = null;
		List<OperationRecord> oList = new ArrayList<OperationRecord>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String orid = rs.getString("orid");	//varchar(32)
				OperationType operationType = new OperationType(rs.getString("otid"), rs.getString("otname"));	//varchar(32)
				String ortime = rs.getString("ortime");	//datetime
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				OperationRecord operationRecord = new OperationRecord(orid, operationType, ortime, userInfos);
				oList.add(operationRecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return oList;
	}

	@Override
	public List<OperationRecord> findByJobnumber(String jobnumber) {
		String sql = "select * from userinfos u,operationrecord opr , operationtype o where opr.otid = o.otid and u.uid=opr.uid and u.jobnumber = ? order by ortime desc";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		
		ResultSet rs = null;
		List<OperationRecord> oList = new ArrayList<OperationRecord>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, jobnumber);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String orid = rs.getString("orid");	//varchar(32)
				OperationType operationType = new OperationType(rs.getString("otid"), rs.getString("otname"));	//varchar(32)
				String ortime = rs.getString("ortime");	//datetime
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				OperationRecord operationRecord = new OperationRecord(orid, operationType, ortime, userInfos);
				oList.add(operationRecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return oList;
	}

	@Override
	public List<OperationRecord> findByUname(String uname) {
		String sql = "select * from userinfos u,operationrecord opr , operationtype o where opr.otid = o.otid and u.uid=opr.uid and u.uname like ? order by ortime desc";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		UserInfosDao ud = new UserInfosDaoImpl();
		
		ResultSet rs = null;
		List<OperationRecord> oList = new ArrayList<OperationRecord>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+uname+"%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String orid = rs.getString("orid");	//varchar(32)
				OperationType operationType = new OperationType(rs.getString("otid"), rs.getString("otname"));	//varchar(32)
				String ortime = rs.getString("ortime");	//datetime
				UserInfos userInfos = ud.findByUid(rs.getString("uid"));
				OperationRecord operationRecord = new OperationRecord(orid, operationType, ortime, userInfos);
				oList.add(operationRecord);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		
		return oList;
	}

}
