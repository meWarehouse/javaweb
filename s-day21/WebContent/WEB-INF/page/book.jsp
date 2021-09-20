<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	});
</script>
</head>
<body>

	<input type="hidden" name="minprice" value="${param.minprice }" />
	<input type="hidden" name="maxprice" value="${param.maxprice }" />

	Author：${book.author }
	<br><br>
	
	Title：${book.title }
	<br><br>
	
	Price：${book.price }
	<br><br>
	
	PublishingDate：${book.publishingDate }
	<br><br>
	
	Salesamount：${book.salesaMount }
	<br><br>
	
	Remark：${book.remark }
	<br><br>
	
	<a href="bookServlet?method=getBooks&pageNo=${param.pageNo}"> 返回继续购物 </a>

</body>
</html>