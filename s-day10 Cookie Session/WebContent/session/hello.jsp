<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	SessionId : <%=session.getId() %>
	<br><br>
	
	IsNew : <%= session.isNew() %>
	<br><br>
	
	MaxInactiveInterval : <%= session.getMaxInactiveInterval() %>
	<br><br>
	
	CreateTime : <%= session.getCreationTime() %>
	<br><br>
	
	LastAccessTime : <%= session.getLastAccessedTime() %>
	<br><br>
	
	hello : <%= request.getParameter("username") %>
	
	<br><br>
	
	<%
		session.setAttribute("username", request.getParameter("username"));
		
	%>
	
	<a href="<%= response.encodeRedirectURL("login.jsp") %>"> 重新登录 </a>
	
	&nbsp;&nbsp;&nbsp;&nbsp;
	
	<a href="<%= response.encodeRedirectURL("loginout.jsp") %>"> 注销 </a>

</body>
</html>