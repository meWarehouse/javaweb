package com.kc.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessStep1
 */

public class ProcessStep1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取选中的图书的信息
		String[] books = request.getParameterValues("book");
		
		//2.将 图书信息放入 HttpSession 下、中
		request.getSession().setAttribute("books", books);
		
		//3.重定向页面到 shoppingcart/step-2.jsp
		System.out.println(request.getContextPath()+"/shoppingcart/step-2.jsp");
		response.sendRedirect(request.getContextPath()+"/shoppingcart/step-2.jsp");//绝对路径
		
		
		
	}

}
