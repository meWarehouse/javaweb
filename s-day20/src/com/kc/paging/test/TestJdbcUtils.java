package com.kc.paging.test;

import java.sql.SQLException;

import com.kc.paging.db.JdbcUtils;

public class TestJdbcUtils {
	public static void main(String[] args) throws SQLException {
		
		System.out.println(JdbcUtils.getConnection());
	}
}
