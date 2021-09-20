<%@page import="com.kc.ww.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="customer" class="com.kc.ww.Customer" scope="request"></jsp:useBean>
	
	<jsp:useBean id="customer2" beanName="com.kc.ww.Customer" type="java.lang.Object" scope="request"></jsp:useBean>
	
	<%
		Object cust2 = request.getAttribute("customer2");
		if(cust2 == null){
			cust2 = Class.forName("com.kc.ww.Customer").newInstance();
			request.setAttribute("customer2", cust2);
		}
	
	%>
	

	<%-- <jsp:setProperty property="age" value="10" name="customer"/>  若 property 的值为 * 省略 value 属性值，则自动为所有属性赋值为对应的请求参数的值   --%>
	<jsp:setProperty property="*" name="customer"/>
	
	name:<jsp:getProperty property="name" name="customer"/>
	<br>
	
	id:<jsp:getProperty property="id" name="customer"/>
	<br>
	
	age:<jsp:getProperty property="age" name="customer"/>
	<br>
	
	
	<%--
		customer.setAge(10);
		out.print(customer.getAge());
	--%>
	
	
	<%
		//以上代码相当于以下java代码
		
		// 1. 从scope(session) 中获取 id(customer) 属性值，赋给 class(com.kc.ww.Customer) 类型的 id(customer ) 变量
		Customer cust = (Customer)session.getAttribute("customer");
		
		
		//2. 若属性值 为null ，则利用反射创建一个新的对象，把该对象赋给 id(customer) 并以 id(customer) 为属性名 部署到 scop(session)中
		if(cust == null){
			cust = (Customer)Class.forName("com.kc.ww.Customer").newInstance();
			session.setAttribute("customer", cust);
		}
		
	%>


</body>
</html>