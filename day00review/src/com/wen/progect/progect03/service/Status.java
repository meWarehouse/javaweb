package com.wen.progect.progect03.service;

/**
 * 表示员工的状态
 * 
 * @Descripyion 描述
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年3月2日下午2:12:00
 *
 */
public class Status {

	private String NAME;

	public Status(String name) {
		super();
		this.NAME = name;
	}

	public static final Status FREE = new Status("FREE");
	public static final Status BUSY = new Status("BUSY");
	public static final Status VOCATION = new Status("VOCATION");

	public String getNAME() {
		return NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}

}
