package com.wen.review.oops.test1;

public class Customer {
	private String firstName;
	private String lastName;
	private Account account;
	
	//带参构造
	public Customer(String f,String l){
		this.firstName = f;
		this.lastName = l;
	}
	
	//get方法
	public String getFirstName(){
		return firstName;
	}
	public String getLastName(){
		return lastName;
	}
	public Account getAccount(){
		return account;
	}
	public void setAccount(Account account){
		this.account = account;
	}
	
	
	
}
