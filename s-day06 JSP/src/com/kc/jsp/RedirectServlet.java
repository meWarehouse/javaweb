package com.kc.jsp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectServlet")
public class RedirectServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("RedirectServlet's doGet ");
		
		
		request.setAttribute("name", "12345");
		System.out.println("RedirectServlet's name : " + request.getAttribute("name"));
		
		
		//执行请求的重定向  直接调用response.sendRedirect(path)  path为重定向的地址
		String path = "test_servlet";
		response.sendRedirect(path);
		
		
		
		/*
		 * RedirectServlet
		 * ForwardServlet
		 * Test_Servlet
		 * 
		 * 
		 * 	请求的转发与重定向：
		 * 		1.本质区别：请求的转发只发出了一次请求，而重定向则发出两次请求
		 * 		2.具体区别：
		 * 			①.请求的转发：地址栏是初次发出请求的地址
		 * 			      请求重定向：地址栏不再是初次发出的请求地址，而是最后响应的那个地址
		 * 			②.请求的转发：在最终的Servlet中，request 对象和中转的那个 request 是同一个对象
		 * 			      请求重定向：在最终的Servlet中，request 对象和中转的那个 request 不是同一个对象
		 * 			③.请求的转发：只能转发给当前WEB应用的资源
		 * 			      请求重定向：可以重定向到任何资源
		 * 			④.请求的转发：/ 代表的是当前WEB应用的根目录
		 * 			      请求重定向：/ 代表的是当前WEB站点的根目录 
		 * 
		 * 
		 */
		
		
	}

}
