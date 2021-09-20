package com.kc.testfilter1;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.testfilter.HttpFilter;

public class PasswordFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		//获取 context-param 配置的密码
		String password = request.getServletContext().getInitParameter("password");
		
		//获取 html 配置的密码
		String htmlpassword = request.getParameter("password");
		System.out.println("--:"+password);
		System.out.println("++:"+htmlpassword);
		
		//比较
		if(!password.equals(htmlpassword)) {
			//如果不相同 给出提示 并转发回 login.jsp
			request.setAttribute("msg", "密码输入错误");
			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
			return;
		}
		
		//如果相同 放行
		filterChain.doFilter(request, response);
		
		
	}

	

}
