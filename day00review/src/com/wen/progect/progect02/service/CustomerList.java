package com.wen.progect.progect02.service;

import com.wen.progect.progect02.bean.Customer;

/**
 * 
 * @Descripyion CustomerList为Customer对象的管理模块,内部用数组管理一组Customer对象，并提供相应的添加，修改，删除，和遍历方法，工CustomerView调用
 * @author wen Email:wenvlove@163.com
 * @version
 * @date 2020年2月21日上午1:15:13
 *
 */
public class CustomerList {
	private Customer[] customers;// 用来保存客户对象数组
	private int total;// 记录已保存的客户对象的数量

	/**
	 * 用来初始化customers数组的构造器
	 * @param totalCustomer：指定数组的长度
	 */
	public CustomerList(int totalCustomer) {
		customers = new Customer[totalCustomer];//创建数组
	}

	/**
	 * 
	 * @Descripyion 描述添加客户
	 * @author wen
	 * @date 2020年2月21日上午1:15:48
	 * @param customer
	 * @return true:添加成功	false:添加失败
	 *
	 */
	public boolean addCustomer(Customer customer) {
		if(total<customers.length){
			customers[total++] = customer;
			return true;
		}else{ 
			return false;
		}
	}

	/**
	 * 
	 * @Descripyion 修改指定客户信息
	 * @author wen
	 * @date 2020年2月21日上午12:12:19
	 * @param index
	 * @param customer
	 * @return true:修改成功	false：修改失败
	 *
	 */
	public boolean replaceCustomer(int index, Customer cust) {
		if(index < 0 || index >= total){
			return false;
		}
		
		customers[index] = cust;
		return true;
	}

	/**
	 * 
	 * @Descripyion 删除指定客户
	 * @author wen
	 * @date 2020年2月21日上午12:13:26
	 * @param index
	 * @return true:删除成功	false：删除失败
	 *
	 */
	public boolean deleteCustomer(int index) {
		if(index < 0 || index >= total){
			return false;
		}
		
		for(int i = index;i<total-1;i++){
			customers[i] = customers[i+1];//index后面的数组依次前移
		}
		customers[--total] = null;//最后的一个设为null
		return true;
	}
	/**
	 * 
	 * @Descripyion 遍历所有客户
	 * @author wen
	 * @date 2020年2月21日上午12:54:04
	 * @return
	 *
	 */
	public Customer[] getAllCustomers() {
		Customer[] custs = new Customer[total];//创建一个新的数组
		for(int i = 0;i < total;i++){
			custs[i] = customers[i];//将存储的客户添加到新的数组中
		}
		return custs;
	}

	/**
	 * 
	 * @Descripyion 查看指定索引位置客户信息
	 * @author wen
	 * @date 2020年2月21日上午12:15:48
	 * @param index
	 * @return 如果找到元素则返回，如果没有则返回null
	 *
	 */
	public Customer getCustomer(int index) {
		if(index < 0 || index >= total){
			return null;
		}
		
		return customers[index];
	}

	/**
	 * 
	 * @Descripyion 统计存储的客户数量
	 * @author wen
	 * @date 2020年2月21日上午12:16:35
	 * @return
	 *
	 */
	public int getTotal() {
		return total;
	}

}
