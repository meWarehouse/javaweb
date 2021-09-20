package com.kc.mvcapp.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.kc.mvcapp.db.JdbcUtils;

class JdbcUtilsTest {

	@Test
	void testGetConnection() throws SQLException {
		
		Connection connection = JdbcUtils.getConnection();
		System.out.println(connection);
		
		
	}

}
