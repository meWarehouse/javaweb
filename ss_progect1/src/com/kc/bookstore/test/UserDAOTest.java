package com.kc.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.kc.bookstore.dao.UserDAO;
import com.kc.bookstore.dao.impl.UserDAOImpl;
import com.kc.bookstore.domain.User;

class UserDAOTest {

	UserDAO userDAO = new UserDAOImpl();
	
	@Test
	void testGetUser() {
		User user = userDAO.getUser("Tom");
		System.out.println(user);
	}

}
