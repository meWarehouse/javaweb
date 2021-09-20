package com.kc.demo;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.UserException;

public class AuthorityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	UserDAO userDAO = new UserDAO();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String methodName = req.getParameter("method");
		System.out.println("methodName : " + methodName);

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);

			method.setAccessible(true);
			method.invoke(this, req, resp);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private void updateAuthority(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	@SuppressWarnings("unused")
	private void getAuthority(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * authority-manager.jsp 提交表单后：获取表单的请求参数：username，在根据 username 获取 User 信息， 将
		 * user放入到 request 中，转发到 authority-manager.jsp
		 * 
		 * authority-manager.jsp 修改权限的表单提交后：获取请求参数：username，authority（多选）；把选项封装为 List；调用
		 * UserDAO 的 update() 方法实现权限的修改；重定向到 authority-manager.jsp
		 * 
		 */

		String username = request.getParameter("username");
		if (username != null && !username.trim().equals("")) {

			User user = userDAO.get(username);

			if (user != null) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("/demo/authority-manager.jsp");
				return;
			}
		}

		response.sendRedirect(request.getContextPath() + "/demo/login.jsp");

	}

}
