package com.blog.test;

import com.blog.bean.Me;
import com.blog.dao.MeDAO;
import com.blog.factory.DAOFactory;
import com.sun.glass.events.GestureEvent;

public class Test1 {
         public static void main(String[] args) {
			          MeDAO    meDAO=DAOFactory.getMeDAO();
			          //������ǰ�me��jspҳ��
			          
			          
			          
			          User   user=getName();
		}
         public   static   User    getName(){
        	       return new  User();
         }
}
class   User{
	
}
