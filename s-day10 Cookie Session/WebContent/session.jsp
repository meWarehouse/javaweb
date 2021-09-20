<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--=request.getSession(false) --%>
	
	<%
	
		//HttpSession session = request.getSession(false);
		HttpSession session = request.getSession(true);
		out.print(session.getId());
		
		session.setMaxInactiveInterval(5);
		
		out.print("<br><br>");
		out.print(session.getMaxInactiveInterval());
		
		
		//使当前 HttpSession 对象失效
		//session.invalidate();
	
	%>

</body>
</html>