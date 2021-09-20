<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 
	<h4> test.jsp </h4>
	<%
		System.out.println("5..............");
	%>
	--%>
	
	<%--
	
		request.setCharacterEncoding("utf-8");
	--%>
	
	<form action="test.jsp" method="post">
		user:<input type="text" name="username" />
		<input type="submit" value="submit" />
	</form>
	
	<c:if test="${param.username != null }">
		用户：<font color="red"> ${param.username } </font>
	</c:if>
	
	
</body>
</html>