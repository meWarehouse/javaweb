<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isErrorPage="true"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		out.println("error.jsp发生了错误，具体原因如下：<br>");
		out.println("-------------------------<br>");
		out.println(exception.getMessage());
	%>

</body>
</html>