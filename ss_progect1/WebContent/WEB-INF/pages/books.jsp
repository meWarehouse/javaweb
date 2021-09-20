<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%--    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
 <%@include file="/commons/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		/* $("a").click(function(){
			
			var serializeVal = $(":hidden").serialize();
			
			console.log(serializeVal);
			
			var href=this.href + "&" + serializeVal;
			window.location.href=href;
			
			
			return false;
		});  */
		
		$("#pageNo").change(function(){
			
			var val = $(this).val();
			
			val = $.trim(val);
			
			console.log("---:"+val);
			
			/* // 1.校验 val 是否合法
			var reg = "/^\d+$/g";//错
			
			var reg = /^\d+$/g;
			
			if(!reg.test(val)){
				alert("输入的页面不合法");
				$(this).val("");
				return;
			}
			
			// 2.校验 val 是否在一个合法的范围内：1-totalPageNumber
			
			var pageNo = parseInt(val);
			
			console.log("-------------pageNo:"+pageNo);
			
			console.log("-------------totalPageNumber:"+parseInt("${requestScope.bookPage.totalPageNumber}"));
			
			if(pageNo < 1 || pageNo > parseInt("${requestScope.bookPage.totalPageNumber}")){
				alert("输入的页面不合法");
				$(this).val("");
				return;
			} */
			
			var reg = /^\d+$/g;
			var pageNo = 0;
			var flag = false;
			
			if(reg.test(val)){
				pageNo = parseInt(val);
				if(pageNo >= 1 && pageNo <= parseInt("${requestScope.bookPage.totalPageNumber}")){
					flag = true;
				}
				
			}
			
			if(!flag){
				alert("输入的页面不合法");
				$(this).val("");
				return;
			}
			
			
			// 3.页面跳转
			var href="bookServlet?method=getBooks&pageNo=" + pageNo + "&" + $(":hidden").serialize();
			window.location.href=href;
			
			
		});
		
		
	});
	
	
</script>

<%@include file="/commons/queryCondition.jsp" %>

</head>
<body>

	<c:if test="${param.title != null}">
		您已将  <font color="red">${param.title }</font> 放入购物车中
		<br><br>
	</c:if>

	<c:if test="${!empty sessionScope.ShoppingCart.books }">
		您的购物车里有 ${sessionScope.ShoppingCart.bookNumber }  本书,<a href="bookServlet?method=forwardPage&page=cart&pageNo=${bookPage.pageNo}&id=${book.id}">查看购物车</a>
	</c:if>

	<!-- 设置隐藏域 在翻页过程中保存查询条件
	<input type="hidden" name="minPrice" value="${param.minPrice }" />
	<input type="hidden" name="maxPrice" value="${param.maxPrice }" />
	 -->

	<div>
	
		<br><br>
		<!-- <form action="bookServlet?method=getBooks"> -->
		<form action="bookServlet?method=getBooks" method="post">
			Price:
			<input type="text" size="1" name="minPrice" /> - 
			<input type="text" size="1" name="maxPrice" />
			
			<input type="submit" value="Submit" />
		</form>
		
		<br><br>
		
		<table cellpadding="10">
			<c:forEach items="${requestScope.bookPage.list}" var="book">
				<tr>
					<td>
						<a href="bookServlet?method=getBook&pageNo=${bookPage.pageNo}&id=${book.id}">${book.title}</a>
						<br>
						${book.author}
					</td>
					<td>${book.price }</td>
					<td><a href="bookServlet?method=addToCart&pageNo=${bookPage.pageNo}&id=${book.id}&title=${book.title}">加入购物车</a></td>
				</tr>
			</c:forEach>
		</table>
		<br><br>
		共 ${requestScope.bookPage.totalPageNumber} 页
		&nbsp;&nbsp;
		当前 ${bookPage.pageNo} 第页
		&nbsp;&nbsp;
		
		<c:if test="${bookPage.hasPrev}">
			<a href="bookServlet?method=getBooks&pageNo=1">首页</a>
			&nbsp;&nbsp;
			<a href="bookServlet?method=getBooks&pageNo=${bookPage.pervPage}">上一页</a>
		</c:if>
		
		&nbsp;&nbsp;
		
		<c:if test="${bookPage.hasNext}">
			<a href="bookServlet?method=getBooks&pageNo=${bookPage.nextPage}">下一页</a>
			&nbsp;&nbsp;
			<a href="bookServlet?method=getBooks&pageNo=${requestScope.bookPage.totalPageNumber}">尾页</a>
		</c:if>

		&nbsp;&nbsp;
		转到<input type="text" size="1" id="pageNo">页

		
	</div>
</body>
</html>