
package com.test.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.dao.UserDAO;
import com.test.dao.impl.UserDAOImpl;
import com.test.domain.User;
import com.test.web.CriteriaUser;
import com.test.web.Page;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methodName = request.getParameter("method");
		System.out.println("methodName:" + methodName);

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);

		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	protected void update(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String username = request.getParameter("username");
//		String oldName = request.getParameter("oldName");
//		String age = request.getParameter("age");
//		String idstr = request.getParameter("id").trim();
//
//		System.out.println("username" + username);
//		System.out.println("oldname" + oldName);
//		System.out.println("age" + age);
//		System.out.println("id" + idstr);
//
//		if (!oldName.equals(username)) {
////			int num = (int) userDAO.getWithNameEqual(username);
//			System.out.println("--==========================--:" + num);
//
//			if (num > 0) {
//				request.setAttribute("msg", "请从新填写，name为" + username + "的用户已存在");
//				request.getRequestDispatcher("update.jsp").forward(request, response);
//				return;
//			}
//		}
//
////		User u = new User(Integer.parseInt(idstr), username, age);
//
//		userDAO.update(u);
//
//		// request.getRequestDispatcher("index.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/index.jsp"); //
//		search(request, response);
//
//	}
//
//	protected void forward(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String idstr = request.getParameter("id");
//		User user = userDAO.getUserFromId(Integer.parseInt(idstr));
//		request.setAttribute("user", user);
//		String path = request.getParameter("path");
//		request.getRequestDispatcher(path + ".jsp").forward(request, response);
//	}
//
//	protected void delete(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String idstr = request.getParameter("id");
//		int id = 0;
//		try {
//			id = Integer.parseInt(idstr);
//		} catch (NumberFormatException e) { // TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		userDAO.deleteFromId(id); //
//		request.getRequestDispatcher("index.jsp").forward(request, response);
//		response.sendRedirect(request.getContextPath() + "/index.jsp");
//
//	}
//
//	protected void addUser(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		String username = request.getParameter("username");
//		String age = request.getParameter("age");
//
//		System.out.println("username:" + username);
//		System.out.println("age:" + age);
//
//		int age1 = -1;
//
//		try {
//			age1 = Integer.parseInt(age);
//		} catch (NumberFormatException e) {
//			request.setAttribute("msg", "年龄格式错误");
//			request.getRequestDispatcher("addNewUser.jsp").forward(request, response);
//			return;
//		}
//
//		int num = (int) userDAO.getWithNameEqual(username);
//		System.out.println("------------------:" + num);
//		System.out.println("-==========================");
//
//		if (num > 0) {
//			request.setAttribute("msg", "请从新填写，name为" + username + "的用户已存在");
//			request.getRequestDispatcher("addNewUser.jsp").forward(request, response);
//			return;
//		}
//
//		User user = new User(username, age);
//
//		userDAO.addUser(user);
//
//		// request.getRequestDispatcher("index.jsp").forward(request, response);
//
//		response.sendRedirect(request.getContextPath() + "/index.jsp");
//
//	}

	private UserDAO userDAO = new UserDAOImpl();

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String idCard = request.getParameter("idcard");
		String pageNoStr = request.getParameter("pageNo");

		System.out.println("name:" + name + ",idCard:" + idCard + ",pageNo:" + pageNoStr);

		int pageNo = 1;

		try {
			pageNo = Integer.getInteger(pageNoStr);
		} catch (Exception e) {
		}

		System.out.println("pageno--:"+pageNo);
		
		CriteriaUser cu = new CriteriaUser(idCard, name, pageNo);

		Page<User> page = userDAO.getPage(cu);

		request.setAttribute("pageuser", page);

		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
