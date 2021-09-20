<%@page import="java.util.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="com.sun.javafx.scene.control.skin.PaginationSkin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%--
		Object	getAttribute(String name)	获取指定的属性
		Enumeration<String>	getAttributeNames()	获取所有属性的方法名组成的Enumeration对象
		void	removeAttribute(String name)	移除指定属性
		void	setAttribute(String 属性名, Object 属性值)	设置属性
	
		pageContext, request, session, application 对象都有这些属性(域对象)
	
	 --%>
	

	<%
		pageContext.setAttribute("pageContextAttr", "pageContextValue");	//PageContext pageContext - attr_1._jspService(HttpServletRequest, HttpServletResponse)
		request.setAttribute("requestAttr", "requestValue");				//HttpServletRequest request - attr_1._jspService(HttpServletRequest, HttpServletResponse)
		session.setAttribute("sessionAttr", "sessionValue");				//HttpSession session - attr_1._jspService(HttpServletRequest, HttpServletResponse)
		application.setAttribute("applicationAttr", "applicationValue");	//ServletContext application - attr_1._jspService(HttpServletRequest, HttpServletResponse)
		
	%>


	<h2> Attr 1 page : <%= new Date() %> </h2>

	<br /><br />
	pageContextAttr:<%= pageContext.getAttribute("pageContextAttr") %>
	
	<%--	pageContext 属性作用范围仅限于当前页面 --%>
	
	<br /><br />
	requestAttr:<%= request.getAttribute("requestAttr") %>
	
	<%--	request  属性作用范围仅限同一个请求（每次加载都是一次请求）  --%>
	
	<br /><br />
	sessionAttr:<%= session.getAttribute("sessionAttr") %>
	
	<%--	session  属性作用范围仅限同一次会话：浏览器打开直到关闭称为一次会话(前提是在此期间会话不失效)  --%>
	
	<br /><br />
	applicationAttr:<%= application.getAttribute("applicationAttr") %>
	
	<%--	application  属性作用范围仅限当前WEB应用  是范围最大的属性作用范围 只要在一处设置属性，其他各处JSP或Servlet中都可以获取   --%>
	
	
	<%-- 当前页面都可获取 --%>
	

	<br /><br />
	<a href="attr_2.jsp"> 点击跳转  Attr 2 page </a>
	
	
	<br /><br />
	<a href="testAttr"> To Attr Servlet </a>


	<%--
		跳转到attr_2.jsp时
			pageContextAttr:null 
			requestAttr:null 
			
		解决：使用请求转发
	
	 --%>
		
	<%
		//请求转发
		//request.getRequestDispatcher("/attr_2.jsp").forward(request, response);
	
	%>

	








</body>
</html>