<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@page import="com.review.el.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="customer" class="com.review.el.Customer" scope="request"></jsp:useBean>

	<%
	
		Customer cust = (Customer)request.getAttribute("customer");
		if(cust == null){
			cust = (Customer)Class.forName("com.review.el.Customer").newInstance();
			request.setAttribute("customer", cust);
		}
	
	%>

	<jsp:setProperty property="*"  name="customer"/>
	
	id:<jsp:getProperty property="id" name="customer"/>
	<br>
	name:<jsp:setProperty property="name" name="customer"/>
	
	<jsp:useBean id="customer2" beanName="com.review.el.Customer"  type="java.lang.Object" scope="session" ></jsp:useBean>
	
	<%--
		Object obj =  session.getAttribute("customer2");
		if(obj == null){
			obj = Class.forName("com.review.el.Customer").newInstance();
			session.setAttribute("customer2", obj);
		}
		
	
	--%>



</body>
</html>