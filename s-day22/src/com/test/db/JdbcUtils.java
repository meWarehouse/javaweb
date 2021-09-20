package com.test.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static DataSource dataSource;

	static {
		dataSource = new ComboPooledDataSource("testApp");
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void release(Connection connection) {
		try {
			DbUtils.close(connection);
		} catch (SQLException e) {
		}
	}
	
	public static void release(PreparedStatement ps) {
		try {
			DbUtils.close(ps);
		} catch (SQLException e) {
		}
	}
	
	public static void release(ResultSet resultset) {
		try {
			DbUtils.close(resultset);
		} catch (SQLException e) {
		}
	}

	
}
