package com.kc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/*
 * 改用继承自定的的Servlet实现类MyGenericServlet
 * 
 */
public class LoginServlet extends MyGenericServlet{

//	private ServletConfig servletConfig;
	
//	@Override
//	public void init(ServletConfig servletConfig) throws ServletException {
//		
//		this.servletConfig = servletConfig;
//	}
	

	/****/
	//对当前Servlet进行初始化  覆盖init方法
	/**
	 * NullPointerException 异常
	 * 	原因:
	 * 		在此初始化Servlet覆盖init方法，那么调用时就会使得该方法的父层init被覆盖并使其失效，如此以来就无法使用其父类的init初始化方法，从而使得空指针异常
	 * 	
	 * 解决方法：
	 * 		在Servlet的实现类中自定义一个空参init方法，让该类重写空参的init()方法，从而达到初始化目的()
	 * 		或在现有的方法中调用super.init(config)调用父类的init方法
	 * 
	 * 
	 * 
	 */
//	@Override
//	public void init(ServletConfig config) throws ServletException {
	public void init() throws ServletException {
		System.out.println("初始化init");
	}
	
	
/*
	需求：
		在web.xml文件中设两个WEB应用参数，user，password
		定义一个login.html，里面定义连个请求字段：user，password，发送到loginServlet
		再创建一个LoginServlet,在其中获取请求的user，password，对比和web.xml文件中定义的请求参数是否一致
		若一致，响应Hello:xxx,若不响应Sorry:xxx  xxx为user
*/
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		
		//附加需求 ： 获取请求个方法是GET方法还是POST方法
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String method = httpServletRequest.getMethod();
		/*
		 * 为避免强转带来的麻烦，定义一个类MyHttpServletRequest类继承MyGenericServlet类及
		 * 
		 * 
		 */
		
		
		
//		ServletContext servletContext = servletConfig.getServletContext();
//		ServletContext servletContext = getServletConfig().getServletContext();
		
		//获取WEB的user及password参数
//		String userWEB = servletContext.getInitParameter("user");
//		String passwordWEB = servletContext.getInitParameter("password");
		String userWEB = getServletContext().getInitParameter("user");
		String passwordWEB = getServletContext().getInitParameter("password");
		System.out.println("userWEB:"+userWEB+",passwordWEB:"+passwordWEB);
		
		//获取login.html中的user及password
		String userHTML = request.getParameter("user");
		String passwordHTML = request.getParameter("password");
		System.out.println("userHTML:"+userHTML+",passwordHTML:"+passwordHTML);
		
		PrintWriter writer = response.getWriter();
		
		//判断
		if(userWEB.equalsIgnoreCase(userHTML) && passwordWEB.equalsIgnoreCase(passwordHTML)){
			writer.println("Hello " + userWEB);
		}else{
			writer.println("sorry " + userHTML);
		}
		
		
		
		
	}
	
	

//	@Override
//	public ServletConfig getServletConfig() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	@Override
//	public String getServletInfo() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void destroy() {
//		System.out.println("只在程序被卸载是相应一次  destroy...");
//		
//	}

}
