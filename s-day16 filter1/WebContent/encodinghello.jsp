<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		编写一个 EncodingFilter
			1.读取 web.xml 文件中配置的当前 WEB 应用的初始化参数 encoding
			2.指定请求的字符编码集，读取到编码
			3、调用 chain.doFilter() 方法“放行请求”
		request.setCharacterEncoding("utf-8");
	--%>
	

	hello:${param.user }

</body>
</html>