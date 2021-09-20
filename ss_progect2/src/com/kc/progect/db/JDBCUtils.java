package com.kc.progect.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.kc.progect.exception.DBException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtils {
	
	private static DataSource datasource;
	
	static {
		datasource = new ComboPooledDataSource("testApp");
	}
	
	public static Connection getConnection() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new DBException("数据库连接异常");
		}
		
	}
	
	public static void release(Connection connection) {
		try {
			DbUtils.close(connection);
		} catch (SQLException e) {
			throw new DBException("数据库连接异常");
		}
	}
	

}
