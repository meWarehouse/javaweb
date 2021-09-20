package com.wen.review.oops.test2;

public class Bank {
	private Customer[] customers;//存放多个客户数组
	private int numberOfCustomers;//记录客户个数
	
	public Bank() {
		customers = new Customer[10];
	}
	
	//添加客户方法
	public void addCustomer(String f,String l){
//		customers[numberOfCustomer++] = new Customer(f, l);
		Customer cust = new Customer(f,l);
		customers[numberOfCustomers++] = cust;
	}
	
	//统计客户
	public int getNumberOfCustomers(){
		return numberOfCustomers;
	}
	
	//获取指定客户信息
	public Customer getCustomer(int index){
//		return customers[index];
		if(index >=0 && index<numberOfCustomers){
			return customers[index];
		}
		return null;
	}
	
	
	
}
