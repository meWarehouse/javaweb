package com.kc.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connectiontest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
//		Class<?> forName = Class.forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println(forName);
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "scott", "tiger");
		System.out.println(conn);
		
		
	}
	
}
