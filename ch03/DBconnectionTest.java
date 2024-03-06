package com.dongsung.ch03;

import java.sql.*;

public class DBconnectionTest {
	public static void main(String[] args) throws Exception {
		
		String DB_URL = "jdbc:mysql://localhost:3306/springbasic?useUnicode=true&characterEncoding=utf8";
		
		String DB_USER="dongsung";
		String DB_PASSWORD="0000";
		
		Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		Statement stmt = conn.createStatement();
		
		String query = "SELECT now()";
		
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()) {
			String curDate = rs.getString(1);
			System.out.println(curDate);
			
		}
		
	}
	
	
}
