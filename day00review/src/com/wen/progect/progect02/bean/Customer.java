package com.wen.progect.progect02.bean;

/**
 * 
 * @Descripyion Customer作为实体对象，用来封装客户的信息
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年2月21日上午12:00:36
 *
 */
public class Customer {
	private String name;// 客户的姓名
	private char gender;// 性别
	private int age;// 年龄
	private String phone;// 电话号码
	private String email;// 邮箱

	public Customer(String name, char gender, int age, String phone, String email) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.email = email;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
