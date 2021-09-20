package com.kc.bookstore.test;

import java.sql.Connection;

import com.kc.bookstore.db.JdbcUtils;

public class TestJdbcUtils {
	public static void main(String[] args) {

		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);

	}
}
