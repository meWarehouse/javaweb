package com.kc.listener.test1;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.WebListener;
@WebListener
public class MyServletRequestListener implements ServletRequestListener{

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		ServletContext servletContext = sre.getServletContext();
		
		if(servletContext.getAttribute("requestCount") == null) {
			servletContext.setAttribute("requestCount", 1);
		}else {
			
			int requestCount = Integer.parseInt(servletContext.getAttribute("requestCount").toString());
			requestCount++;
			servletContext.setAttribute("requestCount", requestCount);
			
		}
		System.out.println("当前访问次数为："+servletContext.getAttribute("requestCount"));
		
	}
	
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("请求对象被销毁");
		
	}


}
