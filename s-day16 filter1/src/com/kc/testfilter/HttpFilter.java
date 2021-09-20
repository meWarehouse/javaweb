package com.kc.testfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.net.www.content.text.plain;

/**
 * Servlet Filter implementation class HttpFilter
 */
public abstract class HttpFilter implements Filter {

private FilterConfig filterConfig;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}

	protected void init() {}
	
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		doFilter(request,response,chain);
	}
	
	public abstract void doFilter(HttpServletRequest request,HttpServletResponse response ,FilterChain chain)throws IOException, ServletException;

	@Override
	public void destroy() {}

}
