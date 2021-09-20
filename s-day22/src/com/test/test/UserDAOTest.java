package com.test.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.test.dao.UserDAO;
import com.test.dao.impl.UserDAOImpl;
import com.test.domain.User;
import com.test.web.CriteriaUser;
import com.test.web.Page;

class UserDAOTest {

	private UserDAO userDAO = new UserDAOImpl();
	
	@Test
	void testGetInteger() {
		User user = userDAO.get(1);
		System.out.println(user);
	}

	@Test
	void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	void testGetWithNameEqual() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPageList() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTotalUserNumber() {
		fail("Not yet implemented");
	}

	@Test
	void testGetPage() {
		
		CriteriaUser cu  =new CriteriaUser(null, null,3);
		Page<User> page = userDAO.getPage(cu);
		
		
		System.out.println("pageNo:"+page.getPageNo());
		System.out.println("pageprev:"+page.getPrevPage());
		System.out.println("nextpage:"+page.getNextPage());
		System.out.println("总数量:"+page.getTotalItemNumber());
		System.out.println("总页数："+page.getTotalPageNumber());
		System.out.println(page.getList());
	}

}
