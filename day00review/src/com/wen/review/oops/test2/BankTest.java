package com.wen.review.oops.test2;

public class BankTest {

	public static void main(String[] args){
		
		Bank bank = new Bank();//alt+shift+r 
		
		System.out.println(bank);
		//添加客户
		bank.addCustomer("Jane", "Smith");
		
		System.out.println(bank.getCustomer(0));
		
		
//		添加客户
		bank.getCustomer(0).setAccount(new Account(2000));
		
		bank.getCustomer(0).getAccount().withdrow(500);
		
		
		
		
		
		
		bank.getCustomer(0).getAccount().deposit(200);
		
		
		
		

	
	}
	
}
