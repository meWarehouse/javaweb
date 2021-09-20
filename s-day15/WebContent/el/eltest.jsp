<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4> ELtest page </h4>
<!-- 
	<br>
	pageContext:${pag }
	
	<br>
	request:${requestScope.req }
	<br>
	session: ${sessionScope.sess }
	<br>
	application: ${application.appl }
 -->
	<br>
	${app }
	<br>
	${sessionScope.sess }
	<br>
	---${requestScope.req }
	<br>
	++
	<%=
		request.getAttribute("req")
	%>
	<br>
	
	${pageContext.session.id }
	<br>
	
	names:${paramValues.name }
	<br>
	age:${param.age }
	<br>
	<br>


</body>
</html>