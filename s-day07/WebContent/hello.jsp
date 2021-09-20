<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>hello jsp </h2>
	
	学习java
	
	<%--
	
		关于中文乱码
			在jsp页面中 请求页面或不出现乱码：
				1.
					保证：contentType="text/html; charset=UTF-8"
						pageEncoding="UTF-8"
						charset 和 pageEncoding 的编码一致，且都支持中问
						还需保证浏览器的显示的字符编码也和请求的JSP页面的编码一致
				2.获取中文参数值：默认在传输过程中使用的编码为 ISO-8859-1
					对于post请求：只需在请求之前调用 request.setCharacterEncoding("UTF-8") 即可解决
				
	
	 --%>
	
	<br><br>
	
	<%
		request.setCharacterEncoding("UTF-8");//获取请求参数之前
	%>
	
	username: <%=request.getParameter("username") %>
	
	
	<br><br>
	
	<%
	
		String str = request.getParameter("username");
		String username = new String(str.getBytes("iso-8859-1"),"utf-8");
		out.print(username);
	
	%>
	

</body>
</html>