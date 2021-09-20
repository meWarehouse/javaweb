package com.kc.bookstore.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.dao.impl.BookDAOImpl;
import com.kc.bookstore.db.JdbcUtils;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.domain.ShoppingCartItem;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;

class BookDAOTest {

	private BookDAO bookDAO = new BookDAOImpl();
	
	@Test
	void testGetBook() {
		
		Book book = bookDAO.getBook(1);
		System.out.println(book);
		
	}

	@Test
	void testGetPage() {
		
		Connection connection = JdbcUtils.getConnection();
		
		CriteriaBook cb = new CriteriaBook(50, 60, 30);
		Page<Book> page = bookDAO.getPage(cb);
		
		System.out.println("pageNo:"+page.getPageNo());
		System.out.println("TotalPageNumber:"+page.getTotalPageNumber());
		System.out.println("List:"+page.getList());
		System.out.println("PervPage:"+page.getPervPage());
		System.out.println("NextPage:"+page.getNextPage());
	}

	@Test
	void testGetTotalBookNumber() {
		
		
		
	}

	@Test
	void testGetPageList() {
		fail("Not yet implemented");
	}

	@Test
	void testGetStoreNumber() {
		int storeNumber = bookDAO.getStoreNumber(5);
		System.out.println(storeNumber);
	}

	@Test
	void testBatchUpdataStoreNumberAndsalesAmount() {
		
		Collection<ShoppingCartItem> items = new ArrayList<ShoppingCartItem>();
		
		Book book = bookDAO.getBook(1);
		ShoppingCartItem sci = new ShoppingCartItem(book);
		sci.setQuantity(10);
		items.add(sci);
		
		book = bookDAO.getBook(2);
		sci = new ShoppingCartItem(book);
		sci.setQuantity(11);
		items.add(sci);
		
		book = bookDAO.getBook(3);
		sci = new ShoppingCartItem(book);
		sci.setQuantity(1);
		items.add(sci);
		
		book = bookDAO.getBook(4);
		sci = new ShoppingCartItem(book);
		sci.setQuantity(10);
		items.add(sci);
		
		
		
		bookDAO.batchUpdataStoreNumberAndsalesAmount(items);
		
	}

}
