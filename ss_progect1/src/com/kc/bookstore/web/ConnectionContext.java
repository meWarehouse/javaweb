package com.kc.bookstore.web;

import java.sql.Connection;



public class ConnectionContext {
	
	private ConnectionContext() {}
	
	private static ConnectionContext connectionContext = new ConnectionContext();
	
	public static ConnectionContext getInstance() {
		return connectionContext;
	}
	

	private ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<Connection>();
	
	public void bind(Connection connection) {
		connectionThreadLocal.set(connection);
	}
	
	public Connection get() {
		return connectionThreadLocal.get();
	}
	
	public void remove() {
		connectionThreadLocal.remove();
	}
	
	
}
