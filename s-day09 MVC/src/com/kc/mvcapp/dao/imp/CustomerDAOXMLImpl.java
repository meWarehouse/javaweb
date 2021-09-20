package com.kc.mvcapp.dao.imp;

import java.util.List;

import com.kc.mvcapp.dao.CriteriaCustomer;
import com.kc.mvcapp.dao.CustomerDAO;
import com.kc.mvcapp.domain.Customer;

public class CustomerDAOXMLImpl implements CustomerDAO {

	@Override
	public List<Customer> getForListWithCriteriaCustomer(CriteriaCustomer cc) {
		System.out.println("getForListWithCriteriaCustomer");
		return null;
	}

	@Override
	public List<Customer> getAll() {
		System.out.println("getAll");
		return null;
	}

	@Override
	public void save(Customer customer) {
		System.out.println("save");
	}

	@Override
	public Customer get(Integer id) {
		System.out.println("get");
		return null;
	}

	@Override
	public void delete(Integer id) {
		System.out.println("delete");
		
	}

	@Override
	public long getCountWidthName(String name) {
		System.out.println("getCountWidthName");
		return 0;
	}

	@Override
	public void update(Customer customer) {
		System.out.println("update");
		
	}

}
