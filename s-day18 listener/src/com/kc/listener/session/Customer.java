package com.kc.listener.session;

import java.io.Serializable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;

public class Customer implements HttpSessionBindingListener,HttpSessionActivationListener,Serializable{

	/*
	 * HttpSessionBindingListener	无需在 web.xml 文件中配置		较少使用
	 * 		监听实现了该接口的 java 类的对象被绑定到 session 或从 session 中被解除的事件
	 * 
	 * 	public void valueBound(HttpSessionBindingEvent event) {}
	 * 	public void valueUnbound(HttpSessionBindingEvent event) {}
	 * 		HttpSessionBindingEvent 
	 * 			getName()
	 * 			getValue()
	 * 			getSession()
	 * 
	 * 
	 * HttpSessionActivationListener 较少使用
	 * 		监听实现了改接口和 Serializable 接口的 java 类对象随 session 钝化和活化事件
	 * 			钝化：从内存中写入磁盘
	 * 			活化：从磁盘中读取
	 *		session 对象储存在 tomcat 服务器中
	 *
	 *	public void sessionWillPassivate(HttpSessionEvent se) {}
	 *	public void sessionDidActivate(HttpSessionEvent se) {}
	 * 
	 */
	
	
	
	private static final long serialVersionUID = 1L;
	
	private String time;
	
	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("绑定到 session");
		
		String name = event.getName();
		Object value = event.getValue();
		System.out.println(value == this);
		HttpSession session = event.getSession();
		System.out.println("name:"+name+",value:"+value+",session:"+session);
		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("从session中解除绑定");
		
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("钝化：从内存中写入磁盘。。。");
		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("活化：从磁盘中读取。。。");
		
	}
	
	@Override
	public String toString() {
		return super.toString()+",time:"+time;
	}
	

}
