package com.dongsung.ch03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	DataSource ds;
	final int FAIL = 0;
	
	@Override
	public int deleteUser(String id) {
		int rowCnt = FAIL;
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "delete from user_info where id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return FAIL;
		}finally {
			
//			try {if(pstmt!=null) pstmt.close();} catch (SQLException e) {e.printStackTrace();}
//			try {if(conn!=null) conn.close();} catch (SQLException e) {e.printStackTrace();}
			
			close(pstmt,conn);
		}
		
	}
	
	
	@Override
	public User selectUser(String id){
		User user = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from user_info where id=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString(1));
				user.setPwd(rs.getString(2));
				user.setName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setBirth(new Date(rs.getDate(5).getTime()));
				user.setSns(rs.getString(6));
				user.setReg_date(new Date(rs.getTimestamp(7).getTime()));
			}
		} catch (SQLException e) {
			return null;
		}finally {
			close(rs, pstmt, conn);
		}
		return user;
	}
	
	@Override
	public int insertUser(User user) {
		int rowCnt = FAIL;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into user_info values(?,?,?,?,?,?, now())";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPwd());
			pstmt.setString(3, user.getName());
			pstmt.setDate(5, new java.sql.Date(user.getBirth().getTime()));
			pstmt.setString(6, user.getSns());
		
		return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return FAIL;
		}finally {
			close(pstmt, conn);
		}
	}
	
	@Override
	public int updateUser(User user) {
		int rowCnt = FAIL;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
		
		String sql =  "update user_info" + 
					  "set pwd = ?, name=?, email=?, birth=?, sns=?, reg_date=? " +
					  "swhere id = ?";
		
		try( //try-with-resources
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		) {
			pstmt.setString(1, user.getPwd());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setDate(4, new java.sql.Date(user.getBirth().getTime()));
			pstmt.setString(5, user.getSns());
			pstmt.setTimestamp(6, new java.sql.Timestamp(user.getReg_date().getTime()));
			pstmt.setString(7, user.getId());
			
			rowCnt = pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
			return FAIL;
		}
			return rowCnt;
		
	}
	
	@Override
	public void deleteAll() throws Exception{
		Connection conn = ds.getConnection();
		
		String sql = "delete from user_info";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		
	}
	
	
	private void close(AutoCloseable...acs) {
		for(AutoCloseable ac:acs)
			try { if(ac != null) ac.close();} catch(Exception e) { e.printStackTrace();}
	}
}
