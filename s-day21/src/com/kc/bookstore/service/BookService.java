package com.kc.bookstore.service;

import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.dao.impl.BookDAOImpl;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;

public class BookService {
	
	private BookDAO bookDAO = new BookDAOImpl();
	
	public Page<Book> getPage(CriteriaBook cb){
		return bookDAO.getPage(cb);
	}

	public Book getBook(int id) {
		
		Book book = bookDAO.getBook(id);
		
		return book;
		
	}
	
}
