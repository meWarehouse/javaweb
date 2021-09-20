<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String tokenValue = new Date().getTime()+"";
		session.setAttribute("token", tokenValue);
	%>
	
	<form action="<%=request.getContextPath() %>/tokenServlet" method="post">
		
		<!-- <input type="hidden" name="token" value="qwert" /> 不行：没有清除固定请求参数的方法  -->
		
		<%--
			request.setAttribute("token", "token");
			也不行  因为表单页面刷新后，request 已经被销毁，再提交表单是一个新的 request
		--%>
		
		<input type="hidden" name="token" value="<%=tokenValue %>" />
		
		<%
			
		%>
		
		
		name：<input type="text" name="name" />
		<input type="submit" value="Submit" />
	</form>

</body>
</html>