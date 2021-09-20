package com.kc.mvcapp.dao.imp;

import java.util.List;

import com.kc.mvcapp.dao.CriteriaCustomer;
import com.kc.mvcapp.dao.CustomerDAO;
import com.kc.mvcapp.dao.DAO;
import com.kc.mvcapp.domain.Customer;

public class CustomerDAOJdbcImpl extends DAO<Customer> implements CustomerDAO {

	@Override
	public List<Customer> getAll() {
		
		String sql = "select * from customers";
		
		return getForList(sql);
	}

	/**
	 * 通过输入的 name address phone 保存对应的customers
	 * 
	 */
	@Override
	public void save(Customer customer) {
		String sql = "INSERT INTO customers(name,address,phone) VALUES(?,?,?)";
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone());
		
	}

	/**
	 * 通过 id 获取到指定的customers
	 * 
	 */
	@Override
	public Customer get(Integer id) {
		String sql = "SELECT id,name,address,phone FROM customers WHERE id = ?";
		return get(sql,id);
	}

	/**
	 * 通过 id 删除customers
	 * 
	 */
	@Override
	public void delete(Integer id) {
		String sql = "delete from customers where id = ?";
		update(sql, id);
		
	}

	/**
	 * 根据 name 获取总数目
 	 * 
	 */
	@Override
	public long getCountWidthName(String name) {
		
		String sql = "SELECT count(id) FROM customers WHERE name = ?";
		Object forValue = getForValue(sql, name);
		String string = forValue.toString();
		long value = Long.parseLong(string);
		return value;
	}

	
	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		
		//select * from customers where name like '%i%' and address like '%j%' and phone like '%1%';
		String sql = "SELECT * FROM customers WHERE name LIKE ? AND address LIKE ? AND phone LIKE ?";
//		String sql = "select * from customers where name like ? and address like ? and phone like ?";
		
		/*
		 * 修改了CriteriaCustomer 的 getxxx 方法：使其返回的字符串中有 %%
		 * 若值为null 返回 "%%" 不为null 返回 "%name%"
		 * 
		 */
		return getForList(sql,cc.getName(),cc.getAddress(),cc.getPhone());
		
	}

	@Override
	public void update(Customer customer) {
		// update 表名 set 数据 where 定位数据;
		String sql = "update customers set name = ?, address = ?, phone = ? where id = ?";
		
		update(sql, customer.getName(),customer.getAddress(),customer.getPhone(),customer.getId());		
		
	}

	
	
	
	
}
