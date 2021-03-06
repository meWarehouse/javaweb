package com.kc.bookstore.dao.impl;

import com.kc.bookstore.dao.AccountDAO;
import com.kc.bookstore.domain.Account;

public class AccountDAOImpl extends BaseDAO<Account> implements AccountDAO{

	@Override
	public Account get(Integer accountId) {
		String sql = "SELECT * FROM account WHERE accountId = ?";
		return query(sql, accountId);
	}

	@Override
	public void updateBalance(Integer accountId, float amount) {
		String sql = "UPDATE account SET balance = balance - ? WHERE accountId = ?";
		update(sql, amount,accountId);
		
	}
	
	
	
}
