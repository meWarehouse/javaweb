package com.kc.listener.contextlistener;

import java.io.IOException;
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
		
//		Object attribute = request.getAttribute("request");
		
		request.setAttribute("request", "requestvalue");
		
//		request.getRequestDispatcher("/test.jsp").forward(request, response);
		//	转发是一个请求
		
		response.sendRedirect("test.jsp");
		//	重定向是两个请求
		
		
	}

}
