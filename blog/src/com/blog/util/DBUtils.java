package com.blog.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Album;
import com.blog.bean.Article;
import com.blog.bean.Critique;
import com.blog.bean.Me;
import com.blog.bean.Photo;


/**
 * ����������ݿ�����Ӳ�����
 * @author Administrator
 *
 */
public class DBUtils {
	     //mysql�����ӷ�ʽ�������oracleע�⣬�Ͳ�����ôд��
//         private    static    String     URL="jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8";
         private    static    String     URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
         private    static    String     DRIVER="com.mysql.jdbc.Driver";
         private    static    String     USER="root";
         private    static    String     PASSWORD="root";
         
         static{
        	      //1.����������
        	      try {
					Class.forName(DRIVER);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
         }
         
         //����
         private     static   DBUtils   dbUtils=new  DBUtils();
         private     DBUtils(){  //��֤�ⲿ�಻�ܴ�������
        	    
         }
         public   static    DBUtils    getDBUtils(){
        	         return  dbUtils;
         }
         
         
         public    static     Connection    getConnection() throws SQLException{
                  //2.���ݿ�����        	     
        	      Connection   connection=DriverManager.getConnection(URL, USER, PASSWORD);
        	      return  connection;
         }
         
         
         /**
          * ��ѯ����
          * @param sql     ���յ�sql���
          * @param args    ���յĲ���ֵ
          * @return
          */
         //dbutils.find(sql, 3);   Ҳ����˵args������һ��3
         //args=new Object[]{3}
         public        List<Article>     find(String sql,Object...  args){//args������3
        	       Connection                 connection=null;
        	       /**
        	        * �����֪��PreparedStatement��String    sql="select  *    from   article  where   id=?";��id����
        	        * ��ȥ��jim��ʦmysql��Ƶ��
        	        */
        	       PreparedStatement          pStatement=null;//����������ݿ���
        	       ResultSet                  rs=null; //�����ѯ�Ľ����
        	       List<Article>              lists=new   ArrayList<Article>();//����һ�����ϴ洢����
        	        try {
						    connection=getConnection(); //���ݿ�����
						    
						    //3.�������ݿ�
						    /*
						     * Ϊʲô��PreparedStatement��
						     * ��Ϊ�����Դ���Ԥ��������
						     */
						    //select * from  article order by count1 desc limit 3
						    pStatement=connection.prepareStatement(sql);//�������ݿ������
						    
						    //����ܹ��˵�û�в�����ʱ��  args.length=1
						    for (int i = 0; i < args.length; i++) {//i=1
						    	  //���ʺŸ�ֵ
							      pStatement.setObject(i+1, args[i]);//1����һ���ʺ�    args[0]����id
							}
						   
						    //����sql����ѯ�Ľ����
						    rs=pStatement.executeQuery();//���ؽ������������������ÿ�е�����
						    
						    
						    while(rs.next()){ //�жϽ������û��ֵ
		    	    	         //�����ǲ�ѯÿ�ж�Ӧÿ�е�ֵ
		    	    	         Integer     id=(Integer) rs.getObject("id");//��ȡid�ж�Ӧ��ֵ
			   	   		         String      title=(String) rs.getObject("title");
			   	   		         String      content=(String) rs.getObject("content");
			   	   		         String      image=(String) rs.getObject("image");
			   	   		         String      time=(String) rs.getObject("time");
			   	   		         String      editer=(String) rs.getObject("editer");
			   	   		         Integer      count=(Integer) rs.getObject("count");
			   	   		         Integer      count1=(Integer) rs.getObject("count1");
			   	   		         String      type=(String) rs.getObject("type");
			   	   		         String      keywords=(String) rs.getObject("keywords");
			   	   		         String      notice=(String) rs.getObject("notice");
			   	   		        		 
			   	   		        
			   	   		        //����Article���󣬴洢����ÿ�е�ֵ�����е�һ��������ʵ�Ƕ�ӦArticle��һ������
			   	   		         Article   article=new  Article();
			   	   		         article.setContent(content);
			   	   		         article.setCount(count);
			   	   		         article.setCount1(count1);
			   	   		         article.setEditer(editer);
			   	   		         article.setId(id);
			   	   		         article.setImage(image);
			   	   		         article.setKeywords(keywords);
			   	   		         article.setNotice(notice);
			   	   		         article.setTime(time);
			   	   		         article.setTitle(title);
			   	   		         article.setType(type);
				   	   		        
				   	   		         //��һ����image������ӵ���������
				   	   		         lists.add(article);
			    	    }
					} catch (SQLException e) {
						e.printStackTrace();
					} finally{
						close(rs, pStatement, connection);
					}
        	       return lists;
         }
         public        List<Critique>     findCritique(String sql,Object...  args){//args������3
	  	       Connection                 connection=null;
	  	       PreparedStatement          pStatement=null;//����������ݿ���
	  	       ResultSet                  rs=null; //�����ѯ�Ľ����
	  	       List<Critique>              lists=new   ArrayList<Critique>();//����һ�����ϴ洢����
	  	        try {
					    connection=getConnection(); //���ݿ�����
					    pStatement=connection.prepareStatement(sql);//�������ݿ������
					    
					    //����ܹ��˵�û�в�����ʱ��  args.length=1
					    for (int i = 0; i < args.length; i++) {//i=1
					    	  //���ʺŸ�ֵ
						      pStatement.setObject(i+1, args[i]);//1����һ���ʺ�    args[0]����id
						}
					   
					    //����sql����ѯ�Ľ����
					    rs=pStatement.executeQuery();//���ؽ������������������ÿ�е�����
					    
					    
					    while(rs.next()){ //�жϽ������û��ֵ
					    	 Integer    id=(Integer) rs.getObject("id"); //��ȡ��һ�е�һ�е�����
		     	    	     Integer   article_id=(Integer)rs.getObject("article_id");
		     	    	     String     content=(String)rs.getObject("content");
		     	    	     String     time=(String)rs.getObject("time");
		     	    	     String     name=(String)rs.getObject("name");
		     	    	     String     photo=(String)rs.getObject("photo");
		     	    	     String     type=(String)rs.getObject("type");
		     	    	     String     notice=(String)rs.getObject("notice");
		     	    	      
		     	    	     
		     	    	     Critique      critique=new    Critique();
		     	    	     critique.setId(id);
		     	    	     critique.setArticleId(article_id);
		     	    	     critique.setContent(content);
		     	    	     critique.setName(name);
		     	    	     critique.setNotice(notice);
		     	    	     critique.setPhoto(photo);
		     	    	     critique.setTime(time);
		     	    	     critique.setType(type);
		     	    	     
		     	    	     //list����û����������
		     	    	     lists.add(critique);
		    	        }
				} catch (SQLException e) {
					e.printStackTrace();
				} finally{
					close(rs, pStatement, connection);
				}
  	       return lists;
   }
         /**
          * �÷���������ӣ�ɾ�����޸��κ����͵����� ��Ҳ����˵���Զ����еı�������ӣ�ɾ�����޸Ĳ�����
          * @param sql
          * @param objects
          * @return
          */
         public    int      executeUpdate(String sql,Object...  objects ){
        	    Connection           connection=null;
        	    PreparedStatement    pStatement2=null;
        	    int     num=0;
        	    try {
					connection=getConnection();
					pStatement2=connection.prepareStatement(sql);
					for (int i = 0; i < objects.length; i++) {
						 pStatement2.setObject(i+1, objects[i]);
					}
					num=pStatement2.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close(null, pStatement2, connection);
				}
        	     return  num;
         }
         
         public      List<Album>      findAlbum(String   sql,Object...    objects){
        	 Connection   connection=null;
	    	 PreparedStatement      pstat=null;
	    	 ResultSet   rs=null;
	    	 List<Album>     list=new    ArrayList<Album>();//׼����һ�����ϣ������洢Food����
	    	 try {
	    		connection=getConnection();
				pstat=connection.prepareStatement(sql);
				for (int i = 0; i < objects.length; i++) {
		    		 	pstat.setObject(i+1,objects[i]);
				 }
	     	     rs=pstat.executeQuery();
	     	     while(rs.next()){ //��û����һ������
	     	    	     Integer    id=(Integer) rs.getObject("id"); //��ȡ��һ�е�һ�е�����
	     	    	     String     title=(String)rs.getObject("title");
	     	    	     String     content=(String)rs.getObject("content");
	     	    	     String     time=(String)rs.getObject("time");
	     	    	     String     image=(String)rs.getObject("image");
	     	    	     String     notice=(String)rs.getObject("notice");
	     	    	      
	     	    	     //**********************************
	     	    	     Album      album=new   Album();
	     	    	     album.setId(id);//Ϊʲô��ôд�أ���Ϊ������Ҫ�������
	     	    	     album.setTime(time);
	     	    	     album.setTitle(title);
	     	    	     album.setContent(content);
	     	    	     album.setImage(image);
	     	    	     album.setNotice(notice);
	     	    	     
	     	    	     //list����û����������
	     	    	     list.add(album);
	     	     }
			} catch (SQLException e) {
				   e.printStackTrace();
			} finally{
				  close(rs,pstat,connection);
			}
	    	 //�������List�����ǲ��Ǿʹ洢�����е�Food����Ҳ����˵�洢�����е����ݡ�
	    	 return list;
         }
         public     List<Photo>   executeQueryPhoto(String sql,Object...  obj){
	    	 Connection   connection=null;
	    	 PreparedStatement      pstat=null;
	    	 ResultSet   rs=null;
	    	 List<Photo>     list=new    ArrayList<Photo>();//׼����һ�����ϣ������洢Food����
	    	 try {
	    		connection=getConnection();
				pstat=connection.prepareStatement(sql);
				for (int i = 0; i < obj.length; i++) {
		    		 	pstat.setObject(i+1,obj[i]);
				 }
	     	     rs=pstat.executeQuery();
	     	     while(rs.next()){ //��û����һ������
	     	    	     Integer    id=(Integer) rs.getObject("id"); //��ȡ��һ�е�һ�е�����
	     	    	     Integer    album_id=(Integer)rs.getObject("album_id");
	     	    	     String     content=(String)rs.getObject("content");
	     	    	     String     time=(String)rs.getObject("time");
	     	    	     String     image=(String)rs.getObject("image");
	     	    	     String     type=(String)rs.getObject("type");
	     	    	     String     notice=(String)rs.getObject("notice");
	     	    	     String     note=(String)rs.getObject("note");
	     	    	      
	     	    	     //**********************************
	     	    	     //��Ϊ����PhotoҪ�����������
	     	    	     Album      album=new   Album();
	     	    	     album.setId(album_id);//Ϊʲô��ôд�أ���Ϊ������Ҫ�������
	     	    	     
	     	    	     Photo      photo=new    Photo();
	     	    	     photo.setId(id);
	     	    	     photo.setContent(content);
     	    	    	 photo.setNotice(notice);
	     	    	     photo.setTime(time);
	     	    	     photo.setType(type);
	     	    	     photo.setNote(note);
	     	    	     photo.setImage(image);
	     	    	     photo.setAlbum(album);
	     	    	     //list����û����������
	     	    	     list.add(photo);
	     	     }
			} catch (SQLException e) {
				   e.printStackTrace();
			} finally{
				  close(rs,pstat,connection);
			}
	    	 //�������List�����ǲ��Ǿʹ洢�����е�Food����Ҳ����˵�洢�����е����ݡ�
	    	 return list;
	    }
         public     List<Me>   executeQueryMe(String sql,Object...  obj){
	    	 Connection   connection=null;
	    	 PreparedStatement      pstat=null;
	    	 ResultSet   rs=null;
	    	 List<Me>     list=new    ArrayList<Me>();//׼����һ�����ϣ������洢Food����
	    	 try {
	    		connection=getConnection();
				pstat=connection.prepareStatement(sql);
				for (int i = 0; i < obj.length; i++) {
		    		 	pstat.setObject(i+1,obj[i]);
				 }
	     	     rs=pstat.executeQuery();
	     	     while(rs.next()){ //��û����һ������
	     	    	     Integer    id=(Integer) rs.getObject(1); //��ȡ��һ�е�һ�е�����
	     	    	     String     content=(String) rs.getObject(2);//��ȡ�ڶ��е�һ�е�����
	     	    	     String     name=(String)rs.getObject(3);
	     	    	     String     notice=(String)rs.getObject(4);
	     	    	     Me   me=new Me();
	     	    	     me.setId(id);
	     	    	     me.setName(name);
	     	    	     me.setContent(content);
	     	    	     me.setNotice(notice);
	     	    	     
	     	    	     //list����û����������
	     	    	     list.add(me);
	     	     }
			} catch (SQLException e) {
				   e.printStackTrace();
			} finally{
				  close(rs,pstat,connection);
			}
	    	 //�������List�����ǲ��Ǿʹ洢�����е�Food����Ҳ����˵�洢�����е����ݡ�
    	    return list;
    }
         /**
          * 
          * @param rs
          * @param pStatement
          * @param connection
          */
         public   void  close(ResultSet rs,PreparedStatement pStatement,Connection connection){
        	         if(rs!=null){
        	        	    try {
								rs.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
        	         }
        	         if(pStatement!=null){
	     	        	    try {
	     	        	    	pStatement.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	     	         }
        	         if(connection!=null){
	     	        	    try {
	     	        	    	connection.close();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	     	         }
         }
         
         
}
