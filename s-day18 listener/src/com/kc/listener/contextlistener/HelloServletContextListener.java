package com.kc.listener.contextlistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HelloServletContextListener implements ServletContextListener,ServletRequestListener,HttpSessionListener{
 
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("servletContext 创建");
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ServletContext 销毁");
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		/*
		 * session :当第一次访问 web 应用 的一个 JSP 或 Servlet 时，且该 JSP 或 Servlet 中还需要创建 session 对象，此时 服务器会创建一个 session 对象
		 * 
		 */
		
		System.out.println("Session 被创建");
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		/*
		 * session 销毁：
		 * 		1.session 过期	session.setMaxInactiveInterval(5)
		 * 		2.直接调用 session 的 invalidate 方法	session.invalidate() 
		 * 		3.当前 web 应用被卸载(session 可以被持久化)
		 * 		
		 * 		* 关闭浏览器，并不意味着 session 被销毁，还可以通过 sessionid 找到服务器中的 session 对象
		 * 
		 */
		
		System.out.println("Session 被销毁");
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		/*
		 * request:
		 * 		是一个请求，当一个响应返回时，即被销毁，当发送一个请求时被创建，注意，请求转发的过程是一个 request 对象
		 * 
		 * 
		 */
		
		System.out.println("request 创建");
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("request 销毁 ");
		
	}

}



