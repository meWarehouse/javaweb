package com.kc.filter.privilegemanagement;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.filter.HttpFilter;

public class LoginFilter extends HttpFilter{

	@Override
	public void init() {
		System.out.println("---------这是一个过滤器111111---------------");
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("---------这是一个过滤器---------------");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("用户名："+username+",密码："+password);
		
		if(username != null && !username.trim().equals("")) {
			request.getSession().setAttribute("username", username);
			request.getRequestDispatcher("/privilegemanagement/list.jsp").forward(request, response);
			chain.doFilter(request, response);
			return;
		}
		
		response.sendRedirect(request.getContextPath()+"/privilegemanagement/login.jsp");
		
		
	}

}
