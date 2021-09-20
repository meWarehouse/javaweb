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
	              //��ȡ�ܹ���ҳ�� ��̬��˼�룬
		          ArticleDAO  articleDAO=DAOFactory.getArticleDAO();//�߼������ô���˼��
		         //ArticleDAOImpl  articleDAOImpl2=new  ArticleDAOImpl();
		          int     totalPage=articleDAO.getTotalPage(); 
		          request.setAttribute("totalPage", totalPage);
		          
		          //��ȡ���µ�����
		          List<Article>    articlesNew=articleDAO.findArticlesNew();
		          request.setAttribute("articlesNew", articlesNew);
		          
		          //��ȡ�Ƽ�������
		          List<Article>    articlesRecommend=articleDAO.findArticlesRecommend();
		          request.setAttribute("articlesRecommend", articlesRecommend);
		          
		          //��ȡ��һҳ������
		          int    page=1;
		          
		        //��һ�λ�ȡ��ֵ����null�ġ��������һҳ���ߵڶ�ҳ��ʱ��Ż���ֵ
		          String   strPage=request.getParameter("page");
		          if(strPage!=null){
		        	        page=Integer.parseInt(strPage);//����ܵ����һҳ��������һҳ��������ҳ
		          }
		          
		          
		          
		          //����ҳ����ȡ��Ӧ������
		          List<Article>    articlesPage=articleDAO.findArticlesByPage(page);
		          request.setAttribute("page", page);
		          request.setAttribute("articlesPage",articlesPage);
		          
		          //��ת
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
