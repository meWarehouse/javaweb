<%@page import="java.util.Date"%>
<%@page import="com.review.el.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
	id:<jsp:getProperty property="id" name="customer"/>
	<br>
	 --%>
	 
	 
	customer:<%=session.getAttribute("customer") %>
	
	<%
		Customer customer = (Customer)session.getAttribute("customer");
		System.out.println(customer);
	 	out.print("id:"+customer.getId());
	 
	%>
	<br>
	
	id:${sessionScope.customer.id }
	<br>
	
	id:${sessionScope.customer["id"] }
	
	<br>
	time:${time }
	<br>
	time:${time.time }
	<br>
	<br>
	<%
		Date time = (Date)application.getAttribute("time");
		out.print("--:"+time.getClass());
		out.print("<br>");
		out.print(time.getTime());
	%>
	
	<br>
	
	age:${sessionScope.customer.age + 10 }
	<br>
	<%
		Customer cust = (Customer)session.getAttribute("customer");
		out.print(cust.getAge()+10);
	%>
	
	<br>
	score:<%=request.getParameter("score")+12 %>
	<br>
	score:${param.score +12}
	
	<br>
	names:${paramValues.name }
	--name[0]:${paramValues.name[0] }
	--name[1]:${paramValues.name[1] }
	
	<br>
	JSESSIONID:${cookie.JSESSIONID }
	JSESSIONID:${cookie.JSESSIONID.name } --> ${cookie.JSESSIONID.value }
	<br>
	Accept-Encoding: ${header["Accept-Encoding"] }
	
	<br>
	User-Agent: ${header["User-Agent"] }
	<br>
	sessionID : ${pageContext.session.id }
	
	<br>	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>