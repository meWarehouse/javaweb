package com.kc.javaweb;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;




/*
 * 
 * 	Servlet 容器：运行Servlet,JSP,Filter等软件环境
 * 		可以用来创建Servlet，并调用Servlet的相关 生命周期
 * 
 * 	Servlet 生命周期的方法：一下方法都是由Servlet容器负责调用
 * 		1.构造器：
 * 			只会被调用一次，只有第一次请求Servlet时，创建Servlet的实列，调用构造器，这说明servlet是单实列的(线程安全)
 * 		2.init方法：
 * 			只被调用一次，在创建好实列后立即被调用，用于初始化当前Servlet	
 * 		3.service：
 * 			每次多次调用，每次请求都会调用service方法 实际用于响应请求的
 * 		4.destroy：
 * 			只会被调用一次，在当前Servlet所在的WEB应用被卸载前调用用于释放当前Servlet所占的资源
 * 
 * 	<!-- 配置与映射 Servlet -->
 *	 <servlet>配置
 * 		<!-- Servlet 注册的名字 -->
 * 		<servlet-name>helloServlet</servlet-name>
 * 		<!-- Servlet 的全类名 -->
 * 		<servlet-class>com.kc.javaweb.HelloServlet</servlet-class>
 * 		<!-- 可以指定Servlet创建的时机 -->
 * 		<load-on-startup>5</load-on-startup>
 * 	</servlet>
 * 
 * 	<servlet-mapping>映射
 * 		<!-- 需要和某一个servlet节点的servlet-name子节点的文本接节点一致 -->
 * 		<servlet-name>helloServlet</servlet-name>
 * 		<!-- 映射具体的访问路径：/ 代表当前WEB应用的根目录 -->
 * 		<url-pattern>/hello</url-pattern>
 * 	</servlet-mapping>
 * 
 * 
 * 参数：<load-on-startup>x</load-on-startup>
 * 		load-on-startup：可以指定Servlet被创建的时机，若为负数则在第一次请求时被创建，若为0或正数，则在当前WWEB应用中被Servlet容器加载时创建实列，且数越小月早被创建
 * 
 * 关于servlent-mapping
 *		1.在同一个Servlet可以被唤醒多个URL，即多个<servlet-mapping>元素的<servlet-name>子元素的设置，可以是同一个Servlet的注册名
 *		2.在Servlet映射映射到URL中也可以使用*通配符，当只能有两种固定的格式
 *			2.1：以"*."为拓展名
 *			2.2：以"/*"结尾
 * 
 * 
 */


public class HelloServlet implements Servlet {

	public HelloServlet() {
		System.out.println("HelloServlet implements Servlet");
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
		System.out.println(" getServletInfo");
		return null;
	}

	/**
	 * 
	 * @param ServletConfig 封装了Servlet的配置信息，并且可以获取ServletContext对象 
	 * 		
	 * 				
	 * 			
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println(" init");
		
		/*
		 * 1.配置参数
		 * 		<!-- 配置Servlet的初始化参数  (必须在load-on-startup前面) 局部参数 -->
	  	 *		<init-param>
	  	 *			<!-- 参数名 -->
	  	 *			<param-name>user</param-name>
	  	 *			<!-- 化参数值 -->
	  	 *			<param-value>root</param-value>
	  	 *		</init-param>
	  	 *	2.获取参数
	  	 *		①：String getInitParameter(String name)	获取指定参数名的初始化参数
	  	 *		②：Enumeration<String> getInitParameterNames()	获取参数名组成的Enumeration对象
		 * 		③：String getServletName() 获取servlet的配置名称(不常用)
		 * 
		 * 		④：ServletContext getServletContext()
		 */
		
//		获取指定参数名的初始化参数
		String user = arg0.getInitParameter("user");
		System.out.println("user:"+user);
		
//		获取参数名组成的Enumeration对象
		Enumeration<String> names = arg0.getInitParameterNames();
		
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String value = arg0.getInitParameter(name);
			System.out.println("^^"+name+":"+value);
		}
//		获取servlet的配置名称
		String servletName = arg0.getServletName(); 
		System.err.println("servletName--"+servletName);
		
		/*
		 * ④：ServletContext getServletContext()
		 * 		Servlet引擎为每个WEB应用程序都创建一个对应的ServletContext对象，该对象被包含在ServletConfig对象中，
		 * 		调用ServletConfig.getServletContext方法可以返回ServletContext对象的引用
		 * 		
		 * 		由于WEB应用程序中的所有Servlet都共享一个ServletContext对象，所以ServletContext对象被称为application对象(Web应用程序对象)
		 * 			功能：
		 * 				1.获取WEB 应用程序的初始化参数  **
		 * 				3.application域范围的属性     **
		 * 				5.获取虚拟机路径所映射的本地路径 **
		 * 				2.记录日志
		 * 				4.访问资源文件
		 * 				6.WEB应用程序之间的访问
		 * 				7.ServletContext的其他方法
		 * 
		 */
		
		
		//获取ServletContext对象
		ServletContext servletContext = arg0.getServletContext();
		
		
		
		/*
		 * 1.获取WEB 应用程序的初始化参数 
		 * 
		 * 配置当前WEB应用的初始化参
		 * <context-param>
		 *		<param-name>driver</param-name>
		 *		<param-value>com.mysql.jdbc.Driver</param-value>
		 *	</context-param>
		 *
		 *	String getInitParameter(String name)	获取指定参数名的初始化参数
		 *	Enumeration<String> getInitParameterNames()	获取参数名组成的Enumeration对象
		 */
		String driver = servletContext.getInitParameter("driver");
		System.out.println("driver--"+driver);
		
		Enumeration<String> initParameterNames = servletContext.getInitParameterNames();
		while(initParameterNames.hasMoreElements()){
			String nextElement = initParameterNames.nextElement();
			String initParameter = servletContext.getInitParameter(nextElement);
			System.out.println("nextElement--"+nextElement + ": initParameter" + initParameter);
		}

		/*
		 * 2.获取当前WEB 应用的某个文件在服务器上的的绝对路径(只能是WebContent文件下的)而不是部署前的路径
		 * 
		 * 		String getRealPath(String path)
		 * 
		 */
		String realPath = servletContext.getRealPath("/note04.txt");
		//不是：D:\JavaLearn\java\javaEE-workspace\s-day04\WebContent\note04.txt
		System.out.println("realPath-->"+realPath);
		
		/*
		 * 3.获取当前WEB 应用的名称
		 * 		String getContextPath()
		 * 
		 */
		String contextPath = servletContext.getContextPath();
		System.out.println("contextPath-->" + contextPath);
		
		/*
		 * 4.获取当前WEB应用的某一个文件对应的输入流
		 * 		InputStream getResourceAsStream(String path)	path中的  / 为当前WEB应用的根目录
		 * 
		 * 		ClassLoader classLoader = getClass().getClassLoader();
		 * 		InputStream is = classLoader.getResourceAsStream("wen.properties");
		 * 
		 */
		
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream is = classLoader.getResourceAsStream("wen.properties");
			System.out.println("ClassLoader-->"+is);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
//			InputStream is2 = servletContext.getResourceAsStream("wen,properties");//null
			InputStream is2 = servletContext.getResourceAsStream("/WEB-INF/classes/wen.properties");//相对于当前WEB 应用的路径
			System.out.println("servletContext-->"+is2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	

}
