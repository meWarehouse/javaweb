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

	<font color="red">
	<%= session.getAttribute("message") == null ? "" : session.getAttribute("message") %>
	</font>
	<br>

	<form action="<%=request.getContextPath() %>/checkCodeServlet" method="post">
		name:<input type="text" name="name" />
		
		checkCode:<input type="text" name="CHECK_CODE_PARAM_NAME" />
		<img alt="" src="<%=request.getContextPath() %>/validateColorServlet">
		
		<input type="submit" value="Submit" />
	</form>

</body>
</html>