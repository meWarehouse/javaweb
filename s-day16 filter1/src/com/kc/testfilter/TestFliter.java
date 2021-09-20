package com.kc.testfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

public class TestFliter implements Filter {

   
	public void destroy() {
//		System.out.println("destroy...");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter...");
		System.out.println("1..............");
		chain.doFilter(request, response);
		System.out.println("2..............");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("init ...");
	}

}
