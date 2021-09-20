package com.wen.review.oops.test2;

public class Account {
	private double balance;
	
	public Account(double init_balance){
		this.balance = init_balance;
	}
	
	public double getBalance(){
		return balance;
	}
	
	//存钱
	public void deposit(double amt){
		if(amt<0){
			System.out.println("输入错误！！！");
			return;
		}
		balance+=amt;
		System.out.println("成功存入："+amt);
	}
	
	//取钱
	public void withdrow(double amt){
		if(balance<amt){
			System.out.println("余额不足！！！！");
			return;
		}
		balance-=amt;
		System.out.println("成功取出："+amt);
	}
	
	
}
