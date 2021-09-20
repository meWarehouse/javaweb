<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	//Java Server Page : Java服务器端网页，在HTML页面中编写Java代码页面

	<%
		Date date  = new Date();
		//System.out.print("..."+date);
	%>
	
	<%
		String str = date.toString();
	
		//没有声明就可以使用的对象称为

		//request:HttpServletRequest *
		String name = request.getParameter("name");
		System.out.print(name);
		
		//response:HttpServletResponse(在JSP页面中几乎不用)
		Class cla = response.getClass();
		System.out.println(cla);
		
		System.out.println(response instanceof HttpServletResponse);
		
		
		//pageContext:页面的上下文，是PageContext的一个对象，可以从该对象中获取到其他8个隐含对象，也可以从中获取到当前页面的其他信息(自定义标签时常用) *
		HttpServletRequest req = (HttpServletRequest)pageContext.getRequest();
		System.out.print(req == request);
		
		
		//session：代表浏览器的一次会话(从程序开始到结束) HttpSession 的一个对象 *
		System.out.println(session.getId());
	
		
		//application ：代表当前WEB应用 是ServletContext对象 *
		System.out.println("-----------"+application.getInitParameter("password"));
		
		//config 当前JSP对应的Servlet的ServletConfig对象(开发时几乎不使用)
		System.out.println(config.getInitParameter("test1"));//若需要访问当前JSP配置的初始化参数，需要通过映射的路径才可以
		
		//out  JspWriter 对象 调用out.println() 可以直接将字符串打印到浏览器上 *
		out.println(session.getId());
		
		//换行
		out.print("<br><br>");		

		out.println("123354657686798707756453");
		
		out.print("<br><br>");
		//page 指向当前JSP对应的Servlet对象的引用 但为Object类型 只能调用Object类的方法(开发中几乎不用)
		out.println(this);
		out.print("<br><br>");
		out.println(page);
		
		//exception 在一定的条件下才可以使用   只有在声明了 page isErrorPage="true"时才可以使用 
		
		//pageContext*, request*, session*, application* 对属性作用域的范围从小到大
		//out*, response, config, page
		//exception
				
				
				
				
				
				
	%>

</body>
</html>