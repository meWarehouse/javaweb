package com.blog.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.bean.Album;
import com.blog.bean.Article;
import com.blog.bean.Critique;
import com.blog.dao.AlbumDAO;
import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.factory.DAOFactory;

/**
 * Servlet implementation class AblumServlet
 */
@WebServlet("/album/album")
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlbumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    AlbumDAO        albumDAO=DAOFactory.getAlbumDAO();
		    List<Album>     albumsAll=albumDAO.findAlbumsAll();
		    request.setAttribute("albumsAll",albumsAll);
		
		
		    ArticleDAO  articleDAO=DAOFactory.getArticleDAO();//高级会利用代理思想
		   //排行的文章
	        List<Article>     articlesHot=articleDAO.findArticlesHot();
	        request.setAttribute("articlesHot",articlesHot);
	        
	        //获取推荐的文章
	        List<Article>    articlesRecommend=articleDAO.findArticlesRecommend();
	        request.setAttribute("articlesRecommend", articlesRecommend);
	
	        CritiqueDAO   critiqueDAO=DAOFactory.getCritiqueDAO();
	        
	        //最新的评论
	        List<Critique>   critiquesNew=critiqueDAO.findCritiquesNew();
	        request.setAttribute("critiquesNew", critiquesNew);
	        
	        //跳转
	        RequestDispatcher    dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/album.jsp");
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
