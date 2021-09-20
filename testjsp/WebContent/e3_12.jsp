<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		Object number=application.getAttribute("count");
		int num=0;
		if(number==null){
		   application.setAttribute("count",1);
		}else{
		  num=(Integer)number;
		  num++;
		  application.setAttribute("count", num);
		  
		}
		out.print("当前访问本页面的次数为："+num);
	%>
	<br>
	
	
	支持Servlet API 主版本号：<%=application.getMajorVersion() %><br>
	支持Servlet API次版本号：<%=application.getMajorVersion() %><br>
	Web应用的实际路径：<%=application.getRealPath("/") %><br>
	Web服务器的版本信息：<%=application.getServerInfo() %><br>

</body>
</html>