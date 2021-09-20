package com.wen.review.oops.test1;

public class CustomerTest {
	public static void main(String[] args){
		
		Customer customer = new Customer("Jane","Smith");
		Account account = new Account(1000,2000.0,0.0123);
		
		//添加账户
		customer.setAccount(account);
		
		customer.getAccount().deposit(100.0);
		customer.getAccount().withdraw(960);
		customer.getAccount().withdraw(2000);
		
		
	}
}
