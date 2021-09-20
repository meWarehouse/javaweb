package com.kc.listener.test;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {

		// 获取 ServletContext 对象
		ServletContext servletContext = se.getSession().getServletContext();
		HttpSession session = se.getSession();

		// 如果是第一次会话
		if (servletContext.getAttribute("sessionCount") == null) {
			servletContext.setAttribute("sessionCount", 1);
			System.out.println(servletContext.getAttribute("sessionCount") + ":::___________________");
		} else {
			int sessionCount = Integer.parseInt(servletContext.getAttribute("sessionCount").toString());
			System.out.println("++++::" + sessionCount);
			sessionCount++;
			servletContext.setAttribute("sessionCount", sessionCount);
			System.out.println(servletContext.getAttribute("sessionCount") + "::++:___________________");

		}

		System.out.println("当前在线人数：" + servletContext.getAttribute("sessionCount").toString());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

		// 获取 ServletContext 对象
		ServletContext servletContext = se.getSession().getServletContext();
		
		Object attribute = servletContext.getAttribute("sessionCount");
		int sessionCount = Integer.parseInt(attribute.toString());
		sessionCount--;
		servletContext.setAttribute("sessionCount", sessionCount);
		
		System.out.println("当前在线人数：" + servletContext.getAttribute("sessionCount").toString());

	}

}
