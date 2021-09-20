package com.kc.bookstore.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.bookstore.dao.BookDAO;
import com.kc.bookstore.dao.impl.BookDAOImpl;
import com.kc.bookstore.domain.Book;
import com.kc.bookstore.service.BookService;
import com.kc.bookstore.web.CriteriaBook;
import com.kc.bookstore.web.Page;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methodName = request.getParameter("method");
		
		System.out.println(methodName);

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			
			method.setAccessible(true);

			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
//	private BookDAO bookDAO = new BookDAOImpl();
	private BookService bookService = new BookService();
	
	protected void getBook(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String idStr = request.getParameter("id");
		
		int id = -1;
		Book book = null;
		
		try {
			id = Integer.parseInt(idStr);
			
		} catch (NumberFormatException e) {}
		
		if(id > 0) {
			book = bookService.getBook(id);
		}
		
		if(book == null) {
			response.sendRedirect(request.getContextPath()+"/error.jsp");
			return;
		}
		
		request.setAttribute("book", book);
		
		request.getRequestDispatcher("/WEB-INF/page/book.jsp").forward(request, response);
		
		
	}
	
	//bookServlet?method=getBooks
	protected void getBooks(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException {
		
		String minPriceStr = request.getParameter("minprice");
		String maxPriceStr = request.getParameter("maxprice");
		String pageNoStr = request.getParameter("pageNo");
		
		System.out.println("minPriceStr::"+minPriceStr);
		System.out.println("maxPriceStr::"+maxPriceStr);
		System.out.println("pageNoStr::"+pageNoStr);
		
		int minPrice = 0;
		int maxPrice = Integer.MAX_VALUE;
		int pageNo = 1;
		
		try {
			minPrice = Integer.parseInt(minPriceStr);
		} catch (NumberFormatException e) {}
		
		try {
			maxPrice = Integer.parseInt(maxPriceStr);
		} catch (NumberFormatException e) {}
		
		try {
			pageNo = Integer.parseInt(pageNoStr);
		} catch (NumberFormatException e) {}
	
		CriteriaBook cb = new CriteriaBook(minPrice, maxPrice, pageNo);
		
//		Page<Book> page = bookDAO.getPage(cb);
		
		Page<Book> page = bookService.getPage(cb);
		
		request.setAttribute("bookpage", page);
		
		request.getRequestDispatcher("WEB-INF/page/books.jsp").forward(request, response);
	}

}
