package com.blog.test;
/**
 * ������ǽ������Զ����
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
//        	   test2("a","�ĺ�","zhw");
        	   
        	   test3(30);
			   
		}
        public   static  void      test3(Object...   objects){//�����κβ���
        	   System.out.println(objects);
        	   for (int i = 0; i < objects.length; i++) {
				    System.out.println(objects[i]);
			}
        }
        public   static  void      test2(String...  str){//���Խ���0��������ַ���
        	  System.out.println(str);
        	  for (int i = 0; i < str.length; i++) {
				    System.out.println(str[i]);
			}
        }
        public   static   void     test1(int...   a){//�����Խ���һ�����߶������     a���൱��int�Ϳɱ������
        	   System.out.println(a);
        	   for (int i = 0; i < a.length; i++) {
				     System.out.println(a[i]);
			   }
        }
}
