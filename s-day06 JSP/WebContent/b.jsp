<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>BBBB PAGE</h4>
	
	<%
	
		//请求转发与重定向
		
		//请求转发代码
		//request.getRequestDispatcher("/c.jsp").forward(request, response); //发送一个请求同一个request 
	
		
		//请求重定向
		//response.sendRedirect("c.jsp"); //发送两次请求 不同的 request
		
		response.sendRedirect("http://www.baidu.com");
	
	
	%>

</body>
</html>