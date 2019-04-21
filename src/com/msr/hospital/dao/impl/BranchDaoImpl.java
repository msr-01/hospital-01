package com.msr.hospital.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.msr.hospital.bean.Branch;
import com.msr.hospital.dao.BranchDao;
import com.msr.hospital.util.DBHelper;

public class BranchDaoImpl implements BranchDao {

	@Override
	public List<Branch> findAll() {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Branch> blist = new ArrayList<Branch>();
		String sql = "select * from branch";
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				blist.add(branch);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return blist;
	}

	@Override
	public Branch findByBrid(String brid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from branch where brid =?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, brid);
			rs = ps.executeQuery();
			while(rs.next()) {
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				return branch;
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
	public List<Branch> findByBrname(String brname) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Branch> blist = new ArrayList<Branch>();
		String sql = "select * from branch where brname like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+brname+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				blist.add(branch);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return blist;
	}

	@Override
	public List<Branch> findByBridM(String brid) {
		Connection conn = DBHelper.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Branch> blist = new ArrayList<Branch>();
		String sql = "select * from branch where brid like ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+brid+"%");
			rs = ps.executeQuery();
			while(rs.next()) {
				Branch branch = new Branch(rs.getString("brid"), rs.getString("brname"), rs.getString("brlocation"));
				blist.add(branch);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, rs);
		}
		return blist;
	}

	@Override
	public void deleteBranch(String brid) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from Branch where brid = ?";
		try {
			conn = DBHelper.getConn();
			ps = conn .prepareStatement(sql);
			ps.setString(1, brid);
			int num = ps.executeUpdate();
			if(num!=0) {
				System.out.println("科室信息删除成功");
			}else {
				System.out.println("科室信息删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void addBranch(Branch branch) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into branch values (?,?,?)";
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, branch.getBrid());
			ps.setString(2, branch.getBrname());
			ps.setString(3, branch.getBrlocation());
			
			int num = ps.executeUpdate();
			 
			if(num!=0) {
				System.out.println("科室信息增加成功");
			}else {
				System.out.println("科室信息增加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

	@Override
	public void modifyBranch(Branch branch) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update Branch set brname = ?, brlocation = ? where brid = ?";
		try {
			conn = DBHelper.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, branch.getBrname());
			ps.setString(2, branch.getBrlocation());
			ps.setString(3, branch.getBrid());
			
			int num = ps.executeUpdate();
			if (num !=0) {
				System.out.println("科室信息修改成功");
			}else {
				System.out.println("科室信息修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBHelper.close(conn, ps, null);
		}
		
	}

}
