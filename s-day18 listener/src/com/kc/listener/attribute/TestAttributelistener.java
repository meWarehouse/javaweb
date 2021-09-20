package com.kc.listener.attribute;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class TestAttributelistener
		implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {
	
	/*
	 * 监听 ServletContext，HttpSession,ServletRequest 中添加、替换、移除属性的监听器	较少使用
	 * 
	 * 		public void attributeAdded(ServletRequestAttributeEvent srae) {}
	 * 		public void attributeRemoved(ServletRequestAttributeEvent srae) {}
	 *	 	public void attributeReplaced(ServletRequestAttributeEvent srae) {}
	 *			ServletRequestAttributeEvent
	 *				getName() 获取属性名
	 *				getValue() 获取属性值
	 * 
	 */
	
	
	
	
	
	
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		
		System.out.println("向request中。。。。添加。。。。了一个属性 。。。。："+srae.getName()+"::"+srae.getValue());
		
		

	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		System.out.println("从request中 。。。。  移除。。。。  了一个属性 。。。。"+srae.getName()+"::"+srae.getValue());

	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		System.out.println("request中。。。。置换。。。。     了一个属性 。。。。"+srae.getName()+"::"+srae.getValue());

	}

	@Override
	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeAdded(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent scae) {
		// TODO Auto-generated method stub

	}

}
