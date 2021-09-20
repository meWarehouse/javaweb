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

	<form action="index.jsp" method="post">
	
		username:<input type="text" name="name" 
		value="<%=request.getParameter("name") == null ? "" : request.getParameter("name") %>"	/>
		
		username:<input type="text" name="name" 
		value="${param.name }"	/>
		
		<input type="submit" value="Submit" />
	
	
	</form>
	
	<br>
	username:<%=request.getParameter("name") == null ? "" : request.getParameter("name") %>
	
	<br>
	
	<jsp:useBean id="customer" class="com.review.el.Customer" scope="session"></jsp:useBean>
	<jsp:setProperty property="id" value="11" name="customer"/>
	<jsp:setProperty property="age" value="23" name="customer"/>
	<br>
	
	
	id:<jsp:getProperty property="id" name="customer"/>
	<br>
	
	id:<%=request.getAttribute("id") %>
	<br>
	
	id:${requestScope.customer.id }
	
	<br>
	
	<% application.setAttribute("time", new Date()); %>
	
	<br>
	
	<a href="el2.jsp?score=23&name=aa&name=bb&name=cc"> To EL2 </a>
	

</body>
</html>