package com.kc.mvcapp.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.kc.mvcapp.db.JdbcUtils;

public class T {
	
//	static {
//
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void main(String[] args) throws SQLException {
		
//		Connection connection = JdbcUtils.getConnection();
//		System.out.println(connection);
		
		
//		Connection connection = null;
//		
//		String url ="jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC&&characterEncoding=utf-8&&useUnicode=true&&useSSL=false";
//		String user = "root";
//		String password = "root";
//		
//		try {
//			connection = DriverManager.getConnection(url, user, password);
//			System.out.println("连接成功："+connection);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				if(connection != null) {
//					
//					connection.close();
//				}
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
	
		
		Connection connection1 = JdbcUtils.getConnection();
		System.out.println("--------------"+connection1);
		
		
		
	}
	
}
