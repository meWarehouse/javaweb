package com.blog.dao.impl;

import java.nio.channels.SelectableChannel;
import java.util.List;

import org.junit.Test;

import com.blog.bean.Article;
import com.blog.dao.ArticleDAO;
import com.blog.util.DBUtils;

public class ArticleDAOImpl  implements    ArticleDAO{
    private    DBUtils      dbutils=DBUtils.getDBUtils();//��ȡDBUtils����
    
	@Override
	public Article findArticleById(Integer id)  {
		//�����ò�Ҫд*  �������ֶ�ȫ��д����
		/*
		 * ����ռλ����ռһ��λ��
		 */
		String    sql="select  *    from   article  where   id=?";
		List<Article>      aritcles=dbutils.find(sql, id);//��ʵ����sql���ֻ�ܲ�ѯ����һ������һ��Ҳ���ȥ����������
		Article            article=null;
		if(aritcles.size()>0){
			       article=aritcles.get(0);//��ȡ���ϵĵ�һ��Ԫ��
		}
		return article;
	}
	/**
     * ��ѯ��һƪ���£������Ǹ���id��ѯ��
     * ˼�룺�ȸ�idС�ĵ����һ��id    ���磺id: 1     3     5            ����id��5��
     */
	@Override   
	public Article findArticleBefore(Integer id) {
		//����ѯ�������Ǳ�id��С���е�����
		String   sql="select *  from  article  where id<? order  by   id   desc";
		List<Article>    list=dbutils.find(sql, id);
		Article   article=null;
		//��ȡ����ĵ�һ��,ע���һƪ������û����һƪ���£�����list�����п���һ��Ҳû��
		if(list.size()>0){//��һû��
			  article=list.get(0);
		}
		return article;
	}

	@Override
	public Article findArticleAfter(Integer id) {
		     //����ѯ�������Ǳ�id�Ĵ����е�����
				String   sql="select *  from  article  where id>? order  by   id   asc";
				List<Article>    list=dbutils.find(sql, id);
				Article   article=null;
				//��ȡ����ĵ�һ��,ע�����һƪ������û����һƪ���£�����list�����п���һ��Ҳû��
				if(list.size()>0){//��һû��
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
	��һ�����ִ����±�
	�ڶ������ִ���һҳ����

	��һҳlimit   0,5
	�ڶ�ҳlimit   5,5
	����ҳlimit   10,5
	��pageҳlimit (page-1)*5, 5;
	
	SELECT  *  FROM article   LIMIT 5,5;
	*/
	
	@Override
	public List<Article> findArticlesByPage(int page) {
			/*
			 * ��ѯ��ҳ��oracle��mysql��д����һ��
			 */
		    int    num=5;  //����һҳ����;
		    int    index=(page-1)*5;//��Ӧ���±�
		    String  sql="select * from  article  limit ?,?";//��һ���������±꣬�ڶ����ʺŴ���һҳ���С�
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
		int  total=lists.size(); //�ܹ��ĸ���  6
		int  num=5;//һҳ5��
		int  totalPage=0;  //�ܹ�ҳ��
		if(total%num==0){  //����
			 totalPage=total/num;//0
		}else{
			 totalPage=total/num+1;
		}
		return totalPage;
	}

	@Override
	public List<Article> findArticlesNew() {
		//���µ���ʾ5����ʲô�����µģ�id����
		int    numNew=5;
		String  sql="select * from  article order by id desc limit ?";
		List<Article>   lists=dbutils.find(sql,numNew);
		return lists;
	}
	 /**
     * ��ȡ�Ƽ�������,����������
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
     * ��ȡ���������ǰ������
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
