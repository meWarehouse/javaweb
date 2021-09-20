<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		JSP语法：
			①.JSP模板元素：JSP页面中的静态HTML内容
			②.JSP表达式：
			③.JSP脚本片段
			⑤JSP注解
	 --%>
	 
	 
	 <%-- JSP表达式 : JSP表达式(exception)提供了将一个java变量或表达式的结果输出到客服端的简化方式  它将要输出的变量或表达式直接封装在 <%= 变量或表达式  %>中 --%>
	 <%
	 	Date date = new Date();
	 	out.print(date);
	 %>
	
	<%= date %>
	
	<%-- 脚本片段 JSP脚本片段(scriptet)是指嵌套在<% 和 %>之中的一条或多条java程序代码 多个脚本片段可以相互访问 --%>
	<%
	
		String ageStr = request.getParameter("age");
		Integer age = Integer.parseInt(ageStr);
		
		
		if(age >= 18){
			//out.print("成年");
	%>
		成年。。。
	<% 
		}else{
			//out.print("未成年");
	%>
		未成年...
	<%
		}
	%>
	
	<%-- JSP声明：JSP声明将java代码封装在 <%! 和   %>之中，它里面的代码将会被插入Servlet的_jspService方法的外面 --%>
	
	<%!
		void test(){};//在JSP页面中不用
	%>
	
	<%--  jsp注释可以阻止java代码的执行 html注释不可以
	<%
		System.out.println("打印信息....");
	
	%>
	--%>
	
	
	<%--
		Object	getAttribute(String name)	获取指定的属性
		Enumeration<String>	getAttributeNames()	获取所有属性的方法名组成的Enumeration对象
		void	removeAttribute(String name)	移除指定属性
		void	setAttribute(String 属性名, Object 属性值)	设置属性
	
		pageContext, request, session, application 对象都有这些属性
	
	 --%>
	
	
	
	

</body>
</html>