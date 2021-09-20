<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.review.el.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 表达式操作 -->
	
	<h4> c:out  可以对特殊字符转义 </h4>
	
	<%
		request.setAttribute("book", "<<java>>");
	%>
	
	book: ${requestScope.book }<!-- 书名尖括号无法解析  <> -->
	<br>
	book: <c:out value="${requestScope.book }"></c:out> <!-- <<java>> -->
	<br>
	
	<h4> c:set 可以为域对象属性赋值，其中 value 属性支持  EL 表达式；还可以为域对象中的 javabean 的属性赋值 target和value属性都支持  </h4>
	
	<c:set var="name" value="atmytag" scope="page"></c:set>
	<%--  相当于
		pageContext.setAttribute("name", "atmytag");
	--%>
	
	
	name:${pageScope.name }
	<br>
	
	<c:set var="sub" value="${param.sub }" scope="session"> </c:set>
	sub:${sessionScope.sub }
	
	<br>
	
	
	<%
		Customer cust = new Customer();
		cust.setId(1001);
		request.setAttribute("cust", cust);
	%>
	ID:${requestScope.cust.id }
	<br>
	<c:set target="${requestScope.cust }" property="id" value="${param.id }"></c:set>
	Id:${requestScope.cust.id }
	
	
	<br>
	
	<h4> c:remove 移除指定域对象的指定属性值    </h4>
	
	<c:set value="1998-01-10" var="date" scope="session" ></c:set>
	
	Date:${sessionScope.date }
	<br>
	<c:remove var="date" scope="session"/>
	Date:-----${sessionScope.date }
	
	
	<!-- 流程控制 -->
	
	<h4> c:if 没有 else ，但可以将判断的结果保存起来，以备之后使用  </h4>
	
	<c:set value="23" var="age" scope="request"></c:set>
	
	<c:if test="${requestScope.age > 18}">成年</c:if>
	<br>
	
	<c:if test="${param.age > 18 }" var="isAdult" scope="request"></c:if>
	isAdule:<c:out value="${requestScope.isAdult }"></c:out>
	
	<br>
	
	<h4> c:choose,c:when,c:otherwise 可以实现 if...else,if...else if ...else 的效果但比较麻烦  </h4>
	
	<c:choose>
		<c:when test="${param.a > 90 }"> AAA </c:when>
		<c:when test="${param.a > 80 }"> BBB </c:when>
		<c:when test="${param.a > 70 }"> CCC </c:when>
		<c:when test="${param.a > 60 }"> DDD </c:when>
		<c:otherwise> EEE </c:otherwise>
	
	</c:choose>
	
	<br>
	
	<!-- 迭代操作  -->
	
	<h4> c:forEach : 可以对   数组 ，Collection，Map  进行操作  </h4>
	
	<c:forEach begin="1" end="10" step="3" var="i">
		${i }---
	</c:forEach>
	<br>
	
	<%
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1,"DD",32));//index = 0
		customers.add(new Customer(2,"DD",32));
		customers.add(new Customer(3,"DD",32));
		customers.add(new Customer(4,"DD",32));
		customers.add(new Customer(5,"DD",32));
		customers.add(new Customer(6,"DD",32));
		
		request.setAttribute("customers", customers);
	%>
	
	<!-- 遍历 Collection  -->
	
	<c:forEach items="${requestScope.customers }" var="cust" varStatus="status">
		
		 ${status.index},${status.count},${status.first},${status.last} --${cust.id }---${cust.name }---${cust.age }<br>
		  
	</c:forEach>
	
	<br>
	
	<c:forEach items="${requestScope.customers }" var="cust" begin="1" step="2" end="6" >
		${cust.id }---${cust.name }---${cust.age }<br>  <!-- 2---DD---32, 4---DD---32, 6---DD---32 -->
	</c:forEach>
	<br>
	
	<%
		String[] names = new String[]{"AA","BB","CC"};
		request.setAttribute("names", names);
	%>
	<c:forEach items="${names }" var="s"> ${s }-- </c:forEach>
	
	<br>
	
	<c:forEach items="${pageContext.session.attributeNames }" var="attrName">
		----------${attrName }---------------
	</c:forEach>
	
	<br>
	<!-- 遍历 Map -->
	
	<%
		Map<String,Customer> custMap = new HashMap<String,Customer>();
		custMap.put("a", new Customer(1,"DD",32));
		custMap.put("b", new Customer(2,"DD",32));
		custMap.put("c", new Customer(3,"DD",32));
		custMap.put("d", new Customer(4,"DD",32));
		custMap.put("e", new Customer(5,"DD",32));
		custMap.put("f", new Customer(6,"DD",32));
		custMap.put("g", new Customer(7,"DD",32));
		
		
		request.setAttribute("custMap", custMap);
	%>
	
	<c:forEach items="${requestScope.custMap }" var="c" >
		${c.key } -- ${c.value.id } -- ${c.value.name } -- ${c.value.age } <br>
	</c:forEach>
	
	<br>
	
	<h4> c:forTokens : 处理字符串   类似于 String 的 split() 方法  </h4>
	
	<c:set value="a,s;d,f.g,h,j,k,L" var="str" scope="request"></c:set>
	<c:forTokens items="${requestScope.str }" delims="," var="s">
		${s }<br>
	</c:forTokens>
	
	<br>
	
	<!-- URL 操作 -->
	
	<h4> c:import 可以包含任何一个页面到当前页面 </h4>	

	<c:import url="http://www.baidu.com" ></c:import>
	
	<h4> 
		c:rediret
		
			<jsp:forward page="/test.jsp"></jsp:forward>
		
		 /代表当前 WEB 应用的根目录
		 
		 request.sendRedirect("/") /代表 WEB 站点的根目录
	
	 </h4>
	--%>
	<c:redirect url="../index.jsp"></c:redirect>
	<c:redirect url="http://www.baidu.com"></c:redirect>
	--%>
	<c:redirect url="" context=""></c:redirect>
	
	<br>
	
	<h4>
		c:url 产生一个 url 地址，可以根据 Cookie 是否   用来智能的进行 URL 重写
			还可以对 GET 的请求参数进行编码
			
			可以把产生的 URL 存储在域对象的属性中
			还可以使用 c:param 为 URL 添加参数, c:url 会对参数进行自动的转码
			value中的 / 代表当前 WEB 应用的根目录
			
	</h4>
	
	<c:url value="/index.jsp" var="testurl" scope="page">
		<c:param name="name" value="ASDFGH为"></c:param>
	</c:url>
	url:${testurl }
	
	<br>
	<br>
	<br>
	<br>
	<br>
	

	
	


	
	
	
	
	
	
	
	
	

</body>
</html>