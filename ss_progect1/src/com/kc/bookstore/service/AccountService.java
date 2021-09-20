package com.kc.bookstore.service;

import com.kc.bookstore.dao.AccountDAO;
import com.kc.bookstore.dao.impl.AccountDAOImpl;
import com.kc.bookstore.domain.Account;

public class AccountService {
	
	private AccountDAO accountDAO = new AccountDAOImpl();
	
	public Account getAccount(int accountId) {
		return accountDAO.get(accountId);
	}
	
}
