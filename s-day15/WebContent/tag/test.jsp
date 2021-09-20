<%@page import="com.review.el.Customer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.atmytag.com/jsp/jstl/core" prefix="atmytag" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<atmytag:hello value="hello java" time="10"/>
	
	<atmytag:maxtag num1="${param.a }" num2 = "${param.b }"/>
	
	<atmytag:filereader src="/WEB-INF/note.txt"/>
	
	
	<br>
	<hr>
	
	<atmytag:testjspFragment time="19"> hroll </atmytag:testjspFragment>
	
	<br>
	
	<%
	 	List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(11,"SS",99));
		customers.add(new Customer(11,"SS",99));
		customers.add(new Customer(11,"SS",99));
		customers.add(new Customer(11,"SS",99));
		customers.add(new Customer(11,"SS",99));
		
		request.setAttribute("customers", customers);
		
	%>
	
	<c:forEach items="${requestScope.customers }" var="cust">
		${cust.id },${cust.name },${cust.age } <br>
	</c:forEach>
	
	<hr>
	
	
	
	<atmytag:testforeach items="${requestScope.customers }" var="c">
		${c.id },${c.name },${c.age }<br>
	</atmytag:testforeach>
	
	
	<atmytag:testforeach  items="${requestScope.customers }" var="cust">
		${pageScope.cust.id },${cust.name },${cust.age } <br>
	</atmytag:testforeach>
	
	<br>
	<br>
	<br>
	<br>
	
	
	<atmytag:parentTag>
		<!-- 子标签以父标签的标签体存在  用子标签将父标签的name打印在页面上 -->
		<atmytag:sonTag/> <!-- 父标签仅把子标签作为标签体使用 -->
	</atmytag:parentTag>
	
	<br>
	<br>
	
	<c:choose>
		<c:when test="${param.age > 24}">大学</c:when>
		<c:when test="${param.age > 20}">高中</c:when>
		<c:otherwise>高中以下..</c:otherwise>
	</c:choose>
	
	<!-- 
		1.开发 3 个标签：choose,when,otherwise
		2.其中 when 标签有一个 boolean 类型的属性：test
		3.choose 是 when 和 otherwise 的父标签，when 在 otherwise之前使用
		4.在父标签 choose 中定义一个“全局” 的 boolean 类型 的 flag ： 用于判断子标签在满足条件下的情况是否执行
			4.1：若 when 的 test 为 true，且 when 的父标签的 flag 也为 true，则执行 when 的标签，同时将 flag 设置为 false
			4.2：若 when 的 test 为 true，且 when 的父标签 为 false，则不执行标签体
			4.3：若 flag 为 true，otherwise 执行标签体 
		
	 -->
	
	<br>
	<br>
	
	<atmytag:chooseTag>
		<atmytag:whenTag test="${param.age > 24}">--大</atmytag:whenTag>
		<atmytag:whenTag test="${param.age > 20}">--中</atmytag:whenTag>
		<atmytag:otherwiseTag> --小 </atmytag:otherwiseTag>
	
	</atmytag:chooseTag>
	
	<br>
	<br>
	
	<!-- el 自定义函数 -->
	
	${fn:length(param.name) }
	<br>
	
	${atmytag:concat(param.str1,param.str2) }
	
	
	
	
	
	
	
	

</body>
</html>