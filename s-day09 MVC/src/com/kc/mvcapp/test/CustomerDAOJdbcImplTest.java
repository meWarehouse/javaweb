package com.kc.mvcapp.test;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.kc.mvcapp.dao.CriteriaCustomer;
import com.kc.mvcapp.dao.CustomerDAO;
import com.kc.mvcapp.dao.imp.CustomerDAOJdbcImpl;
import com.kc.mvcapp.domain.Customer;

class CustomerDAOJdbcImplTest {

	private CustomerDAO customerDAO = new CustomerDAOJdbcImpl();
	
	@Test
	void testGetForListWithCriteriaCustomer() {
		
		CriteriaCustomer cc = new CriteriaCustomer("i", null, null);
		
		List<Customer> customers = customerDAO.getForListWithCriteriaCustomer(cc);
		System.out.println(customers);
		
		
	}
	
	
	@Test
	void testGetAll() {

		List<Customer> all = customerDAO.getAll();
		for(Customer cust : all) {
			System.out.println(cust);
		}
		
		
		
	}

	@Test
	void testSave() {
	
		Customer customer = new Customer();
		
		customer.setName("taobao");
		customer.setAddress("hjj");
		customer.setPhone("123440986");
		
		customerDAO.save(customer);
		
	}

	@Test
	void testGetInteger() {

		Customer cust = customerDAO.get(1);
		System.out.println(cust);
		
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCountWidthName() {
		
		long countWidthName = customerDAO.getCountWidthName("taobao");
		System.out.println("opo:"+countWidthName);
		
	}

}
