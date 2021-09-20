package com.kc.paging.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.paging.dao.ItemDAO;
import com.kc.paging.dao.imp.ItemDAOJdbcImpl;
import com.kc.paging.domain.Item;


public class ItemServlet extends HttpServlet{

	private static final long serialVersionUID = -7109360895258864836L;
	private ItemDAO itemDAO = new ItemDAOJdbcImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//获取页码 pageNum
		int page = Integer.parseInt(req.getParameter("pageNum"));
		
//		List<Item> items = itemDAO.queryItemList();
		
		List<Item> items = itemDAO.query((page-1)*10, 10);
		
		
		
		
		
		req.setAttribute("items", items);
		
		System.out.println("fghjkl---------------");
		
		req.getRequestDispatcher("/itemlist.jsp").forward(req, resp);
		
	}

}
