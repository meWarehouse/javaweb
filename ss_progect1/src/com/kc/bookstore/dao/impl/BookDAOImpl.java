package com.kc.bookstore.dao.impl;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.domain.ShoppingCartItem;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;

public class BookDAOImpl extends BaseDAO<Book> implements BookDAO{

	@Override
	public Book getBook(int id) {
		
		String sql = "SELECT * FROM mybooks WHERE id = ?";
		
		return query(sql, id);
	}

	@Override
	public Page<Book> getPage(CriteriaBook cb) {
		
		Page<Book> page = new  Page<>(cb.getPageNo());
		page.setTotalItemNumber(getTotalBookNumber(cb));
		
		//校验数据合法性
		cb.setPageNo(page.getPageNo());
		
		page.setList(getPageList(cb, 3));
		
		return page;
	}

	@Override
	public long getTotalBookNumber(CriteriaBook cb) {
		
		String sql = "SELECT count(id) FROM mybooks WHERE price >= ? AND price <= ?";
		
		return getSingleVal(sql, cb.getMinPrice(),cb.getMaxPrice());
	}

	/**
	 * MySQL 分页使用 LIMIT, 其中 fromIndex 从 0 开始。 
	 */
	@Override
	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		
		String sql = "SELECT * FROM mybooks WHERE price >= ? AND price <= ?"
				+ "LIMIT ?, ?";
		
		return queryForList(sql, cb.getMinPrice(),cb.getMaxPrice(),(cb.getPageNo()-1)*pageSize,pageSize);
	}

	@Override
	public int getStoreNumber(Integer id) {
		
		String sql = "SELECT storeNumber FROM mybooks WHERE id = ?";
		
		return getSingleVal(sql, id);
	}

	@Override
	public void batchUpdataStoreNumberAndsalesAmount(Collection<ShoppingCartItem> items) {
		
		
		
		//String sql = "UPDATE mybooks SET salesAmunt = salesAmount + ?,storeNumber = storeNumber - ?,WHERE id = ?";
		String sql = "UPDATE mybooks SET Salesamount = Salesamount + ?,Storenumber = Storenumber - ? WHERE id = ?";
		
		Object[][] args = null;
		
		args = new Object[items.size()][3];
		List<ShoppingCartItem> scis = new ArrayList<ShoppingCartItem>(items);
		
		for(int i = 0;i < items.size();i++) {
			args[i][0] = scis.get(i).getQuantity();
			args[i][1] = scis.get(i).getQuantity();
			args[i][2] = scis.get(i).getBook().getId();
		}
		
		
		batch(sql, args);
	}

}
