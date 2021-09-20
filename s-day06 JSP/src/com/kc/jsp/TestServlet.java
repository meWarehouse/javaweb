package com.kc.jsp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		//1.在Servlet中无法得到pageContext对象
		
		//2.request
		Object requestAttr = request.getAttribute("requestAttr");
		writer.print("requestAttr:" + requestAttr);
		writer.print("<br/><br/>");
		
		//session
		Object sessionAttr = request.getSession().getAttribute("sessionAttr");
		writer.print("sessionAttr:"+sessionAttr);
		writer.print("<br><br>");
		
		//application
		Object applicationAttr = getServletContext().getAttribute("applicationAttr");
		writer.print("applicationAttr:"+applicationAttr );
		
		
		/*
		 * 
		 * attr_1.jsp
		 * attr_2.jsp
		 * TestServlet
		 * 
		 * 
		 */
		
	
		
	}
	
	
	

}
