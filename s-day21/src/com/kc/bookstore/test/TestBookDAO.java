package com.kc.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.dao.impl.BookDAOImpl;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;

class TestBookDAO {

	private BookDAO bookDAO = new BookDAOImpl(); 
	
	@Test
	void testGetBook() {
		Book book = bookDAO.getBook(1);
		System.out.println(book);
	}

	@Test
	void testGetStoreNumber() {
		int storeNumber = bookDAO.getStoreNumber(9);
		System.out.println(storeNumber);
	}
  
	@Test
	void testGetPage() {
		
		CriteriaBook cb = new CriteriaBook(50, 90, 30);
		System.out.println("---cb:"+cb);
		Page<Book> page = bookDAO.getPage(cb);
		
		System.out.println("---page:"+page);
		
		System.out.println("pageNo:"+page.getPageNo());
		System.out.println("TotalPageNumber:"+page.getTotalPageNumber());
		System.out.println("List:"+page.getList());
		System.out.println("PervPage:"+page.getPrevPage());
		System.out.println("NextPage:"+page.getNextPage());
		
		
		
	}



}
