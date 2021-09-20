<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="js/jQuery-3.1.1.js"></script>
<script type="text/javascript">
	
	

	$(function() {
		
	
		
		//定义一个变量保存当前页码
		var currentPage = 1;
		
		//全局变量保存总共有几页
		var totalPage = 0;
		
		$("#pagecode").val("当前第"+currentPage+"页");
		
		
		//发送 ajax 请求 获取列表数据 	load 是 post 请求	load方法是发送ajax请求，获取响应，将响应内容放入到一个元素中
		$("#item").load("itemservlet",{pageNum : currentPage});
		
		/*
			发送 ajax 请求来获取总条数
			$.get()方法是发送 的是 ajax类型的get 请求  获取响应后，调用一个函数，将响应的内容传递给这个函数
		*/
		$.get("itemservletcount",function(data){
			
			console.log("data:"+data);
			console.log("typeof:"+(typeof data) )
			
			totalPage = Math.ceil(data/10);
			
			console.log("totalpage:"+totalPage);
			
			$("#pagesum").val("总共"+totalPage+"页");
			$("#pagecount").val("总共"+data+"条");
			
			createPageBar(totalPage);
			
			
		},"json");// "json" 会将响应的内容转换成 json 对象
		
		
		//页码条
		function createPageBar(totalPage){
			var pages = "";
			if(totalPage >= 5){
				for(var i = 1;i <= 10;i++){
					pages = pages+"<a href='javascript:void(0)' id='jumpPage' value='"+i+"' onclick='jumpPage("+i+")'  >"+i+"<a>&nbsp;&nbsp;";
				}
			}else{
				for(var i = 1;i <= totalPage;i++){
					pages = pages+"<a href='javascript:void(0)' id='jumpPage' value='"+i+"' onclick='jumpPage("+i+")' >"+i+"<a>&nbspp;&nbsp;";
				}
			}
			
			$("#pageBar").html(pages);
		}
		

		/* $("#jumpPage").click(function(){
			var num = $("#jumpPage").val();
			console.log(typeof num);
			console.log("num:::"+ num);
		});
		 */
		
		 
	
		//下一页
		/*
		function nextPage(){
			currentPage++;
			$("#item").load("itemservlet",{pageNum : currentPage});
		}
		*/
		//下一页
		$("#next").click(function(){
			
			if(currentPage < totalPage){
				currentPage++;
				$("#item").load("itemservlet",{pageNum : currentPage});
				$("#pagecode").val("当前第"+currentPage+"页");
			}else{
				alert("diyi");
			}
			
		});
		
		//上一页
		$("#pre").click(function(){
			if(currentPage > 1){
				currentPage--;
				$("#item").load("itemservlet",{pageNum : currentPage});
				$("#pagecode").val("当前第"+currentPage+"页");
			}else{
				alert("diyi");
			}
			
		});
		
		$("#btn").click(function(){
			
			var jumpPageNumber = parseInt($("#jumpPageNumber").val());
			console.log(typeof jumpPageNumber);
			
			if(jumpPageNumber >=1 && jumpPageNumber <= totalPage){
				$("#item").load("itemservlet",{pageNum : jumpPageNumber});
			}else{
				alert("asdvfbgnhm");
			}
		});
		
		
		
		
	});
	
	function jumpPage(pageNum){
		 console.log("pageNumer------:"+pageNum);
		
	}
	
</script>

</head>
<body>


	<h2>商品列表</h2>

	<div id="item"></div>

	<input type="button" value="上一页" id="pre" />
	
	<b id="pageBar"></b>
	
	<input type="button" value="下一页" id="next" />
	<input id="jumpPageNumber" type="text" style="width:30px" /><input type="button" value="go" id="btn" /> 
	<br>
	<input id="pagecode" value="" disabled="disabled"/>
	<input id="pagesum" value="" disabled="disabled" />
	<input id="pagecount" value="" disabled="disabled" />
	




</body>
</html>