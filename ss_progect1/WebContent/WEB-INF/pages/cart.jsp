<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
    <%@include file="/commons/common.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="script/jquery-3.3.1.min.js"></script>
<script type="text/javascript">

	$(function(){
		
		$("a.delete").click(function() {
			
			var title = $(this).parent().parent().find("td:eq(0)").text().trim();
		
			alert(title);
		
			var flag = confirm("是否确认删除" + title + "的信息吗？");
		
			alert(flag);
			console.log(flag);
		
			return flag;
		
		});
		
		
		//ajax请求修改单个商品的数量
		//1.获取页面中所有 text，并为其添加 onchange 响应函数
		$(":text").change(function(){
			
			var quantityVal = $.trim(this.value);
			
			//校验
			var f = false;
			var reg = /^\d+$/g;
			var quantity = -1;
			if(reg.test(quantityVal)){
				quantity = parseInt(quantityVal);
				if(quantity >= 0){
					f = true;
				}
			}
			
			
			if(!f){
				alert("输入不合法！！");
				$(this).val($(this).attr("class"));//回显quantity数据
				return;
			}
			
			var $tr = $(this).parent().parent()
			
			var title = $tr.find("td:eq(0)").text().trim();
			//判断 quantity 为 0 的情况 
			if(quantity == 0){
				var f2 = confirm("确认要删除"+title+"的信息吗？");
				if(f2){
					/* var href = $tr.find("td:last").find("a").attr("href");
					
					var serializeVal = $(":hidden").serialize();

					href = href + "&" + serializeVal; 优化 */
					
					//得到了 a 节点
					var $a = $tr.find("td:last").find("a");
					//执行 a 节点 onclick  响应函数
					//alert("typeof:" + (typeof $a)+"typeof:$a[0]"+$a[0]);
					//alert($a[0].onclick);//获取 $a 的第一个节点的响应函数   如果能够获取应该是个响应函数
					
					$a[0].onclick();
					
					window.location.href = href;
					return;
				}
			}
			
			
		
			var flag = confirm("是否确认修改"+title+"的数量吗？");
			
			alert(flag);
			
			if(!flag){
				$(this).val($(this).attr("class"));//回显quantity数据
				return;
			}
			
			alert("--------------");
			
			//2.请求地址为 bookServlet
			var url = "bookServlet";
			
			//3.请求参数为：method:updateItemQuantity,id:name属性,quantity:val,time:new Date()
			var idVal = $.trim(this.name);
			
			console.log("idVal:"+idVal);
			console.log("quantityVal:"+quantityVal);
			
			var args = {"method":"updateItemQuantity","id":idVal,"quantity":quantityVal,"time":new Date()}
			
			//4.在 updateItemQuantity 方法中获取 quantity，id 再获取购物车对象，调用 servlet 的方法做修改
			//5.传回 json 数据：bookNumber:xxx 和 totalMony
			
			//6.更新当前页面的 bookNumber 和 totalMony
			$.post(url,args,function(data){
				
				var bookNumber = data.bookNumber;
				var totalMony = data.totalMony;
				
				alert("bookNumber:"+bookNumber);
				alert("totalMony:"+totalMony);
				
				$("#totalmony").text("总金额：￥"+totalMony);
				$("#booknumber").text("您的购物车中共有"+bookNumber+"本书");
				
			},"JSON");	
			
		}); 
		
		
		
	});
	
</script>

</head>

<%@include file="/commons/queryCondition.jsp" %>

<body>
	
	<div id="booknumber">您的购物车中共有${sessionScope.ShoppingCart.bookNumber }本书</div>
	<br><br>
	
	<table cellpadding="10">
		<tr>
			<td>书名</td>
			<td>数量</td>
			<td>价格</td>
			<td>&nbsp;</td>
		</tr>
		<c:forEach items="${sessionScope.ShoppingCart.items }" var="item">
			<tr>
				<td>${item.book.title }</td>
				<td><input class="${item.quantity}" type="text" size="1" name="${item.book.id }" value="${item.quantity}" /></td>
				<td>${item.book.price }</td>
				<td><a href="bookServlet?method=remove&pageNo=${param.pageNo}&id=${item.book.id }" class="delete" >删除</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" id="totalmony">总金额：￥${sessionScope.ShoppingCart.totalMoney }</td>
		</tr>
		
		<tr>
			<td colspan="4">
				<!-- bookServlet?method=getBooks?pageNo=${bookPage.pageNo} -->
				<a href="bookServlet?method=getBooks&pageNo=${param.pageNo}">继续购物</a>
				&nbsp;
				<a href="bookServlet?method=clear">清空购物车</a>
				&nbsp;
				<a href="bookServlet?method=forwardPage&page=cash">结账</a>
			</td>
		</tr>
		
		
	</table>
	
	
	
</body>
</html>