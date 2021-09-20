package com.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.bean.Article;
import com.blog.bean.Critique;
import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.factory.DAOFactory;

/**
 * Servlet implementation class CritiqueServlet
 */
@WebServlet("/critique/critique")
public class CritiqueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CritiqueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		       CritiqueDAO   critiqueDAO=DAOFactory.getCritiqueDAO();
		       int    page=1;
		       
		       //第一次获取的值，是null的。当点击下一页或者第二页的时候才会有值
	          String   strPage=request.getParameter("page");
	          if(strPage!=null){
	        	        page=Integer.parseInt(strPage);//你可能点击下一页，或者上一页或者其他页
	          }
	          
		        request.setAttribute("page", page);
		        
		        int   totalPage=critiqueDAO.findTotalPage();
		        request.setAttribute("totalPage", totalPage);
		        
		        //查询第一页的评论数据
		        List<Critique>    critiquesPage=critiqueDAO.findCritiquesByPage(page);
		        request.setAttribute("critiquesPage", critiquesPage);
		        
		        
		        ArticleDAO    articleDAO=DAOFactory.getArticleDAO();
		        //排行的文章
		        List<Article>     articlesHot=articleDAO.findArticlesHot();
		        request.setAttribute("articlesHot",articlesHot);
		        
		        //获取推荐的文章
		        List<Article>    articlesRecommend=articleDAO.findArticlesRecommend();
		        request.setAttribute("articlesRecommend", articlesRecommend);
		        
		        //跳转
	            RequestDispatcher    dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/critique.jsp");
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
