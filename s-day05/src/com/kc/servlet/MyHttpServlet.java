package com.kc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @Descripyion 针对于HTTP协议定义一个Servlet基类
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月10日下午11:13:58
 *
 */
public class MyHttpServlet extends MyGenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		if(req instanceof HttpServletRequest){
			HttpServletRequest request = (HttpServletRequest) req;
			
			if(res instanceof HttpServletRequest){
				HttpServletResponse response = (HttpServletResponse)res;
				
				service(request, response);
				
			}
		}
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取请求方式
		String method = request.getMethod();
		
		//2.根据请求方式在调用对用的处理方法
		if("GET".equalsIgnoreCase(method)){
			doGet(request,response);
		}else if("POST".equalsIgnoreCase(method)){
			doPost(request,response);
		}
		
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
