<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h4> Book Details Page </h4>
	
	Book：<%=request.getParameter("book") %>
	
	<br><br>
	
	<a href="books.jsp">Return...</a>
	
	<%
		String book = request.getParameter("book");
	
		//将书的信息以 Cookie 方式传回浏览器 ，删除一个 Cookie
		//1.确定要被删除的 Cookie：
		//前提：MAX_BOOK_ 开头的 Cookie 数量大于或等于 5 
		Cookie[] cookies = request.getCookies();
	
		//保存所有以  MAX_BOOK_ 开头的Cookie
		List<Cookie> bookCookies = new ArrayList<Cookie>();
		//用来保存和 book.jsp 传入的 book 匹配的那个 Cookie 
		Cookie tempCookie = null;
		
		if(cookies != null && cookies.length > 0){
			for(Cookie c : cookies){
				String cookieName = c.getName();
				if(cookieName.startsWith("MAX_BOOK_")){
					bookCookies.add(c);
					
					if(c.getValue().equals(book)){
						tempCookie = c;
					}
					
				}
				
				
			}
		}
	
		//①：且若从 books.jsp 页面传入的 book 不在 MAX_BOOK_ 的 Cookie 中则删除较早的那个 Cookie
		if(bookCookies.size() >= 5 && tempCookie == null){
			tempCookie = bookCookies.get(0);
		}
		
		//②：若在 MAX_BOOK_ 中，则删除该Cookie
		if(tempCookie != null){
			tempCookie.setMaxAge(0);
			response.addCookie(tempCookie);
		}
		
		
		
		//2.把从 books.jsp 传入的 book 作为一个 Cookie 返回
		//String book = request.getParameter("book");
		Cookie cookie = new Cookie("MAX_BOOK_"+book,book);
		response.addCookie(cookie);
	
	
	
	%>
	
	
	

</body>
</html>