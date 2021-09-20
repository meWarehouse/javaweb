package com.test.dao;

import java.util.List;

import com.test.domain.User;
import com.test.web.CriteriaUser;
import com.test.web.Page;

public interface UserDAO {

	/**
	 * id 获取 User
	 * 
	 * @param id
	 * @return
	 */
	User get(Integer id);

	/**
	 * id 删除 User
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 创建 User
	 * 
	 * @param user
	 */
	void add(User user);

	// 查找 name idcard 相同的User 的数量
	long getWithNameAndIdcard(String name, String idcard);

	void update(User u);
	
	//获取总的记录数
	long getTotalUserNumber(CriteriaUser cu);

	/**
	 * 通过 CriteriaUser 获取 User
	 * 
	 * @param cu
	 * @return
	 */
	Page<User> getPage(CriteriaUser cu);

	/**
	 * 通过 CriteriaUser 获取一页 User
	 * 
	 * @param cu
	 * @return
	 */
	List<User> getPageList(CriteriaUser cu, int pageSize);

}
