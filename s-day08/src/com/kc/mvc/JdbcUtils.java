package com.kc.mvc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	
	private static DataSource datasource= null;
	
	static {
		
		datasource = new ComboPooledDataSource("testapp");
	}
	
	public static Connection getConnection() throws SQLException {
		return datasource.getConnection();
	}
	
	public static void releaseConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
