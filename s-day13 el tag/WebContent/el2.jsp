<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="com.kc.ww.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 7. EL 的关系运算符 -->

	${param.score > 60 ? "及格" : "不及格" }
	<br>
	
	<%
		List<String> names = new ArrayList<String>();
		names.add("asd");
		request.setAttribute("names", names);
	%>
	<!-- empty 可以作用于一个集合，若该集合不存在或集合中没有元素，其结果都为 true  -->
	names is empty: ${ empty requestScope.names }
	
	<br><br>
	

	<!-- 6. 其他隐含对象  pageContext 等 ( cookie,header,initParam 只需要了解 )-->
	
	pageContext：pageContext 即为 PageContext 类型，但只能读取 
	<br>
	contextPath: ${pageContext.request.contextPath }
	
	<br>
	sessionId: ${pageContext.session.id }
	
	<br>
	sessionAtttributeName: ${pageContext.session.attributeNames }
	
	<br>
	-------------------------------<br>
	servletContext: ${pageContext.servletContext.initParameterNames }<br>
	servletContext----:<%=application.getInitParameter("initName") %><br>
	---------------------------------------
	<br>
	
	
	
	initParam: ${initParam.initName }
	
	<br>
	Accept-Language: ${header["Accept-Language"] } --> Accept-Language: ${headerValues["Accept-Language"] }
	
	<br>
	JSESSIONID: ${cookie.JSESSIONID } -->  ${cookie.JSESSIONID.name } : ${cookie.JSESSIONID.value}
	<br>

	<!-- 5.与输入有关的隐含对象：param paramValue  -->
	score: ${param.score }
	<br>
	names: ${paramValues.name }
	<br>
	name[0]: ${paramValues.name[0] }
	<br>
	<%= request.getParameterValues("name")[0].getClass().getName()  %>
	<%--
		name.class: ${paramValues.name[0].class }  
		相当于
		<%= request.getParameterValues("name")[0].getClass().getName()  %>
		
	 --%>


	<br>
	<!-- 4. 隐含对象之与范围相关的：pageScope requestScope sessionScope applicationScope  -->
	time: ${time}
	<br>
	time: ${time.time}
	<%
		Date time = (Date)application.getAttribute("time");
		out.print("time.time:"+time.getTime());
	%>
	<br>
	<%-- 
		time: ${applicationScope.time}
		相当于
		<%= application.getAttribute("time")%>
	--%>
		
	<br>
	<!-- 3. EL 可以进行自动的类型转换 -->
	score: ${param.score + 11}
	<br>
	score: <%=request.getParameter("score") + 11%>
	<br>

	<!-- 2. El 中的隐藏对象 -->
	<%
		Customer cust2 = new Customer();
		cust2.setAge(20);
		request.setAttribute("customer", cust2);
	
	%>
	
	age: ${customer.age}  <!-- 没有指定 EL 范围      page request session application -->
	
	
	<%--	错误
		age:<jsp:getProperty property="age" name="customer"/>
	--%>
	
	
	
	
	age:
	<%
		Customer customer = (Customer)session.getAttribute("customer");
		System.out.println(customer);
		out.print(customer.getAge());
	%>
	
	<br>
	
	<!-- 1. EL 的  . 或  [] 运算符  -->
	
	age: ${sessionScope.customer.age} <!-- 指定了范围 -->
	<br>
	age: ${sessionScope.customer["age"]}
	
	<%
		Customer cust = new Customer();
		cust.setName("wen");
		session.setAttribute("com.customer.name", cust);
	%>
	<br>
	name: ${sessionScope["com.customer.name"].name} 
	
	
	
	
	
	
	
	

</body>
</html>