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

	<%-- 
	<c:if test="${sessionScope.user != null }">
		<c:redirect url="/login.jsp"></c:redirect>
	</c:if>
	--%>
	
	<%
		Object obj = session.getAttribute("user");
		if(obj == null){
			response.sendRedirect(request.getContextPath()+"/loginTest/login.jsp");
		}
	%>
	
	<h4> BBB Page </h4>

	<a href="list.jsp">Return...</a>
	
</body>
</html>