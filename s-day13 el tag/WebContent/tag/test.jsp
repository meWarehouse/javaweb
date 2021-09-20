<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 导入标签库 -->
<%@taglib uri="http://www.atguigu.com/jsp/jstl/core" prefix="atguigu"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<atguigu:readFile src="/WEB-INF/note.txt"/>
	
	<%-- 
	<atguigu:max num2="19" num1="23"/>
	
	
	<atguigu:max num2="${param.a }" num1="${param.b }"/>
	
	
	<br>
	<atguigu:hello value="${param.name }" count="10"/>
	--%>
	
	
</body>
</html>