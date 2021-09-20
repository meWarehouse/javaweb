package com.blog.dao;

import java.util.List;

import com.blog.bean.Article;

public interface ArticleDAO {
	    /**
	     * 它是根据id查询指定的文章
	     * @param id
	     * @return
	     */
        public   Article    findArticleById(Integer  id);
        /**
         * 获取上一篇文章
         * @param id
         * @return
         */
        public   Article    findArticleBefore(Integer  id);
        /**
         * 获取下一篇文章
         * @param id
         * @return
         */
        public   Article    findArticleAfter(Integer  id);
        /**
         * 查询所有文章
         * @return
         */
        public   List<Article>    findArticlesAll();
        /**
         * 分页查询
         * @param page
         * @return
         */
        public   List<Article>    findArticlesByPage(int  page);
        /**
         * 获取总共的页数
         */
        public    int    getTotalPage();
        /**
         * 获取最新的文章
         * @return
         */
        public   List<Article>    findArticlesNew();
        /**
         * 获取推荐的文章
         * @return
         */
        public   List<Article>    findArticlesRecommend();
        /**
         * 获取点击排行在前的文章
         * @return
         */
        public   List<Article>    findArticlesHot();
        /*
         * 
         */
        public   int      addAricle(Article  article);
        public   int      updateAricle(Article  article);
        public   int      deleteAricle(Integer   id);
}



