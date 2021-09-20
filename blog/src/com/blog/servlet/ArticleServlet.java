package com.blog.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.blog.bean.Article;
import com.blog.bean.Critique;
import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.dao.impl.ArticleDAOImpl;
import com.blog.dao.impl.CritiqueDAOImpl;

@WebServlet("/article/article")
public class ArticleServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public ArticleServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//因为第一次进来，page是1
        int   page=1;
        //获取页数的值    第一次获取strpage是null  第二次第三次page就有值了
        String    strpage=request.getParameter("page");
        if(strpage!=null){
        	      int    inpage=Integer.parseInt(strpage);  //字符串数字变成int型的数字
        	      
        	      page=inpage;
        	      //这是写一页就大于最大的页数了
        	      if(page>getTotalPage()){
        	    	     page=getTotalPage();
        	      }
        	      //小于最小的页数
        	      if(page<1){
        	    	     page=1;
        	      }
        }
        //把总共的页数传给jsp
        request.setAttribute("totalPage",getTotalPage());
        //把当前的页数号传给jsp
        request.setAttribute("page", page);
        
        
        ArticleDAO      articleDAO=new   ArticleDAOImpl();
        //这是根据页数查找对应的文章
        List<Article>   articlesPage=articleDAO.findArticlesByPage(page);
        //这是把页数对应的文章向jsp传递
	    request.setAttribute("articlesPage", articlesPage);
	
	
	    //向jsp传递推荐的文章
	    List<Article>   articlesRecommend=articleDAO.findArticlesRecommend();
	    request.setAttribute("articlesRecommend", articlesRecommend);
	    
	    //向jsp传递点击排行文章
	    List<Article>   articlesHot=articleDAO.findArticlesHot();
	    request.setAttribute("articlesHot", articlesHot);
	    
	    
	    CritiqueDAO     critiqueDAO=new    CritiqueDAOImpl();
	    //向jsp传递评论信息
	    List<Critique>    critiquesNew=critiqueDAO.findCritiquesNew();
	    request.setAttribute("critiquesNew", critiquesNew);
	    
	
	    RequestDispatcher     dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/article.jsp");
	    dispatcher.forward(request, response);
		
	}
	//获取总共的页数
		@Test
		public   int   getTotalPage(){
			   ArticleDAO    articleDAO=new   ArticleDAOImpl();
			   List<Article>   lists=articleDAO.findArticlesAll();
			   int    sum=lists.size();  //获取多少篇文章
			   //一页多少篇
			   int   num=5;
			   //总共的页数
			   int   totalPage=0;
			   //求页数    整除，余数就是0
			   if(sum%num==0){
				        totalPage=sum/num;
			   }else{
				        totalPage=sum/num+1;
			   }
			   System.out.println("totalPage="+totalPage);
			   return     totalPage;
			   
		}
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
