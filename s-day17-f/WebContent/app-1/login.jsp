<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		//  http://localhost:8080/s-day17-f/LoginServlet
		// http://localhost:8080/s-day17-f/app-1/LoginServlet 
		
		System.out.println(request.getContextPath());
	%>

	path:${pageContext.request.contextPath}/LoginServlet  

	<form action="${pageContext.request.contextPath }/LoginServlet" method="post">
	
		用户名：<input type="text" name="username" />
		密码：<input type="password" name="password" />
		<input type="submit" value="提交" />
		
	</form>

</body>
</html>