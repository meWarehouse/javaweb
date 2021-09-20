<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table>
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