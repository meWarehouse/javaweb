<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<jsp:useBean id="rectangle" class="com.test.Rectangle" scope="request"/>
		<jsp:setProperty property="*" name="rectangle"/>
	面积:<jsp:getProperty property="area" name="rectangle"/><br/>
	周长:<jsp:getProperty property="perimeter" name="rectangle"/><br/>
</body>
</html>