<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="SanTest" class="com.test.SanTest" scope="request"/>
	<jsp:setProperty property="*" name="SanTest"/>
	面积:<jsp:getProperty property="area" name="SanTest"/><br/>
	周长:<jsp:getProperty property="perimeter" name="SanTest"/><br/>

</body>
</html>