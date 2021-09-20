<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 向客户端浏览器写一个 Cookie： cookiePath cookiePathValue -->
	
	<%
	
		Cookie cookie = new Cookie("cookiePath","cookiePathValue");
	
		//设置Cookie的作用范围    其中 / 表示站点的根目录
		cookie.setPath(request.getContextPath());
		
		
		response.addCookie(cookie);
		
		// Cookie 的作用范围：可以作用于当前目录和当前目录的子目录，但不能作用于当前目录的上一级目录
		
		
	
	%>
	
	<%--  <a href="cookiepath/cookie2.jsp"> To Read Cookie </a>--%>
	 
	<a href="../cookie2.jsp"> To Read Cookie </a>
	
	<br><br>
	
	<%=request.getContextPath() %>


</body>
</html>