package com.kc.path;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckCodeServlet
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1. 获取请求参数   CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
		
		//2. 获取 session 中的 CHECK_CODE_KEY
		HttpSession session = request.getSession();
		String sessionCode = (String) session.getAttribute("CHECK_CODE_KEY");
		
		System.out.println(paramCode);
		System.out.println(sessionCode);
		
		//3. 对比，是否一致，若一致说明验证码正确，若不一致说明验证码错误
		if(!(paramCode != null && paramCode.equalsIgnoreCase(sessionCode))) {
			session.setAttribute("message","验证码不一致!!!");
			//验证码错误 重定向回原页面
			response.sendRedirect(request.getContextPath()+"/check/index.jsp");
			
			return;
		}
		
		
		//验证码正确
		System.out.println("受理请求");
		
	}

}
