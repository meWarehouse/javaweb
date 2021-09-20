
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.logging.SimpleFormatter"%>
<%@page import="java.util.Date"%>

<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page session="false"  %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		jsp 指令 page include  taglib
		
			page指令用于定义JSP页面的各种属性，无论page在何处都可作用于整个JSP页面
				page常用指令：
					<%@page 
					
						1.import="需要导入的类"
						
						2.session="false|true(默认)" false 不允许使用session 
							指定当前页面的session隐藏变量是否可用，或当前页面是否一定要生成HttpSession对象
							
						3.errorPage 和 isErrorPage:
							errorPage 指定当前页面出现错误的实际响应页面是什么。其中 / 表示当前WEB 应用的根目录
								<%@page errorPage="/error.jsp" %>
							在响应error.jsp时，JSP引擎使用的是请求转发的方式
							isEErrorPage指定当前页面是否为错误处理页面，可以说明当前页面是否可以使用exception隐藏变量，需要注意的是给isErrorPage="true".
								并使用了exception的方法，一般不建议能够直接访问该页面
							？？？如何使客户不能直接访问某个页面
								对于Tomcat服务器而言，WEB-INF下的文件是不能通过浏览器中直接输入地址来访问的，但可以通过请求的转发	
								
							还可以在web.xml文件中配置错误页面
									
						4.contentType：指定当前Jsp页面响应的类型 实际上是调用 response.setContentType("text/html; charset=UTF-8");
						
						5.pageEncoding:指定当前JSP页面的字符编码，通常情况下和contentType中的charset一致
						
						6.isELIgnored:指定当前页面是否可以使用EL表达式 通常为false				
							
							
							
	--%>

	<%
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat();
	%>
	
	<%=d %>
	
	<%
		//int i = 10 / 0;
	%>
	
	
	<form action="hello.jsp" method="get">
		username:<input type="text" name="username" />
		<input type="submit" value="Submit" />
		
	</form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


</body>
</html>