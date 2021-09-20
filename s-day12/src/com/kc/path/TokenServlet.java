package com.kc.path;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class TokenServlet
 */
@WebServlet("/tokenServlet")
public class TokenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name= req.getParameter("name");
		
		System.out.println("name:"+name);
		
		HttpSession session = req.getSession();
		
		Object token = session.getAttribute("token");//请求参数
		String tokenValue = req.getParameter("token");//参数值
		System.out.println("参数 session："+token);
		System.out.println("参数值 ："+tokenValue);
		
		
		if(token != null && token.equals(tokenValue)) {
			session.removeAttribute("token");
		}else {
			resp.sendRedirect(req.getContextPath()+"/token/token.jsp");
			return;
		}
		
//		req.getRequestDispatcher("/token/success.jsp").forward(req, resp);
		resp.sendRedirect(req.getContextPath()+"/token/success.jsp");
		
		
	}

}
