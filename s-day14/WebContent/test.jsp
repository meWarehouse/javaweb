<%@page import="java.util.List"%>
<%@page import="com.kc.tag.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="atmytag" uri="http://www.atmytag.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<atmytag:testJspFragment>Hello World</atmytag:testJspFragment>
	
	<atmytag:printUpper time="10"> java </atmytag:printUpper>
	
	
	<br><br>
	
	<%
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,"AAAA"));
		customers.add(new Customer(2,"EEEE"));
		customers.add(new Customer(3,"DDDD"));
		customers.add(new Customer(4,"CCCC"));
		customers.add(new Customer(5,"BBBB"));
		
		request.setAttribute("customers", customers);
	
	%>
	
	<atmytag:forEach  item="${requestScope.customers }" var="cust">
		${pageScope.cust.id } ---- ${cust.name }<br>
	</atmytag:forEach>
	

</body>
</html>