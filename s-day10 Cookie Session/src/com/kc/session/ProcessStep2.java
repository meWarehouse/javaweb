package com.kc.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProcessStep2
 */
@WebServlet("/processStep2")
public class ProcessStep2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取请求参数：name，address，cardtype，card
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String cardtype = request.getParameter("cardtype");
		String card = request.getParameter("card");
		
		Customer customer = new Customer(name, address, cardtype, card);
		
		//2.将请求信息存入 HttpSession 中
		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		
		
		//3.重定向到 confirm.jsp 
		response.sendRedirect(request.getContextPath()+"/shoppingcart/confirm.jsp");
		
	}

}
