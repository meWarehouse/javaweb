<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- enctype 表单数据的编码类型 默认为 application/x-www-form-urlencoded ，当进行文件上传是必须是 multipart/form-data  -->
	<form action="uploadServlet" method="post" enctype="multipart/form-data">
		user:<input type="text" name="username" />
		File1:<input type="file" name="file" /> <br>
		File2:<input type="file" name="file" /> <br>
		<input type="submit" value="submit" />
	</form>

</body>
</html>