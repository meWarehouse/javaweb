package com.blog.test;
/**
 * 这个类是讲述测试多参数
 * @author Administrator
 *
 */
public class Test2Args {
	    public static  void   show(){
	    	    int[]   it=new int[6];
	    	    System.out.println("it="+it);//[I@15db9742
	    	    String[]   strings=new  String[4];//[Ljava.lang.String;@6d06d69c
	    	    System.out.println("strings="+strings);
	    }
        public static void main(String[] args) {
//        	   show();
//			   test1(10,9);
//        	   test2("a","文豪","zhw");
        	   
        	   test3(30);
			   
		}
        public   static  void      test3(Object...   objects){//接收任何参数
        	   System.out.println(objects);
        	   for (int i = 0; i < objects.length; i++) {
				    System.out.println(objects[i]);
			}
        }
        public   static  void      test2(String...  str){//可以接收0个到多个字符串
        	  System.out.println(str);
        	  for (int i = 0; i < str.length; i++) {
				    System.out.println(str[i]);
			}
        }
        public   static   void     test1(int...   a){//它可以接收一个或者多个参数     a就相当于int型可变的数组
        	   System.out.println(a);
        	   for (int i = 0; i < a.length; i++) {
				     System.out.println(a[i]);
			   }
        }
}
