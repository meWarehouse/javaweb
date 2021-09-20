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

	数量：${sessionScope.ShoppingCart.bookNumber }
	<br><br>
	
	<c:forEach items="${sessionScope.ShoppingCart.items }" var="item">
	
		${item.book.title } - ${item.book.price } - ${item.book.quantity }
		<br><br>
 	
	</c:forEach>
	

</body>
</html>