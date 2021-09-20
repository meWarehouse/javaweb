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
		//��Ϊ��һ�ν�����page��1
        int   page=1;
        //��ȡҳ����ֵ    ��һ�λ�ȡstrpage��null  �ڶ��ε�����page����ֵ��
        String    strpage=request.getParameter("page");
        if(strpage!=null){
        	      int    inpage=Integer.parseInt(strpage);  //�ַ������ֱ��int�͵�����
        	      
        	      page=inpage;
        	      //����дһҳ�ʹ�������ҳ����
        	      if(page>getTotalPage()){
        	    	     page=getTotalPage();
        	      }
        	      //С����С��ҳ��
        	      if(page<1){
        	    	     page=1;
        	      }
        }
        //���ܹ���ҳ������jsp
        request.setAttribute("totalPage",getTotalPage());
        //�ѵ�ǰ��ҳ���Ŵ���jsp
        request.setAttribute("page", page);
        
        
        ArticleDAO      articleDAO=new   ArticleDAOImpl();
        //���Ǹ���ҳ�����Ҷ�Ӧ������
        List<Article>   articlesPage=articleDAO.findArticlesByPage(page);
        //���ǰ�ҳ����Ӧ��������jsp����
	    request.setAttribute("articlesPage", articlesPage);
	
	
	    //��jsp�����Ƽ�������
	    List<Article>   articlesRecommend=articleDAO.findArticlesRecommend();
	    request.setAttribute("articlesRecommend", articlesRecommend);
	    
	    //��jsp���ݵ����������
	    List<Article>   articlesHot=articleDAO.findArticlesHot();
	    request.setAttribute("articlesHot", articlesHot);
	    
	    
	    CritiqueDAO     critiqueDAO=new    CritiqueDAOImpl();
	    //��jsp����������Ϣ
	    List<Critique>    critiquesNew=critiqueDAO.findCritiquesNew();
	    request.setAttribute("critiquesNew", critiquesNew);
	    
	
	    RequestDispatcher     dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/article.jsp");
	    dispatcher.forward(request, response);
		
	}
	//��ȡ�ܹ���ҳ��
		@Test
		public   int   getTotalPage(){
			   ArticleDAO    articleDAO=new   ArticleDAOImpl();
			   List<Article>   lists=articleDAO.findArticlesAll();
			   int    sum=lists.size();  //��ȡ����ƪ����
			   //һҳ����ƪ
			   int   num=5;
			   //�ܹ���ҳ��
			   int   totalPage=0;
			   //��ҳ��    ��������������0
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
