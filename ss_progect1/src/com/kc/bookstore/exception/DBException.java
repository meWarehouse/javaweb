package com.kc.bookstore.exception;

public class DBException extends RuntimeException {

	private static final long serialVersionUID = -1215932151149624050L;

	public DBException() {
		
	}

	public DBException(String msg) {
		super(msg);
	}

	public DBException(String msg, Exception ex) {
		super(msg, ex);
	}

}
