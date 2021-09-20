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
	
	
		jsp:include：动态引入
			1.<jsp:include page="b.jsp"></jsp:include>
			2.动态引入：并不像include指令生成一个Servlet文件，而是生成两个servlet文件，然后通过一个方法的方式将目标页面包含进来
				方法：org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "b.jsp", out, false);
				
				
		include 指令与 jsp:include 标签
			1.
			
		
	
	 -->

	<h3> AAA PAGE </h3>

	<%  String str ="asdf ";  %>

	<!-- 在 a.jsp 中包含 b.jsp  -->
	<%--
	<jsp:include page="b.jsp">
		<jsp:param value="1234asdf" name="username"/>
	</jsp:include>
	
	 --%>

	
	<%-- 
		
		jsp:forword
			1.
				<jsp:forward page="/include/b.jsp"><jsp:param value="1234asdf" name="username"/></jsp:forward>相当于
				<%
					request.getRequestDispatcher("/include/b.jsp").forward(request, response);
				%>
			2.但使用jsp:forword可以使用jsp:param子标签向 b.jsp 传入一些参数，同一js:include 也可以使用jsp:param子标签
			
	
	
	--%>
	<jsp:forward page="/include/b.jsp">
		<jsp:param value="1234asdf" name="username"/>
	</jsp:forward>
	
	<%--
		request.getRequestDispatcher("/include/b.jsp").forward(request, response);
		
	
	--%>
	
	
	
	
	
</body>
</html>