package com.kc.progect.dao;

import java.util.List;

import com.kc.progect.domain.User;

public interface UserDAO {

	public abstract List<User> getForList();
	
	
	public abstract void addUser(User u);
	
}
