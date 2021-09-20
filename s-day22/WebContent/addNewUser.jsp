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

	
	<c:if test="${requestScope.msg != null }">
		<font color="red">${requestScope.msg }</font>
	</c:if>

	<form action="userServlet?method=addUser" method="post">
		<table cellpadding="10">
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" value="${param.username }"/></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" name="age" value="${param.age }"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="New User" /></td>
			</tr>
		
		</table>
	</form>

</body>
</html>