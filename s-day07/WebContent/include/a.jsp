<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
	
		include 指令用于JSP引擎在翻译当前JSP页面时将其他文件中的内容合并进当前JSP页面转换成的Servlet源文件中，
			这种在源文件级别进行引入的方式称为静态引入，当前JSP页面与静态引入的页面紧密结合为一个Servlet
			
			file 属性的设置值必须是使用相对路径
			
			如果以 / 开头，表示相对于当前WEB应用程序的根目录(注意不是站点根目录)，否则相对于当前文件
	
	
	 -->

	<h3> AAA PAGE </h3>

	<%  String str ="asdf ";  %>

	<!-- 在 a.jsp 中包含 b.jsp  -->
	<%@ include file="b.jsp" %>

</body>
</html>