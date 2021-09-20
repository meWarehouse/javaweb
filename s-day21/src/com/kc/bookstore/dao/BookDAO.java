package com.kc.bookstore.dao;

import java.util.List;

import com.kc.bookstore.domain.Book;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;

public interface  BookDAO {

	/**
	 * 通过 id 获取 指定的 Book 对象
	 * @param id
	 * @return
	 */
	Book getBook(Integer id);
	
	/**
	 * 返回指定 id 的 book 的 storeNumber 字段的值
	 * @param id
	 * @return
	 */
	int getStoreNumber(Integer id);
	
	/**
	 * 根据传入的 CriteriaBook 对象返回对应的 Page 对象
	 * @param cb
	 * @return
	 */
	Page<Book> getPage(CriteriaBook cb);
	
	/**
	 * 根据传入的 CriteriaBook 对象返回其对应的记录数
	 * @param cb
	 * @return
	 */
	long getTotalBookNumber(CriteriaBook cb);
	
	/**
	 * 根据传入的 CriteriaBook 和 pageSize 返回当前页面对应的 List
	 * @param cb
	 * @param pageSize
	 * @return
	 */
	List<Book> getPageList(CriteriaBook cb,int pageSize);
	
	
}
