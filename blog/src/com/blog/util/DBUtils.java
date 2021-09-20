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
 * 这个类是数据库的连接操作类
 * @author Administrator
 *
 */
public class DBUtils {
	     //mysql的连接方式，如果是oracle注意，就不是这么写了
//         private    static    String     URL="jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8";
         private    static    String     URL="jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
         private    static    String     DRIVER="com.mysql.jdbc.Driver";
         private    static    String     USER="root";
         private    static    String     PASSWORD="root";
         
         static{
        	      //1.加载驱动类
        	      try {
					Class.forName(DRIVER);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
         }
         
         //下面
         private     static   DBUtils   dbUtils=new  DBUtils();
         private     DBUtils(){  //保证外部类不能创建对象
        	    
         }
         public   static    DBUtils    getDBUtils(){
        	         return  dbUtils;
         }
         
         
         public    static     Connection    getConnection() throws SQLException{
                  //2.数据库连接        	     
        	      Connection   connection=DriverManager.getConnection(URL, USER, PASSWORD);
        	      return  connection;
         }
         
         
         /**
          * 查询文章
          * @param sql     接收的sql语句
          * @param args    接收的参数值
          * @return
          */
         //dbutils.find(sql, 3);   也就是说args存入了一个3
         //args=new Object[]{3}
         public        List<Article>     find(String sql,Object...  args){//args里面有3
        	       Connection                 connection=null;
        	       /**
        	        * 如果不知道PreparedStatement和String    sql="select  *    from   article  where   id=?";和id？的
        	        * 回去看jim老师mysql视频。
        	        */
        	       PreparedStatement          pStatement=null;//定义操作数据库类
        	       ResultSet                  rs=null; //定义查询的结果集
        	       List<Article>              lists=new   ArrayList<Article>();//定义一个集合存储文章
        	        try {
						    connection=getConnection(); //数据库连接
						    
						    //3.操作数据库
						    /*
						     * 为什么用PreparedStatement？
						     * 因为它可以处理预定义数据
						     */
						    //select * from  article order by count1 desc limit 3
						    pStatement=connection.prepareStatement(sql);//创建数据库操作类
						    
						    //这个能过滤掉没有参数的时候  args.length=1
						    for (int i = 0; i < args.length; i++) {//i=1
						    	  //给问号赋值
							      pStatement.setObject(i+1, args[i]);//1：第一个问号    args[0]就是id
							}
						   
						    //根据sql语句查询的结果集
						    rs=pStatement.executeQuery();//返回结果集，结果集里面就有每行的数据
						    
						    
						    while(rs.next()){ //判断结果集有没有值
		    	    	         //下面是查询每列对应每行的值
		    	    	         Integer     id=(Integer) rs.getObject("id");//获取id列对应的值
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
			   	   		        		 
			   	   		        
			   	   		        //创建Article对象，存储上面每行的值，表中的一行数据其实是对应Article的一个对象
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
				   	   		        
				   	   		         //把一个个image对象添加到集合里面
				   	   		         lists.add(article);
			    	    }
					} catch (SQLException e) {
						e.printStackTrace();
					} finally{
						close(rs, pStatement, connection);
					}
        	       return lists;
         }
         public        List<Critique>     findCritique(String sql,Object...  args){//args里面有3
	  	       Connection                 connection=null;
	  	       PreparedStatement          pStatement=null;//定义操作数据库类
	  	       ResultSet                  rs=null; //定义查询的结果集
	  	       List<Critique>              lists=new   ArrayList<Critique>();//定义一个集合存储文章
	  	        try {
					    connection=getConnection(); //数据库连接
					    pStatement=connection.prepareStatement(sql);//创建数据库操作类
					    
					    //这个能过滤掉没有参数的时候  args.length=1
					    for (int i = 0; i < args.length; i++) {//i=1
					    	  //给问号赋值
						      pStatement.setObject(i+1, args[i]);//1：第一个问号    args[0]就是id
						}
					   
					    //根据sql语句查询的结果集
					    rs=pStatement.executeQuery();//返回结果集，结果集里面就有每行的数据
					    
					    
					    while(rs.next()){ //判断结果集有没有值
					    	 Integer    id=(Integer) rs.getObject("id"); //获取第一列第一行的数据
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
		     	    	     
		     	    	     //list集合没有增加数据
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
          * 该方法可以添加，删除，修改任何类型的数据 ，也就是说可以对所有的表进行增加，删除，修改操作。
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
	    	 List<Album>     list=new    ArrayList<Album>();//准备好一个集合，用来存储Food对象
	    	 try {
	    		connection=getConnection();
				pstat=connection.prepareStatement(sql);
				for (int i = 0; i < objects.length; i++) {
		    		 	pstat.setObject(i+1,objects[i]);
				 }
	     	     rs=pstat.executeQuery();
	     	     while(rs.next()){ //有没有下一行数据
	     	    	     Integer    id=(Integer) rs.getObject("id"); //获取第一列第一行的数据
	     	    	     String     title=(String)rs.getObject("title");
	     	    	     String     content=(String)rs.getObject("content");
	     	    	     String     time=(String)rs.getObject("time");
	     	    	     String     image=(String)rs.getObject("image");
	     	    	     String     notice=(String)rs.getObject("notice");
	     	    	      
	     	    	     //**********************************
	     	    	     Album      album=new   Album();
	     	    	     album.setId(id);//为什么这么写呢，因为下面需要这个对象
	     	    	     album.setTime(time);
	     	    	     album.setTitle(title);
	     	    	     album.setContent(content);
	     	    	     album.setImage(image);
	     	    	     album.setNotice(notice);
	     	    	     
	     	    	     //list集合没有增加数据
	     	    	     list.add(album);
	     	     }
			} catch (SQLException e) {
				   e.printStackTrace();
			} finally{
				  close(rs,pstat,connection);
			}
	    	 //所以最后List里面是不是就存储了所有的Food对象，也就是说存储了所有的数据。
	    	 return list;
         }
         public     List<Photo>   executeQueryPhoto(String sql,Object...  obj){
	    	 Connection   connection=null;
	    	 PreparedStatement      pstat=null;
	    	 ResultSet   rs=null;
	    	 List<Photo>     list=new    ArrayList<Photo>();//准备好一个集合，用来存储Food对象
	    	 try {
	    		connection=getConnection();
				pstat=connection.prepareStatement(sql);
				for (int i = 0; i < obj.length; i++) {
		    		 	pstat.setObject(i+1,obj[i]);
				 }
	     	     rs=pstat.executeQuery();
	     	     while(rs.next()){ //有没有下一行数据
	     	    	     Integer    id=(Integer) rs.getObject("id"); //获取第一列第一行的数据
	     	    	     Integer    album_id=(Integer)rs.getObject("album_id");
	     	    	     String     content=(String)rs.getObject("content");
	     	    	     String     time=(String)rs.getObject("time");
	     	    	     String     image=(String)rs.getObject("image");
	     	    	     String     type=(String)rs.getObject("type");
	     	    	     String     notice=(String)rs.getObject("notice");
	     	    	     String     note=(String)rs.getObject("note");
	     	    	      
	     	    	     //**********************************
	     	    	     //因为我们Photo要设置这个对象
	     	    	     Album      album=new   Album();
	     	    	     album.setId(album_id);//为什么这么写呢，因为下面需要这个对象
	     	    	     
	     	    	     Photo      photo=new    Photo();
	     	    	     photo.setId(id);
	     	    	     photo.setContent(content);
     	    	    	 photo.setNotice(notice);
	     	    	     photo.setTime(time);
	     	    	     photo.setType(type);
	     	    	     photo.setNote(note);
	     	    	     photo.setImage(image);
	     	    	     photo.setAlbum(album);
	     	    	     //list集合没有增加数据
	     	    	     list.add(photo);
	     	     }
			} catch (SQLException e) {
				   e.printStackTrace();
			} finally{
				  close(rs,pstat,connection);
			}
	    	 //所以最后List里面是不是就存储了所有的Food对象，也就是说存储了所有的数据。
	    	 return list;
	    }
         public     List<Me>   executeQueryMe(String sql,Object...  obj){
	    	 Connection   connection=null;
	    	 PreparedStatement      pstat=null;
	    	 ResultSet   rs=null;
	    	 List<Me>     list=new    ArrayList<Me>();//准备好一个集合，用来存储Food对象
	    	 try {
	    		connection=getConnection();
				pstat=connection.prepareStatement(sql);
				for (int i = 0; i < obj.length; i++) {
		    		 	pstat.setObject(i+1,obj[i]);
				 }
	     	     rs=pstat.executeQuery();
	     	     while(rs.next()){ //有没有下一行数据
	     	    	     Integer    id=(Integer) rs.getObject(1); //获取第一列第一行的数据
	     	    	     String     content=(String) rs.getObject(2);//获取第二列第一行的数据
	     	    	     String     name=(String)rs.getObject(3);
	     	    	     String     notice=(String)rs.getObject(4);
	     	    	     Me   me=new Me();
	     	    	     me.setId(id);
	     	    	     me.setName(name);
	     	    	     me.setContent(content);
	     	    	     me.setNotice(notice);
	     	    	     
	     	    	     //list集合没有增加数据
	     	    	     list.add(me);
	     	     }
			} catch (SQLException e) {
				   e.printStackTrace();
			} finally{
				  close(rs,pstat,connection);
			}
	    	 //所以最后List里面是不是就存储了所有的Food对象，也就是说存储了所有的数据。
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
