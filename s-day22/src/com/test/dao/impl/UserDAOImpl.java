package com.test.dao.impl;

import java.util.List;

import com.test.dao.DAO;
import com.test.dao.UserDAO;
import com.test.domain.User;
import com.test.web.CriteriaUser;
import com.test.web.Page;

public class UserDAOImpl extends DAO<User> implements UserDAO {

	@Override
	public User get(Integer id) {
		String sql = "SELECT * FROM user_test WHERE id = ?";
		return get(sql,id);
	}

	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM user_test WHERE id = ?";
		update(sql, id);
	}

	@Override
	public void add(User user) {

	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public long getWithNameAndIdcard(String name, String idcard) {
		String sql = "SELECT count(id) FROM user_test WEHERE name = ? AND idCard = ?";
		return getSingleValue(sql, name, idcard);
	}

	@Override
	public List<User> getPageList(CriteriaUser cu, int pageSize) {
		String sql = "SELECT * FROM user_test WHERE name LIKE ? AND idcard LIKE ? LIMIT ?,?";
		return getForList(sql, cu.getName(), cu.getIdCard(), (cu.getPageNo() - 1) * pageSize, pageSize);
	}

	@Override
	public long getTotalUserNumber(CriteriaUser cu) {
		String sql = "SELECT COUNT(id) FROM user_test WHERE name LIKE ? AND idcard LIKE ?";
		return getSingleValue(sql, cu.getName(),cu.getIdCard());
	}

	@Override
	public Page<User> getPage(CriteriaUser cu) {
		
		Page<User> page = new Page<User>(cu.getPageNo());
		
		page.setTotalItemNumber(getTotalUserNumber(cu));
		
		cu.setPageNo(page.getPageNo());
		
		page.setList(getPageList(cu, 3));
		
		return page;
	}

}
