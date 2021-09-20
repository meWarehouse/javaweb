<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 销毁session  -->
	
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
	
	byby : <%= request.getAttribute("username") %>
	<br><br>
	
	<a href="login.jsp"> 重新登录 </a>
	
	<%
		session.invalidate();
	
	%>
	

</body>
</html>