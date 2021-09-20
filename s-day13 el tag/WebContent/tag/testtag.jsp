<%@page import="com.kc.ww.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <!-- 导出使用的标签 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<c:forEach items="${requestScope.customers }" var="customer" >
		${customer.id },${customer.name },${customer.age }<br>
	</c:forEach>

	<%-- 
		<%
			List<Customer> customers = (List<Customer>)request.getAttribute("customers");
			
			if(customers != null && customers.size() > 0){
				for(Customer customer : customers){
		%>
					<%=customer.getId() %>,<%=customer.getName() %>,<%=customer.getAge() %>	
					<br>	
		<% 			
				}
			}
			
		
		%>
	--%>
	
	
	
	

</body>
</html>