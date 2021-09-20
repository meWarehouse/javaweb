<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	
		//在JavaWEB 规定中使用  Cookie 类代表  cookie
		
		// Cookie 的生命周期默认为浏览器会话期间，只要关闭浏览器，cookie就会消失  被成为会话Cookie
		//会话Cookie 一般不保存在硬盘上而是保存在内存中
		
	
		//获取cookie
		Cookie[] cookies = request.getCookies();
	
		if(cookies != null && cookies.length > 0){
			for(Cookie cookie1 : cookies){
				
				//获取cookie的name value
				out.print(cookie1.getName()+":"+cookie1.getValue());
				
				
				out.print("<br>");
			}
		}else{
			
			out.print("没有cookie，正在创建并返回");
			
			//1. 创建一个 Cookie 对象  （jsp属于服务端）
			Cookie cookie = new Cookie("name","nameValue");
			
			//setMaxAge() :设置Cookie的最大时效，以秒为单位，若为 0 ，表示立即删除该 Cookie 若为负数，表示不存储，Cookie 若为正数 表示存储多少秒
			cookie.setMaxAge(0);//60s
			
			//2. 调用 response 的 addCookie()方法 将Cookie 传给客户端
			response.addCookie(cookie);
			
		}
		
			
	
		
		
	%>


</body>
</html>