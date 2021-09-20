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

	
	<%
		Object username = session.getAttribute("username");
		if(username == null){
			username = "";
		}
	
	%>
		
	<form action="<%= response.encodeRedirectURL("hello.jsp") %>" method="post">
		username：<input type="text" name="username" value="<%=username %>" />
		<input type="submit" value="Submit" />
	
	</form>
	
</body>
</html>