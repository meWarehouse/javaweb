package com.kc.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;


public class HelloServlet implements Servlet{

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Servlet 的 service()方法用于应答请求：因为每次请求都会调用service()方法
	 * 
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		/*
		 * ServletRequest：封装了请求信息，可以从中获取任何的请求信息(请求参数，请求方式...)
		 * ServletResponse：封装了相应信息，如果想给用户什么响应，可以使用该接口具体的方法
		 * 这两个接口的实现类都是服务器给予实现的，并在服务器调用service方法时传入
		 */
		
		/*
		 * ServletRequest获取请求参数
		 * 		getParameter(String name)	
		 * 		getParameterValues(String name)	
		 * 		getParameterNames()			
		 * 		getParameterMap()			
		 * 	HttpServletRequest httpServletRequest = (HttpServletRequest)request
		 * 		getRequestURI()
		 * 		getMethod()
		 * 		getQueryString()
		 * 		getServletPath()
		 * 
		 */
		System.out.println("请求来了。。。。");
		
		/*
		 * getParameter(String name)
		 * 		根据请求参数返回String类型的请求值
		 */
		String userValue = request.getParameter("user");
		String passwordValue = request.getParameter("password");
		System.out.println("user:"+userValue+",password:"+passwordValue);
		
		
		/*
		 * getParameterValues(String name)
		 * 		根据请求参数的名字，返回请求参数的对应的字符串数组
		 * 
		 */
		//错误 只能获取到第一个值
//		String parameter = request.getParameter("interesting");
//		System.out.println(parameter);
		
		String[] interValues = request.getParameterValues("interesting");
		for(String interValue : interValues){
			System.out.println(interValue);
		}
		
		/*
		 * getParameterNames()		
		 * 		返回参数名对应的Enumeration<String>对象
		 * 
		 */
		Enumeration<String> parameterNames = request.getParameterNames();
		while(parameterNames.hasMoreElements()){
			String nextName = parameterNames.nextElement();
			String nameValue = request.getParameter(nextName);
			System.out.println(">>>:"+nextName+":"+nameValue);
		}
		
		
		/*
		 * getParameterMap()
		 * 		返回请求参数的Map<String,String[]>键值对	key参数名	value参数值
		 * 
		 */
		Map<String, String[]> parameterMap = request.getParameterMap();
		Set<Entry<String,String[]>> entrySets = parameterMap.entrySet();
		for(Entry<String,String[]> entry : entrySets){
			System.out.println("-------"+entry.getKey()+":"+Arrays.asList(entry.getValue()));
		}
		
		
		//获取以下信息需要强转
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		
		/*
		 * 获取请求URI
		 * 	getRequestURI()
		 * 
		 */
		String requestURI = httpServletRequest.getRequestURI();
		System.out.println("URI:"+requestURI);
		
		/*
		 * 获取请求方式
		 * 	getMethod()
		 */
		String method = httpServletRequest.getMethod();
		System.out.println("method:"+method);
		
		
		/*
		 * 	获取GET 方式传递的参数
		 * 		getQueryString()
		 */
		String queryString = httpServletRequest.getQueryString();
		System.out.println("GET:"+queryString);
		
		/*
		 * 返回此请求的URL中调用servlet的部分(Servlet的映射路径)
		 * 		getServletPath()
		 * 
		 */
		String servletPath = httpServletRequest.getServletPath();
		System.out.println("***:"+servletPath);
		
		
		/*
		 * ServletResponse 传递响应信息
		 * 	getWriter()
		 * 
		 */
		
		
		/*
		 * 设置相应类型
		 * 		setContentType()
		 * 
		 */
		response.setContentType("application/word");
		/*
		 * getWriter()
		 * 		返回PrintWriter对象，调用print()方法，将print()中的参数直接打印掉客户端的浏览器上
		 * 
		 */
		PrintWriter writer = response.getWriter();
		writer.println("helloworld....");
		
		
		
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}



}
