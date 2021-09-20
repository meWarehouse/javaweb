package com.kc.testfilter1;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.testfilter.HttpFilter;

public class UserFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
			throws IOException, ServletException {
		
		//获取 web.xml 文件中的用户名
		String username = getFilterConfig().getInitParameter("username");
		//获取 html 中问用户名
		String htmluser = req.getParameter("username");
		System.out.println(username);
		System.out.println(htmluser);
		
		//与  网页上填写的用户名比较
		if(!username.equalsIgnoreCase(htmluser)) {
			//提示信息
			req.setAttribute("msg", "用户名输入错误请重新输入");
			//若不相同则转发回 /login/login.jsp
			req.getRequestDispatcher("/login/login.jsp").forward(req, resp);
			return;
		}
		
		//若相同则放行
		filterChain.doFilter(req, resp);
		
		
	}

	
}
