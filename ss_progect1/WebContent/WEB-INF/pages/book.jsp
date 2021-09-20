<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/commons/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
<!-- <script type="text/javascript">

	$(function(){
		$("a").click(function(){
			var serializeVal = $(":hidden").serialize();
			
			console.log("+++++++——————————："+serializeVal);
			
			var href=this.href + "&" + serializeVal;
			window.location.href=href;
			
			return false;
		});
	});

	
</script> -->

<%@include file="/commons/queryCondition.jsp" %>
</head>
<body>

	<%-- <input type="hidden" name="minPrice" value="${param.minPrice }" />
	<input type="hidden" name="maxPrice" value="${param.maxPrice }" /> --%>

	<div>
		
		Title：${book.title }
		<br><br>
		
		Author：${book.author }
		<br><br>
		
		Price：${book.price }
		<br><br>
		
		PublishingDate：${book.publishingDate }
		<br><br>
		
		Remark：${book.remark }
		<br><br>
		
		<a href="bookServlet?method=getBooks&pageNo=${param.pageNo}"> 继续购物 </a>
	
	
	
	
	</div>	

</body>
</html>