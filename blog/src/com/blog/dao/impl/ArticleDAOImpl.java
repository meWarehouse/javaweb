package com.blog.dao.impl;

import java.nio.channels.SelectableChannel;
import java.util.List;

import org.junit.Test;

import com.blog.bean.Article;
import com.blog.dao.ArticleDAO;
import com.blog.util.DBUtils;

public class ArticleDAOImpl  implements    ArticleDAO{
    private    DBUtils      dbutils=DBUtils.getDBUtils();//获取DBUtils对象
    
	@Override
	public Article findArticleById(Integer id)  {
		//大家最好不要写*  尽量把字段全部写出来
		/*
		 * ？：占位符，占一个位置
		 */
		String    sql="select  *    from   article  where   id=?";
		List<Article>      aritcles=dbutils.find(sql, id);//其实根据sql语句只能查询出来一个，这一个也存进去了数组里面
		Article            article=null;
		if(aritcles.size()>0){
			       article=aritcles.get(0);//获取集合的第一个元素
		}
		return article;
	}
	/**
     * 查询上一篇文章，我们是根据id查询的
     * 思想：比该id小的倒序第一个id    比如：id: 1     3     5            现在id是5，
     */
	@Override   
	public Article findArticleBefore(Integer id) {
		//它查询出来的是比id的小所有的数据
		String   sql="select *  from  article  where id<? order  by   id   desc";
		List<Article>    list=dbutils.find(sql, id);
		Article   article=null;
		//获取倒序的第一个,注意第一篇文章是没有上一篇文章，所以list里面有可能一个也没有
		if(list.size()>0){//万一没有
			  article=list.get(0);
		}
		return article;
	}

	@Override
	public Article findArticleAfter(Integer id) {
		     //它查询出来的是比id的大所有的数据
				String   sql="select *  from  article  where id>? order  by   id   asc";
				List<Article>    list=dbutils.find(sql, id);
				Article   article=null;
				//获取升序的第一个,注意最后一篇文章是没有下一篇文章，所以list里面有可能一个也没有
				if(list.size()>0){//万一没有
					  article=list.get(0);
				}
				return article;
	}
	@Override
	public List<Article> findArticlesAll() {
		String  sql="select  * from   article";
		List<Article>    list=dbutils.find(sql);
		return list;
	}

	/*
	第一个数字代表下标
	第二个数字代表一页几行

	第一页limit   0,5
	第二页limit   5,5
	第三页limit   10,5
	第page页limit (page-1)*5, 5;
	
	SELECT  *  FROM article   LIMIT 5,5;
	*/
	
	@Override
	public List<Article> findArticlesByPage(int page) {
			/*
			 * 查询分页，oracle跟mysql的写法不一样
			 */
		    int    num=5;  //定义一页几行;
		    int    index=(page-1)*5;//对应的下标
		    String  sql="select * from  article  limit ?,?";//第一个？代表下标，第二个问号代表一页几行、
		    List<Article>    list=dbutils.find(sql,index,num);
			return list;
	}
	@Test
    public  void  test(){
//    	  Article    article=findArticleById(6);
//    	  System.out.println("article="+article);
//    	  System.out.println(article.getTitle());
		
//		 List<Article>  lists=findArticlesAll();
//		 System.out.println(lists.size());
		 
		 List<Article>  lists=findArticlesByPage(2);
		 System.out.println(lists.size());
    }
	@Override
	public int getTotalPage() {
		List<Article>  lists=findArticlesAll();
		int  total=lists.size(); //总共的个数  6
		int  num=5;//一页5个
		int  totalPage=0;  //总共页数
		if(total%num==0){  //整除
			 totalPage=total/num;//0
		}else{
			 totalPage=total/num+1;
		}
		return totalPage;
	}

	@Override
	public List<Article> findArticlesNew() {
		//最新的显示5个，什么是最新的，id最大的
		int    numNew=5;
		String  sql="select * from  article order by id desc limit ?";
		List<Article>   lists=dbutils.find(sql,numNew);
		return lists;
	}
	 /**
     * 获取推荐的文章,按照评论量
     * @return
     */
	@Override
	public List<Article> findArticlesRecommend() {
		int   numRecommend=5;
		String  sql="select * from  article order by count1 desc limit ?";
		List<Article>   list=dbutils.find(sql, numRecommend);
		return list;
	}
	 /**
     * 获取点击排行在前的文章
     * @return
     */
	@Override
	public List<Article> findArticlesHot() {
		int   numHot=6;
		String  sql="select * from  article order by count desc limit ?";
		List<Article>   list=dbutils.find(sql, numHot);
		return list;
	}
	@Override
	public int addAricle(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAricle(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAricle(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}
}
