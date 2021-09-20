package com.kc.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Test1 implements Servlet{

	
	
	public Test1() {
		System.out.println("Test1的构造。。。。。");
	}

	@Override
	public void destroy() {
		System.out.println("destroy");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("getServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init");
		
//		String name = servletConfig.getInitParameter("test1");
//		System.out.println(name);
		
//		Enumeration<String> initNames = servletConfig.getInitParameterNames();
//		while(initNames.hasMoreElements()){
//			String nextName = initNames.nextElement();
//			String nextNameValue = servletConfig.getInitParameter(nextName);
//			System.out.println("name:"+nextName+", value:"+nextNameValue);
//		}
		
//		String servletName = servletConfig.getServletName();
//		System.out.println(servletName);
		
		ServletContext servletContext = servletConfig.getServletContext();
		
//		String paramName = servletContext.getInitParameter("Driver");
//		System.out.println(paramName);
		
		Enumeration<String> paramNames = servletContext.getInitParameterNames();
		while(paramNames.hasMoreElements()){
			String paramName = paramNames.nextElement();
			String parameValue = servletContext.getInitParameter(paramName);
			System.out.println("name:"+paramName+",value:"+parameValue);
		}
		
		String realPath = servletContext.getRealPath("web.xml");
		System.out.println(realPath);
		//D:\JavaLearn\java\javaEE-workspace\s-day05\WebContent\WEB-INF\web.xml
		//D:\JavaLearn\java\javaEE-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\s-day05\web.xml
		
		System.out.println(servletContext.getContextPath());
		
//		InputStream resourceAsStream = servletContext.getResourceAsStream("/WEB-INF/classes/test1.properties");
//		System.out.println(resourceAsStream);
		
		try {
			
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream resourceAsStream = classLoader.getResourceAsStream("test1.properties");
			System.out.println("test1.proties:"+resourceAsStream);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			
			InputStream resourceAsStream = servletContext.getResourceAsStream("/WEB-INF/classes/test1.properties");
			System.out.println("-->:"+resourceAsStream);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("servlet");
		
	}

}
