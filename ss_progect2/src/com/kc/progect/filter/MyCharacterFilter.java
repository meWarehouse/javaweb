package com.kc.progect.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyCharacterFilter extends HttpFilter{

	private String encoding;
	
	@Override
	public void init() {
		encoding = getFilterConfig().getServletContext().getInitParameter("encoding");
		System.out.println("--------------:"+encoding);
	}
	
	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding(encoding);
		
		chain.doFilter(request, response);
		
	}

}
