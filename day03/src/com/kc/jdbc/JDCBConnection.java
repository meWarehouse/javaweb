package com.kc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDCBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
		//加载驱动
//		oracle.jdbc.driver.OracleDriver
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
//		System.out.println(forName);
		
//		Connection connection = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		String user = "scott";
		String password = "tiger";
		 
//		connection = DriverManager.getConnection(url, user, password);
//		connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "soctt","tiger");
		
//		System.out.println(connection);
		
		
		Connection conn = null;
		
//		Class.forName("oracle.jdbc.driver.OracleDriver");
		
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
//		String user = "scott";
//		String password = "tiger";
		
		conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
		
	}
	
	
}
