<%@page import="java.util.Date"%>
<%@page import="com.kc.listener.session.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>HttpSessionBindingListener</h4>

	<%--
		Customer customer = new Customer();
	
		//request.setAttribute("customer", customer);
		
		session.setAttribute("customer", customer);
		System.out.println("-----------------------------------------------");
	
		session.removeAttribute("customer");
		
	--%>
	
	
	<%
	
		Customer customer = (Customer)session.getAttribute("customer");
	
		if(customer == null){
			customer = new Customer();
			customer.setTime(""+new Date());
			session.setAttribute("customer", customer);
			System.out.println("创建一个"+customer+"对象");
		}else{
			System.out.println("输出一个"+customer+"对象");
		}
	
	%>

</body>
</html>