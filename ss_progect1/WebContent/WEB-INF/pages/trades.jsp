<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    <%@include file="/commons/common.jsp" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>User:${user.username }</h4>
	<br>
	
	
		<c:forEach items="${user.trades }" var="trade">
			<table border="1" cellpadding="10" cellspacing="0">
		
				<tr colspan="3">
					<td colspan="3">TradeTime:${trade.tradeTime }</td>
				</tr>
				<c:forEach items="${trade.items }" var="item">
					
					<tr>
						<td>${item.book.title }</td>
						<td>${item.book.price }</td>
						<td>${item.quantity }</td>
					</tr>
					
				</c:forEach>
			
			</table>
			<br><br>
		</c:forEach>

	

</body>
</html>