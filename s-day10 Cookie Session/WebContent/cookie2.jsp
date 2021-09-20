<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 读取一个 name 为 cookiePath 的Cookie -->

	<%
		String cookieValue = null;
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie : cookies){
				if("cookiePath".equals(cookie.getName())){
					cookieValue = cookie.getValue();
				}
			}
		}
		if(cookieValue != null){
			out.print(cookieValue);
		}else{
			out.print("没有指定的 cookie");
		}
	
	%>


</body>
</html>