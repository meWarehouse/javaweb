package com.kc.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDAO {
	
	private static Map<String,User> users;
	private static List<Authority> authorities = null;
	
	static {
		
		authorities = new ArrayList<Authority>();
		authorities.add(new Authority("Article-1", "/demo/article-1.jsp"));
		authorities.add(new Authority("Article-2", "/demo/article-2.jsp"));
		authorities.add(new Authority("Article-3", "/demo/article-3.jsp"));
		authorities.add(new Authority("Article-4", "/demo/article-4.jsp"));
		authorities.add(new Authority("Article-5", "/demo/article-5.jsp"));
		
		users = new HashMap<String, User>();
		
		
		User user1 = new User("AAA", authorities.subList(0, 2));
		users.put("AAA", user1 );
		
		User user2 = new User("BBb", authorities.subList(2, 4) );
		users.put("BBB", user2 );
		
		
	}
	
	//查看权限：
	public User get(String username) {
		return users.get(username);
	}
	//修改权限：
	public void update(String username,List<Authority> authority) {
		
		users.get(username).setAuthorities(authority);
		
	}
	
}
