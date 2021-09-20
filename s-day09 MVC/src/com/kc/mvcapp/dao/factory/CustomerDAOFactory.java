package com.kc.mvcapp.dao.factory;

import java.util.HashMap;
import java.util.Map;

import com.kc.mvcapp.dao.CustomerDAO;
import com.kc.mvcapp.dao.imp.CustomerDAOJdbcImpl;
import com.kc.mvcapp.dao.imp.CustomerDAOXMLImpl;

public class CustomerDAOFactory {
	
	private Map<String,CustomerDAO> daos = new HashMap<String, CustomerDAO>();
	
	private CustomerDAOFactory() {
		
		daos.put("jdbc", new CustomerDAOJdbcImpl());
		daos.put("xml", new CustomerDAOXMLImpl());
		
	}
	
	private static CustomerDAOFactory customerDAOFactory = new CustomerDAOFactory();
	
	public static CustomerDAOFactory getInstance() {
		return customerDAOFactory;
	}
	
	
	private static String type = null;

	public void setType(String type) {
		this.type = type;
	}
	
	public CustomerDAO getCustomerDAO() {
		
		return daos.get(type);
		
	}
	
	
	
}
