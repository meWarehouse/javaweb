<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    errorPage="e3_14.jsp
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		int[] array={1,2,3,4,5};
		//下面的代码将导致代码越界
		for(int i=0;i<6;i++)
		{
		     out.print("array["+i+"]="+array[i]);
		     out.newLine();
		}
	%>

</body>
</html>