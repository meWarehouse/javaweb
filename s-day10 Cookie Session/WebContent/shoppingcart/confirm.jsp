<%@page import="com.kc.session.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4> 确认订单 </h4>
	
	<%
		Customer customer = (Customer)session.getAttribute("customer");
		String[] books = (String[])session.getAttribute("books");
	%>
	
	<table border="1" cellpadding="10" cellspacing="0" >
		<tr>
			<td>顾客姓名</td>
			<td><%= customer.getName() %></td>
		</tr>
		<tr>
			<td>地址</td>
			<td><%= customer.getAddress() %></td>
		</tr>
		<tr>
			<td colspan="2">付款信息</td>
		</tr>
		<tr>
			<td>卡号</td>
			<td><%= customer.getCard() %></td>
		</tr>
		<tr>
			<td>信用卡类型</td>
			<td><%= customer.getCardtype() %></td>
		</tr>
		<tr>
			<td>Books</td>
			<td>
				<%
					for(String book : books){
						out.print(book);
						out.print("<br>");
					}
				%>
			</td>
		</tr>
	
	</table>
	
	

</body>
</html>