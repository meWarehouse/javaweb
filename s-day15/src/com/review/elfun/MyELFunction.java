package com.review.elfun;

import javax.servlet.jsp.tagext.SimpleTagSupport;

public class MyELFunction{

	/*
	 *  EL 自定义函数
	 *  	在 EL 表达式中调用的某个 Java 类的静态方法，这个静态方法需要 web 应用程序进行匹配
	 * 
	 * 	开发步骤：
	 * 		1.编写一个 EL 自定义函数映射的 java 类public的静态方法
	 * 		2.在标签库中描述文件
	 * 		3.使用
	 */
	
	public static String concat(String str1,String str2) {
		return str1 + str2;
	}
	
}
