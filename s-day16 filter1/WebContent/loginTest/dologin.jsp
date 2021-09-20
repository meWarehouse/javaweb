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
		String user = request.getParameter("username");
		System.out.println("----:"+user);
		if(user != null && user.trim().equals("")){
			session.setAttribute("user", user);
			//response.sendRedirect(request.getContextPath()+"/loginTest/list.jsp");
			response.sendRedirect(request.getContextPath()+"/loginTest/list.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/loginTest/login.jsp");
		}
	%>

</body>
</html>