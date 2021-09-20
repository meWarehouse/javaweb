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

import com.blog.bean.Article;
import com.blog.dao.ArticleDAO;
import com.blog.dao.impl.ArticleDAOImpl;
import com.blog.factory.DAOFactory;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public IndexServlet() {
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	              //获取总共的页数 多态的思想，
		          ArticleDAO  articleDAO=DAOFactory.getArticleDAO();//高级会利用代理思想
		         //ArticleDAOImpl  articleDAOImpl2=new  ArticleDAOImpl();
		          int     totalPage=articleDAO.getTotalPage(); 
		          request.setAttribute("totalPage", totalPage);
		          
		          //获取最新的文章
		          List<Article>    articlesNew=articleDAO.findArticlesNew();
		          request.setAttribute("articlesNew", articlesNew);
		          
		          //获取推荐的文章
		          List<Article>    articlesRecommend=articleDAO.findArticlesRecommend();
		          request.setAttribute("articlesRecommend", articlesRecommend);
		          
		          //获取第一页的数据
		          int    page=1;
		          
		        //第一次获取的值，是null的。当点击下一页或者第二页的时候才会有值
		          String   strPage=request.getParameter("page");
		          if(strPage!=null){
		        	        page=Integer.parseInt(strPage);//你可能点击下一页，或者上一页或者其他页
		          }
		          
		          
		          
		          //根据页数获取对应的文章
		          List<Article>    articlesPage=articleDAO.findArticlesByPage(page);
		          request.setAttribute("page", page);
		          request.setAttribute("articlesPage",articlesPage);
		          
		          //跳转
		          RequestDispatcher    dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		          dispatcher.forward(request, response);
		          System.out.println(123);
	}
	@Test
	public   void   test(){
		    try {
				doGet(null, null);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
