<%@page import="com.test.domain.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>

	<c:if test="${requestScope.msg }">
		<font color="red">${requestScope.msg }</font>
	</c:if>

	<form action="userServlet?method=search" method="post">
		<table cellpadding="10">
			<tr>
				<td>username:</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>idCard:</td>
				<td><input type="text"  name="idcard" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="点击查询用户" /></td>
				<td><a href="addNewUser.jsp">Add New User</a></td>
			</tr>
		
		</table>
	</form>
	
	<br><br>
	
	<c:if test="${!empty requestScope.pageuser }">
		<table cellpadding="10">
			<tr>
				<td>姓名及IdCard</td>
				<td>年龄</td>
				<td>地址</td>
				<td>UPDATE/DELETE</td>
			</tr>
			<c:forEach items="${requestScope.pageuser.list }" var="user">
				<tr>
					<td>
						<a href="">
							${user.name }<br>
							${user.idCard }
						</a>
					</td>
					<td>${user.age }</td>
					<td>${user.address }</td>
					<td>
						<a href="">UPDATE</a>/
						<a href="">DELETE</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		
		共${pageuser.totalPageNumber }页
		&nbsp;
		
		当前第${pageuser.pageNo }页
		&nbsp;
		
		
		
		<c:if test="${pageuser.hasPrev }">
			<a href="userServlet?method=search&pageNo=1">首页</a>
			&nbsp;
			<a href="userServlet?method=search&pageNo=${pageuser.prevPage }">上一页</a>
		</c:if>
		
		&nbsp;
		
		
		
		<c:if test="${pageuser.hasNext }">
			<a href="userServlet?method=search&pageNo=${pageuser.nextPage }">下一页</a>
			&nbsp;
			<a href="userServlet?method=search&pageNo=${pageuser.totalPageNumber }">末页</a>
		</c:if>
		
	</c:if>
	

</body>
</html>