package com.kc.progect.domain;

import java.sql.Date;

public class User {

	private int userId;
	private String userName;
	private String userPassword;
	private String userGender;
	private String userBirthday;
	private Date registerDate;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int userId, String userName, String userPassword, String userGender, String userBirthday,
			Date registerDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.registerDate = registerDate;
	}
	
	

	public User(String userName, String userPassword, String userGender, String userBirthday, Date registerDate) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.registerDate = registerDate;
	}

	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userGender="
				+ userGender + ", userBirthday=" + userBirthday + ", registerDate=" + registerDate + "]";
	}

}
