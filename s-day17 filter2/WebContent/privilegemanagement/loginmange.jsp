<%@page import="java.nio.channels.SeekableByteChannel"%>
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
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if(username != null && !username.trim().equals("")){
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			request.getRequestDispatcher("/list.jsp");
		}else{
			response.sendRedirect("login.jsp");
		}
	%>

</body>
</html>