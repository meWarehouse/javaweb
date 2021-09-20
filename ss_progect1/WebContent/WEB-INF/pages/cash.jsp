<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%--  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
   <%@include file="/commons/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	您一共买 ${sessionScope.ShoppingCart.bookNumber } 了本书
	<br>
	您应付金额 ￥ ${sessionScope.ShoppingCart.totalMoney }
	
	<br>
	<c:if test="${requestScope.errors != null }">
		<font color="red">${requestScope.errors }</font>
	</c:if>
	<br>
	<form action="bookServlet?method=cash" method="post">
	
		<table cellpadding="10">
			<tr>
				<td>信用卡姓名：</td>
				<td><input type="text" name="username"  /></td>
			</tr>
			<tr>
				<td>信用卡账号：</td>
				<td><input type="text" name="accountid" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		
	</form>


</body>
</html>