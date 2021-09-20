package com.kc.progect.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kc.progect.dao.UserDAO;
import com.kc.progect.dao.impl.UserDAOImpl;
import com.kc.progect.domain.User;
import com.kc.progect.utils.MD5Utils;


public class UserRegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private UserDAO userDAO =  new UserDAOImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			resp.getWriter().print("Hello");
			
			String userName = req.getParameter("username");
			String userPassword = req.getParameter("userpassword");
			String userGender = req.getParameter("usergender");
			String userBrithday= req.getParameter("userbrithday");
			
			System.out.println("---------:"+userBrithday);
			
			String md5Password = MD5Utils.getMD5(userPassword);
			
			User user = new User(userName, md5Password, userGender, userBrithday,new Date(new java.util.Date().getTime()));
			
			userDAO.addUser(user);
			
//		req.setAttribute("user", user);
//		
//		req.getRequestDispatcher("/user/UserRegister.jsp").forward(req, resp);
//		
			
			resp.setContentType("text/json");
			
			resp.getWriter().write("{\"msg\":\"ok\"}");
		} catch (IOException e) {
			resp.setContentType("text/json");
			
			resp.getWriter().write("{\"msg\":\"error\"}");
		}
		
		
		
	}

}
