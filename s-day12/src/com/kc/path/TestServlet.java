package com.kc.path;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/testServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> cities = Arrays.asList("AA","BB","CC","DD");
		
		request.setAttribute("cities", cities);
		
//		request.getRequestDispatcher("/path/b.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/path/c.jsp");
		
		
		
	}

}
