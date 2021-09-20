package com.kc.paging.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.paging.dao.ItemDAO;
import com.kc.paging.dao.imp.ItemDAOJdbcImpl;

/**
 * Servlet implementation class ItemServletCount
 */
@WebServlet("/itemservletcount")
public class ItemServletCount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ItemDAO itemDAO = new ItemDAOJdbcImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long count = itemDAO.queryCount();
		
		System.out.println("------------------------------:"+count);
		
		//将条数写入响应流中
		response.getWriter().write(String.valueOf(count));
	}

}
