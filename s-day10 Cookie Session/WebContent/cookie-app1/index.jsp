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
	
		需求：
			实现自动登录
			
			1.若可以获取到请求参数 name 则打印 出欢迎信息，把登录信息存储到Cookie中 并设置Cookie 的最大时效 60s
			2.从Cookie 中读取用户信息，若存在则打印欢迎信息
			3.若即没有请求参数，也没有Cookie 则重定向到 login.jsp
	
	 --%>
	 
	 <%
	 	//1.若可以获取到请求参数 name 则打印 出欢迎信息，把登录信息存储到Cookie中 并设置Cookie 的最大时效 60s
	 	String name = request.getParameter("name");
	 	if(name != null && !name.trim().equals("")){
	 		
	 		Cookie cookie = new Cookie("name",name);
	 		cookie.setMaxAge(60);
	 		response.addCookie(cookie);
	 	}else{
	 		//2.从Cookie 中读取用户信息，若存在则打印欢迎信息
	 		Cookie[] cookies = request.getCookies();
	 		if(cookies != null && cookies.length > 0 ){
	 			for(Cookie cookie : cookies){
	 				String cookieName = cookie.getName();
	 				if("name".equals(cookieName)){
	 					String val = cookie.getValue();
	 					name = val;
	 				}
	 			}
	 		}
	 	}
	 	if(name != null && !name.trim().equals("")){
	 		out.print("Hello : " + name);
	 	}else{
	 		//3.若即没有请求参数，也没有Cookie 则重定向到 login.jsp
	 		response.sendRedirect("login.jsp");
	 	}
	 	
	 %>


</body>
</html>