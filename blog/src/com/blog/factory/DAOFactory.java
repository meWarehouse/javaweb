package com.blog.factory;

import com.blog.dao.AlbumDAO;
import com.blog.dao.ArticleDAO;
import com.blog.dao.CritiqueDAO;
import com.blog.dao.MeDAO;
import com.blog.dao.PhotoDAO;
import com.blog.dao.impl.AlbumDAOImpl;
import com.blog.dao.impl.ArticleDAOImpl;
import com.blog.dao.impl.CritiqueDAOImpl;
import com.blog.dao.impl.MeDAOImpl;
import com.blog.dao.impl.PhotoDAOImpl;

public  class DAOFactory {
       public static    MeDAO     getMeDAO(){
    	       return    new   MeDAOImpl();
       }
       public  static   ArticleDAO   getArticleDAO(){  //多态的思想
    	       return   new   ArticleDAOImpl();
       }
       public  static    CritiqueDAO  getCritiqueDAO(){
    	       return   new    CritiqueDAOImpl();
       }
       public  static    AlbumDAO      getAlbumDAO(){
    	       return   new    AlbumDAOImpl();
       }
       public  static    PhotoDAO      getPhotoDAO(){
    	       return   new    PhotoDAOImpl();
       }
}
