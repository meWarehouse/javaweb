<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>权限管理页面</h4>

	<%--
		authority-manager.jsp
				* 有一个 text 文本框，供输入 username，提交后可以 使用 checkbox 显示用户所有权限信息
				* 检查 request 中是否有 user 信息，若有，则显示
					xxx的权限为：对应的权限的 checkbook 打上 √ 。提示，页面上需要通过两层循环的方式来筛选出被选择的权限
	
	 --%>
	 
	 <form action="authorityServlet?method=getAuthority" method="post">
	 
	 	Name:<input type="text" name="username" />
	 	<input type="submit" value="submit" />
	 </form>
	 
	 <!-- 
	 	检查 request 中是否有 user 信息，若有，则显示 xxx的权限为：对应的权限的 checkbook 打上 √ 。提示，页面上需要通过两层循环的方式来筛选出被选择的权限
	  -->
	  <c:if test="${request.user != null }">
	  	<br>
	  	${ request.user.name} 的权限为：
	  	<br>
	  	
	  	<form action="authorityServlet?method=updateAuthority" method="post">
	  		
	  	
	  	</form>
	  
	  </c:if>


</body>
</html>