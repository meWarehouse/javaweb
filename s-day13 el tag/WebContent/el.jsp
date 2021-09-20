<%@page import="java.util.Date"%>
<%@page import="com.kc.ww.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="el.jsp" method="post">
		username:<input type="text" name="username" 
		value="<%= request.getParameter("username") == null ? "" : request.getParameter("username") %>" />
		
		<!-- EL  -->
		username:<input type="text" name="username" 
		value="${param.username}" />
		
		<input type="submit" value="Submit" />
	
	</form>
	
	username:<%= request.getParameter("username") %>
	
	<br><br>
	<hr>
	
	<jsp:useBean id="customer" class="com.kc.ww.Customer" scope="session"></jsp:useBean>
	<jsp:setProperty property="age" value="12" name="customer"/>
	
	age:<jsp:getProperty property="age" name="customer"/>
	<br>
	age:
	<%
		Customer cust1 = (Customer)session.getAttribute("customer");
		out.print(cust1.getAge());
	
	%>
	
	<%
		application.setAttribute("time", new Date());
	%>
	
	<br>
	
	
	
	<br>
	
	<a href="el2.jsp?score=98&name=A&name=B&name=C"> To EL2 </a>
	
	
</body>
</html>