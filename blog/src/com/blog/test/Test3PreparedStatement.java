package com.blog.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.blog.bean.Article;

public class Test3PreparedStatement {
	 private    static    String     URL="jdbc:mysql://localhost:3306/blog?useUnicode=true&characterEncoding=utf-8";
     private    static    String     DRIVER="com.mysql.jdbc.Driver";
     private    static    String     USER="root";
     private    static    String     PASSWORD="123456";
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	    Class.forName(DRIVER);
    	    Connection                 connection=DriverManager.getConnection(URL, USER, PASSWORD);
    	    
    	    int            num=1;
    	    String        sql="select  *    from   article  where   id=?";
    	    PreparedStatement   pStatement=connection.prepareStatement(sql);//创建数据库操作类
    	    
    	    
    	    //就是给问号赋值
    	    pStatement.setObject(1, num);//1：第一个问号    args[0]就是id
    	    
    	    ResultSet    rs=pStatement.executeQuery();//返回结果集，结果集里面就有每行的数据
    	    
    	    List<Article>              lists=new   ArrayList<Article>();//定义一个集合存储文章
    	    //遍历结果集
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
    	    System.out.println(lists.size());
    	    //最后把lists给需要的人使用
	}
}
