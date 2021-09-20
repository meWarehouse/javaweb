<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function(){

		
		
		$("a").click(function() {
	
				var serializeVal = $(":hidden").serialize();
	
				var href = this.href + "&" + serializeVal;
	
				window.location.href = href;
	
				return false;
	
		});
		
		
		$("#pageNo").change(function(){
			
			var val = $(this).val();
			
			var reg = /^\d+$/g;
			
			if(!reg.test(val)){
				alert("输入的页码不合法");
				$(this).val("");
				return;
			}
			
			var pageno = parseInt(val);
			console.log(pageno+"::"+(typeof pageno))
			
			if(pageno < 1 || pageno > parseInt("${bookpage.totalPageNumber }")){
				alert("输入的页码不合法");
				$(this).val("");
				return;
			}
			
			//页面跳转
			var href = "bookServlet?method=getBooks&pageNo=" + pageno + "&" + $(":hidden").serialize();
			window.location.href = href;
			
		});

	});
</script>

</head>
<body>

	<input type="hidden" name="minprice" value="${param.minprice }" />
	<input type="hidden" name="maxprice" value="${param.maxprice }" />

	<!-- bookServlet?method=getBooks -->
	<form action="bookServlet?method=getBooks" method="post">
		Price:
		<input type="text" size="1" name="minprice" /> -
		<input type="text" size="1" name="maxprice" />
		<input type="submit" value="Submit" />
		
	</form>
	
	<br><br>
	
	<table cellpadding="10">
		<c:forEach items="${requestScope.bookpage.list }" var="book">
			<tr>
				<td>
					<a href="bookServlet?method=getBook&pageNo=${bookpage.pageNo}&id=${book.id}">${book.title }</a>
					<br>
					${book.author }
				</td>
				<td>${book.price }</td>
				<td><a href="">加入购物车</a></td>
			</tr>
		</c:forEach>
	</table>
	
	<br><br>
	
	共${bookpage.totalPageNumber }页
	&nbsp;
	
	当前第${bookpage.pageNo }页
	&nbsp;
	
	<!-- 有上一页就有首页 -->
	<c:if test="${bookpage.hasPrev }">
		<a href="bookServlet?method=getBooks&pageNo=1">首页</a>
		&nbsp;
		<a href="bookServlet?method=getBooks&pageNo=${bookpage.prevPage }">上一页</a>
	</c:if>

	&nbsp;
	
	<!-- pageNo=totalPageNumber(没有下一页) 没有末页与上一页  -->
	<c:if test="${bookpage.hasNext }">
		<a href="bookServlet?method=getBooks&pageNo=${bookpage.nextPage }">下一页</a>
		&nbsp;
		<a href="bookServlet?method=getBooks&pageNo=${bookpage.totalPageNumber }">末页</a>
	</c:if>
	
	&nbsp;
	跳转到<input type="text" size="1" id="pageNo" />页
	
	

</body>
</html>