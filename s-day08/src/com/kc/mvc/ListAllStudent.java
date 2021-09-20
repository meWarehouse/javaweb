package com.kc.mvc;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListAllStudent
 */
@WebServlet("/listAllStudent")
public class ListAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<Student> allStudents = new StudentDao().getAll();

		List<Student> allStudents = new StudentDao1().getListStudent();
		
		request.setAttribute("allStudents", allStudents);
		
		request.getRequestDispatcher("students.jsp").forward(request, response);
		
		
	}

}
