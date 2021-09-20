<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%=session.getId()%>
	
	
	<%
	
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		cookie.setMaxAge(60);
		response.addCookie(cookie);
	
	%>
	
	<%--
	
		HttpSession 的生命周期
			1.生么时候创建 HttpSession 对象
				
				①：对于  JSP  是否浏览器会访问服务端的任何一个 JSP，服务器都会立即创建一个 HttpSession 对象呢？
					不一定。
					> 若当前的jsp是客户端访问的当前 WEB 应用的第一个资源，且 JSP 的 page 指定的 session 属性值为 false，则服务器就不会为 JSP 创建一个 HttpSession 对象
					> 若当前 JSP 不是客户端访问的当前的 WEB 应用的第一个资源，且其他页面已经创建过 HttpSession 对象，则当前 JSP 页面也不会创建 HttpSession 对象，而会将与当前会话的关联的那个 HttpSession 对象返回给当前 JSP 页面
				②：对于 Servlet ：若 Servlet 是客户端访问的一个 WEB 应用资源，则 只有调用 request.getSession() 或 request.getSession(true) 才会创建 HttpSession 对象
					若不是 第一个 则与 jsp 类似
					
			2.配置指定 session="false" 表示到底什么意思
				表示当前 JSP 页面禁用 session 隐含变量 但可以使用其他的显示的 HttpSession 对象
			3.在 Servlet 中如何获取 HttpSession 对象
			
				HttpSession	getSession()
				HttpSession	getSession(boolean create) :
					create 为 false
						若没有和当前 JSP 页面关联的 HttpSession 对象 则返回 null；若有则返回 true
					create 为 true 等同于 HttpSession	getSession()
						一定返回一个 HttpSession 对象 ，若有关联的 返回关联的 HttpSession ，若没有 则新创建一个 HttpSession 对象
			4.什么时候销毁 HttpSession 对象:
				①：直接调用 HttpSession 的 invalidate() 方法 该方法使 HttpSession 失效
				②：服务器卸载了当前 WEB 应用(或服务器进程被停止)
				③：超出 HttpSession 的过期时间
					> 设置 HttpSession 的过期时间 session.setMaxInactiveInterval(5); 单位为秒
					> 在 web.xml 文件中设置  HttpSession 的过期时间：单位为 分钟
						<session-config>
							<session-timeout>30</session-timeout>
						</session-config>	
				④：并不是关闭了浏览器就结束了 session cookie
					
	
	 --%>
	
</body>
</html>