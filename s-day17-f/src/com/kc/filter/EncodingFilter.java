package com.kc.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter extends HttpFilter {

	private String encoding;

	@Override
	public void init() {
		ServletContext servletContext = getFilterConfig().getServletContext();
		encoding = servletContext.getInitParameter("encoding");
		System.out.println("------------:" + encoding);
	}

	@Override
	public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);

	}

}
