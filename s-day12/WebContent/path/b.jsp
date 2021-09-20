<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4> BBB Page </h4>
	
	cities : <%=request.getAttribute("cities") %>
	<br>
	<a href="<%=request.getContextPath() %>/path/c.jsp"> To C Page </a>

</body>
</html>