<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4> Step1: 选择购买的书籍 </h4>

	<form action="<%= request.getContextPath() %>/processStep1" method="post">
	
		<table border="1" cellpadding="10" cellspacing="0" >
			<tr>
				<td>书名</td>
				<td>购买</td>
			</tr>
			<tr>
				<td>java</td>
				<td><input type="checkbox" name="book" value="java" /></td>
			</tr>
			<tr>
				<td>oracle</td>
				<td><input type="checkbox" name="book" value="oracle" /></td>
			</tr>
			<tr>
				<td>struts</td>
				<td><input type="checkbox" name="book" value="struts" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form>
	

</body>
</html>