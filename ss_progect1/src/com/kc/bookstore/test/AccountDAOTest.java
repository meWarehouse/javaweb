package com.kc.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.kc.bookstore.dao.AccountDAO;
import com.kc.bookstore.dao.impl.AccountDAOImpl;
import com.kc.bookstore.domain.Account;

class AccountDAOTest {

	private AccountDAO accountDAO = new AccountDAOImpl();
	
	@Test
	void testGet() {
		
		Account account = accountDAO.get(1);
		System.out.println(account);
		
		
	}

	@Test
	void testUpdateBalance() {
		accountDAO.updateBalance(1,1000);
	}

}
