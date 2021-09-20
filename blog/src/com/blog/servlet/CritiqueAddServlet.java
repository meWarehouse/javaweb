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
import com.blog.dao.impl.CritiqueDAOImpl;
import com.blog.factory.DAOFactory;

/**
 * Servlet implementation class CritiqueAddServlet
 */
@WebServlet("/critique/critique_add")
public class CritiqueAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String   name=request.getParameter("name");
	        String   content=request.getParameter("content");
	        
	        //��ֹ��������
	        String   name2=new   String(name.getBytes("ISO8859-1"),"utf-8");
	        String   content2=new   String(content.getBytes("ISO8859-1"),"utf-8");
	        
	        Critique    critique=new   Critique();
	        critique.setName(name2);
	        critique.setContent(content2);
	        
	        CritiqueDAO   critiqueDAO=DAOFactory.getCritiqueDAO();
	        //����ɹ���num����1�����ɹ�����0�����߱��쳣��
	        int        num=critiqueDAO.addCritique(critique);  //�����ǵ�������ӵ����ݿ�
	        
	        int    page=1;
	        request.setAttribute("page", page);
	        
	        int   totalPage=critiqueDAO.findTotalPage();
	        request.setAttribute("totalPage", totalPage);
	        
	        //��ѯ��һҳ����������
	        List<Critique>    critiquesPage=critiqueDAO.findCritiquesByPage(page);
	        request.setAttribute("critiquesPage", critiquesPage);
	        
	        
	        ArticleDAO    articleDAO=DAOFactory.getArticleDAO();
	        //���е�����
	        List<Article>     articlesHot=articleDAO.findArticlesHot();
	        request.setAttribute("articlesHot",articlesHot);
	        
	        //��ȡ�Ƽ�������
	        List<Article>    articlesRecommend=articleDAO.findArticlesRecommend();
	        request.setAttribute("articlesRecommend", articlesRecommend);
	        
	        //��ת
            RequestDispatcher    dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/critique.jsp");
            dispatcher.forward(request, response);
	}
}
