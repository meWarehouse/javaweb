package com.kc.progect.dao.impl;

import java.util.List;

import com.kc.progect.dao.DAO;
import com.kc.progect.dao.UserDAO;
import com.kc.progect.domain.User;

public class UserDAOImpl extends DAO<User> implements UserDAO {

	@Override
	public List<User> getForList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User u) {
		
		String sql = "INSERT INTO t_user(userName,userPassword,userGender,userBirthday,registerDate) "
				+ "VALUES(?,?,?,?,?)";
		
		addData(sql, u.getUserName(),u.getUserPassword(),u.getUserGender(),u.getUserBirthday(),u.getRegisterDate());
		
	}

}
