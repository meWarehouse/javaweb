package com.kc.bookstore.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.DbUtils;

import com.kc.bookstore.exception.DBException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static DataSource dataSource;

	static {
		dataSource = new ComboPooledDataSource("bookstoreApp");
	}

	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("数据库连接错误!");
		}
	}

	public static void release(Connection connection) {
		try {
			DbUtils.close(connection);
		} catch (SQLException e) {
			throw new DBException("数据库连接错误!");
		}
	}

	public static void release(PreparedStatement preparedStatement) {
		try {
			DbUtils.close(preparedStatement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void release(ResultSet resultSet) {
		try {
			DbUtils.close(resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
