package com.kc.filter.privilegemanagement;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Loginprivilege
 */

public class Loginprivilege extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		
		System.out.println("username:"+username+",password:"+password+",路径："+request.getContextPath());
		
		
		if(username != null && !username.trim().equals("")) {
//			resession.setAttribute("username", username);
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/privilegemanagement/list.jsp").forward(request, response);
			response.sendRedirect("login.jsp");
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/privilegemanagement/list.jsp");
		
		
	}

}
