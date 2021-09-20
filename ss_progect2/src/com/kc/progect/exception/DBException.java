package com.kc.progect.exception;

public class DBException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DBException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DBException(String message, Exception ex) {
		super(message, ex);
		// TODO Auto-generated constructor stub
	}

}
