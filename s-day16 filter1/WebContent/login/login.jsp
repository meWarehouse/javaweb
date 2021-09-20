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

	<%
		request.setCharacterEncoding("utf-8");
	%>

	<c:if test="${requestScope.msg != null }">
		<font color="red">${msg }</font><br>
	</c:if>
	

	<form action="hello.jsp" method="post">
	
		user:<input type="text" name="username" value="${param.username }"/>
		password:<input type="password" name="password" value="${param.password }" />
		
		<input type="submit" name="login" />
	
	</form>

</body>
</html>