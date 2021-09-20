package com.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.blog.bean.Me;
import com.blog.dao.MeDAO;
import com.blog.factory.DAOFactory;


/**
 * Servlet implementation class AboutMeServlet
 */
@WebServlet("/about/about")
public class AboutMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutMeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    /*
     * 把大象放进冰箱分几步
     */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * 男生准备好礼金   dao,util
	 * 媒婆把礼金发送给女生,servlet
	 * 女生接收礼金成功相亲,jsp
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     MeDAO    meDao=DAOFactory.getMeDAO();
		     Me       me=meDao.findMeById();
           
		     //把me的信息传给jsp
		     request.setAttribute("me", me);
		     
		     //跳转到哪个页面,它可以传参数
	         RequestDispatcher    dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/aboutMe.jsp");
	         dispatcher.forward(request, response);
	}
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
