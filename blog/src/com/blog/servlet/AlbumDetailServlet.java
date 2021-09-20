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
import com.blog.bean.Photo;
import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.dao.PhotoDAO;
import com.blog.factory.DAOFactory;

/**
 * Servlet implementation class AlbumDetailServlet
 */
@WebServlet("/album/album_detail")
public class AlbumDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	            String     strId=request.getParameter("id");  
	            System.out.println("123"+strId);
			    Integer    album_id=Integer.valueOf(strId);         
	            //�Ǹ������id���Ҷ�Ӧ�����е���Ƭ
	            PhotoDAO   photoDAO=DAOFactory.getPhotoDAO();
	            List<Photo>   allPhotos=photoDAO.findAllPhotos(album_id);
	            request.setAttribute("allPhotos", allPhotos);
	            
	            
                ArticleDAO  articleDAO=DAOFactory.getArticleDAO();//�߼������ô���˼��
	  		    //���е�����
	  	        List<Article>     articlesHot=articleDAO.findArticlesHot();
	  	        request.setAttribute("articlesHot",articlesHot);
	  	        
	  	        //��ȡ�Ƽ�������
	  	        List<Article>    articlesRecommend=articleDAO.findArticlesRecommend();
	  	        request.setAttribute("articlesRecommend", articlesRecommend);
	  	
	  	        CritiqueDAO   critiqueDAO=DAOFactory.getCritiqueDAO();
	  	        
	  	        //���µ�����
	  	        List<Critique>   critiquesNew=critiqueDAO.findCritiquesNew();
	  	        request.setAttribute("critiquesNew", critiquesNew);
		             
		             
	             //��ת
	 	        RequestDispatcher    dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/album_detail.jsp");
	 	        dispatcher.forward(request, response);
	 	        System.out.println(123);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
