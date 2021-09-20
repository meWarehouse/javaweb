<%@page import="com.kc.mvc.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--=request.getAttribute("students") --%>
	
	<%
		List<Student> allStudentList =  (List<Student>)request.getAttribute("allStudents");
	%>
	<table>
		<tr>
			<th>id</th>
			<th>idCard</th>
			<th>name</th>
			<th>sex</th>
			<th>height</th>
			<th>colation</th>
			<th>classes</th>
		</tr>
	<%
		for(Student student : allStudentList){
	%>
		
		
			<tr>
				<td><%=student.getId() %></td>
				<td><%=student.getIdCard() %></td>
				<td><%=student.getName() %></td>
				<td><%=student.getSex() %></td>
				<td><%=student.getHeight() %></td>
				<td><%=student.getColation() %></td>
				<td><%=student.getClasses() %></td>
			</tr>
		
		
	
	<%
		}
	%>
	</table>
	

</body>
</html>