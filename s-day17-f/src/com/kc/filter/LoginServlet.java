package com.kc.filter;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("username:"+username+",password:"+password);
		
		if(username != null && !username.trim().equals("")) {
			
			request.getSession().setAttribute("username", username);
			
			request.getRequestDispatcher("/app-1/list.jsp").forward(request, response);
			return;
		}
		response.sendRedirect(request.getContextPath()+"/app-1/login.jsp");
		
	}

}
