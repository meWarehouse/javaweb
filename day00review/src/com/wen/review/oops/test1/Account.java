package com.wen.review.oops.test1;

public class Account {
	private int id;//账户
	private double balance;//余额
	private double annualInterestRate;//年利率
	
	//带参构造
	public Account(int id,double balance,double annualInterestRate){
		this.id = id;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
	}
	
	//get set 方法
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setBalance(double balance){
		this.balance = balance;
	}
	public double getBalance(){
		return balance;
	}
	public void setAnnualInterestRate(double annualInterestRate){
		this.annualInterestRate = annualInterestRate;
	}
	public double getAnnualInterestRate(){
		return annualInterestRate;
	}
	
	//取钱
	public void withdraw(double amount){
		if(this.balance < amount){
			System.out.println("余额不足！！！");
			return;
		}
		balance-=amount;
		System.out.println("成功取出："+amount);
		
	}
	
	//存钱
	public void deposit(double amount){
		if(amount < 0){
			System.out.println("输入错误！！！");
			return;
		}
		balance+=amount;
		System.out.println("成功存入："+amount);
	}
	
	
	
}
