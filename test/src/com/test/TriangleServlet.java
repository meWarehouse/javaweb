package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author wen
 *
 */
@WebServlet(urlPatterns = "/TriangleServlet",initParams = {
		@WebInitParam(name = "triangle", value = "三角形面积和周长")
})
public class TriangleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TriangleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Double a = Double.parseDouble(request.getParameter("a"));
		Double b = Double.parseDouble(request.getParameter("b"));
		Double c = Double.parseDouble(request.getParameter("c"));
		
		double perimeter = a + b + c;
		double area = Math.sqrt(perimeter*(perimeter-a)*(perimeter-b)*(perimeter-c));
		
		PrintWriter out = response.getWriter();
		out.append("周长："+perimeter + "<br>面积："+area);
		
	}

}
