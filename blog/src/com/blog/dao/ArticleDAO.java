package com.blog.dao;

import java.util.List;

import com.blog.bean.Article;

public interface ArticleDAO {
	    /**
	     * ���Ǹ���id��ѯָ��������
	     * @param id
	     * @return
	     */
        public   Article    findArticleById(Integer  id);
        /**
         * ��ȡ��һƪ����
         * @param id
         * @return
         */
        public   Article    findArticleBefore(Integer  id);
        /**
         * ��ȡ��һƪ����
         * @param id
         * @return
         */
        public   Article    findArticleAfter(Integer  id);
        /**
         * ��ѯ��������
         * @return
         */
        public   List<Article>    findArticlesAll();
        /**
         * ��ҳ��ѯ
         * @param page
         * @return
         */
        public   List<Article>    findArticlesByPage(int  page);
        /**
         * ��ȡ�ܹ���ҳ��
         */
        public    int    getTotalPage();
        /**
         * ��ȡ���µ�����
         * @return
         */
        public   List<Article>    findArticlesNew();
        /**
         * ��ȡ�Ƽ�������
         * @return
         */
        public   List<Article>    findArticlesRecommend();
        /**
         * ��ȡ���������ǰ������
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



