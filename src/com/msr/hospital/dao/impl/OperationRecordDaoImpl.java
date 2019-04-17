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
import com.msr.hospital.util.DBHelper;

public class OperationRecordDaoImpl implements OperationRecordDao {

	@Override
	public List<OperationRecord> findByUid(String uid) {
		String sql = "select * from operationrecord opr , operationtype o where opr.uid=? and opr.otid = o.otid";
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<OperationRecord> oList = new ArrayList<OperationRecord>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uid);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String orid = rs.getString("orid");	//varchar(32)
				OperationType operationType = new OperationType(rs.getString("otid"), rs.getString("otname"));	//varchar(32)
				String ortime = rs.getString("ortime");	//datetime
				UserInfos userInfos = new UserInfos();	//varchar(32)
				userInfos.setUid(uid);
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

}
