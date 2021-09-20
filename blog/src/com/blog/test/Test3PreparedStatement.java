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
    	    PreparedStatement   pStatement=connection.prepareStatement(sql);//�������ݿ������
    	    
    	    
    	    //���Ǹ��ʺŸ�ֵ
    	    pStatement.setObject(1, num);//1����һ���ʺ�    args[0]����id
    	    
    	    ResultSet    rs=pStatement.executeQuery();//���ؽ������������������ÿ�е�����
    	    
    	    List<Article>              lists=new   ArrayList<Article>();//����һ�����ϴ洢����
    	    //���������
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
    	    System.out.println(lists.size());
    	    //����lists����Ҫ����ʹ��
	}
}
