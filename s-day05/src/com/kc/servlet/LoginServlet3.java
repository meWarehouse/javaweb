package com.kc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet3 extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3541L;

	
	/*
	需求：
		在SQL数据库中创建一个表格test_user数据表，添加3个字段ids usernames，passwords 并录入几条数据
	
		定义一个login.html，里面定义两个请求字段：users，passwords，发送请求到loginServlet
		再创建一个LoginServlet(继承HttpServlet,并重写doPostfangfa ),
		在其中获取请求的user，password，
		
		利用JDBC从test_user中查询有没有和页面输入的user，password 对应记录
		
		SELECT count(id) FROM test_user WHERE users = ? AND passwords = ?
		
		若一致，响应Hello:xxx,若不响应Sorry:xxx  xxx为user
	*/
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
