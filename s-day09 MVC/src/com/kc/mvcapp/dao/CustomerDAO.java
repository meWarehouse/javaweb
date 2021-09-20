package com.kc.mvcapp.dao;

import java.util.List;

import com.kc.mvcapp.domain.Customer;

public interface CustomerDAO {

	/**
	 * 模糊查询	返回了满足查询条件的List
	 * @param cc
	 * @return
	 */
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc);
	
	/**
	 * 返回所有Customer的List集合
	 * @return
	 */
	public List<Customer> getAll();
	
	/**
	 * 保存页面上填写的Cusomer信息
	 * @param customer
	 */
	public void save(Customer customer);
	
	/**
	 * 通过id获取指定的Customer
	 * @param id
	 * @return
	 */
	public Customer get(Integer id);
	
	/**
	 * 通过id 删除指定的Customer
	 * @param id
	 */
	public void delete(Integer id);
	
	/**
	 * 返回和name 相等的记录数
	 * @param name
	 * @return
	 */
	public long getCountWidthName(String name);
	
	
	void update(Customer customer);
	
	
}
