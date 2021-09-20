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

	<h2> Attr 2 page ： <%= new Date() %> </h2>

	<br /><br />
	pageContextAttr:<%= pageContext.getAttribute("pageContextAttr") %>
	
	<br /><br />
	requestAttr:<%= request.getAttribute("requestAttr") %>
	
	<br /><br />
	sessionAttr:<%= session.getAttribute("sessionAttr") %>
	
	<br /><br />
	applicationAttr:<%= application.getAttribute("applicationAttr") %>
	

</body>
</html>