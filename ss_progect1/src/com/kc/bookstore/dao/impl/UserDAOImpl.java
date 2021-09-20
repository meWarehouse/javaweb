package com.kc.bookstore.dao.impl;


import com.kc.bookstore.dao.UserDAO;
import com.kc.bookstore.domain.User;

public class UserDAOImpl extends BaseDAO<User> implements UserDAO{

	@Override
	public User getUser(String username) {
		String sql = "SELECT userId, username, accountId " +
				"FROM userinfo WHERE username = ?";
		return query(sql, username); 
		
	}

	

}
