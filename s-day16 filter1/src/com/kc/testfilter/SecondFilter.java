package com.kc.testfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


public class SecondFilter implements Filter {

    
	public void destroy() {
//		System.out.println("这是 SecondFilter destroy");
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("这是 SecondFilter doFilter");
		
		System.out.println("3..............");
		chain.doFilter(request, response);
		System.out.println("4..............");
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("这是 SecondFilter init");
	}

}
