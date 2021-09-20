package com.kc.bookstore.dao.impl;

import java.util.List;

import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO{

	@Override
	public Book getBook(Integer id) {
		
		String sql = "SELECT * FROM mybooks WHERE id = ?";
	
		return query(sql, id);
	}

	@Override
	public int getStoreNumber(Integer id) {
		
		String sql = "SELECT Storenumber FROM mybooks WHERE id = ?";
		
		return getSingleValue(sql, id);
	}

	@Override
	public Page<Book> getPage(CriteriaBook cb) {
		
		Page<Book> page = new Page<Book>(cb.getPageNo());
		
		page.setTotalItemNumber(getTotalBookNumber(cb));
		
		//数据校验
		cb.setPageNo(page.getPageNo());
		
		page.setList(getPageList(cb, 3));
		
		return page;
	}

	@Override
	public long getTotalBookNumber(CriteriaBook cb) {
		
		String sql = "SELECT count(id) FROM mybooks WHERE price >= ? AND price <= ?";
		
		return getSingleValue(sql, cb.getMinPrice(),cb.getMaxPrice());
	}

	@Override
	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		
		String sql = "SELECT * FROM mybooks WHERE price >= ? AND price <= ? LIMIT ?,?";
		
		
		return queryForList(sql, cb.getMinPrice(),cb.getMaxPrice(),(cb.getPageNo()-1)*pageSize,pageSize);
	}

}
