<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("#per").click(function(){
			console.log("efrgdfbfdesfdv");
		});
		
		
	});

</script>

</head>
<body>


	<h2>商品列表</h2>

	<form action="${pageContext.servletContext.contextPath }/itemservlet" method="post">
		<c:if test="${requestScope.items != null }">
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<th>ID</th>
					<th>商品名称</th>
					<th>商品价格</th>
				</tr>
				<c:forEach items="${requestScope.items }" var="item">
					<tr>
						<th>${item.itemId }</th>
						<th>${item.itemName }</th>
						<th>${item.itemPrice }</th>
					</tr>
				</c:forEach>
			</table>
			<div>
				<input type="button" value="上一页" id="per" /> 
				<input type="button" value="下一页" />
			</div>
		</c:if>
	</form>






</body>
</html>