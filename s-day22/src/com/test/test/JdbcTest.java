package com.test.test;

import java.sql.Connection;

import com.test.db.JdbcUtils;

public class JdbcTest {

	public static void main(String[] args) {
		
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
		
		
	}
}
