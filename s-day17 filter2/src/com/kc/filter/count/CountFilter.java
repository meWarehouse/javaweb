package com.kc.filter.count;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.filter.HttpFilter;

public class CountFilter extends HttpFilter{

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		ServletContext servletContext = request.getServletContext();
		int count = 1;
		//访客数量
		Object countObj = servletContext.getAttribute("count");
		//第一次访问
		if(countObj == null) {
			servletContext.setAttribute("count", 1);
		}else {
			//后续访问
			count = Integer.valueOf(countObj.toString());
			count++;
			servletContext.setAttribute("count", count);
		}
		System.out.println("访客数量："+count);
		System.out.println("1:------------------------");
		
		chain.doFilter(request, response);
		
		System.out.println("2:------------------------");
	}

}
