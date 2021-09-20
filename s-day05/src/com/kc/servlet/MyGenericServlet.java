package com.kc.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 
 * @Descripyion 自定义一个Servlet接口的实现类：让开发的任何Servlet都继承该类，以简化开发
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月10日下午10:13:44
 *
 */
public abstract class MyGenericServlet implements Servlet,ServletConfig {

	private ServletConfig servletConfig;
	
	
	
	/** 以下方法为Servlet接口方法   * */
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.servletConfig = config;
		init();
	}

	//自定义一个空的init方法  声明：该方法为自定义的，所以不在Servlet的生命周期内
	private void init() throws ServletException {
		//用于后代初始化init方法
	}
	
	@Override
	public ServletConfig getServletConfig() {
		
		return servletConfig;
	}

	/**
	 *  每次请求都会必须调用service()方法 因此将其设置为抽象方法
	 */
	@Override
	public abstract void service(ServletRequest req, ServletResponse res) throws ServletException, IOException;

	@Override
	public String getServletInfo() {
		
		return null;
	}

	@Override
	public void destroy() {}
	
	/** 以下方法为ServletConfig接口方法   **/

	@Override
	public String getServletName() {
		return servletConfig.getServletName();
	}

	@Override
	public ServletContext getServletContext() {
		return servletConfig.getServletContext();
	}

	@Override
	public String getInitParameter(String name) {
		return servletConfig.getInitParameter(name);
	}

	@Override
	public Enumeration<String> getInitParameterNames() {
		return servletConfig.getInitParameterNames();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
