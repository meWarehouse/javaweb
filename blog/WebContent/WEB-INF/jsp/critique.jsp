<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,com.blog.bean.*" 	pageEncoding="utf-8"%>
<%@ taglib   prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0055)../critique/critique -->
<html xmlns="http://www.w3.org/1999/xhtml"
	class=" js csstransforms csstransforms3d csstransitions">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible"
	content="IE=edge,chrome=1,text/html; charset=utf-8">
<link rel="shortcut icon"
	href="../favicon.ico">
<title>个人博客——留言板</title>
<meta name="keywords" content="个人博客模板,博客模板,响应式">
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。">
<link href="../include/css/base.css" rel="stylesheet">
<link href="../include/css/style.css" rel="stylesheet">
<link href="../include/css/media.css" rel="stylesheet">
<script type="text/javascript" src="../include/js/jquery.min.js"></script>
<script type="text/javascript"
	src="../include/js/jquery.gallery.js"></script>
<script type="text/javascript"
	src="../include/js/modernizr.custom.53451.js"></script>
<script type="text/javascript" src="../include/js/ckeditor.js"></script>
<style>
.cke {
	visibility: hidden;
}
</style>
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0,initial-scale=1.0,maximum-scale=1.0">
<!--[if lt IE 9]>
		<script src="../include/js/modernizr.js"></script>
		<![endif]-->
<script src="../include/js/share.js"></script>
<link rel="stylesheet" href="../include/css/share_style1_32.css">
</head>
<body>
	<div class="ibody">
		<header>
			<h1>提拉米苏.甜腻的苦涩</h1>
			<h2>做好的提拉米苏被遗忘在角落 我的手再也挽留不住你离去的脚步 爱情是甜蜜的苦涩,无奈的别离 苦涩的怕不是味道,而是心绪</h2>
			<div class="logo">
				<a href="../index/index"></a>
			</div>
	
			<nav id="topnav"> 
			    <a href="../index/index">首页</a>
			    <a href="../about/about">关于我</a>
			    <a href="../article/article">慢生活</a> 
			    <a href="../album/album">我的相册</a> 
			    <a href="../critique/critique"   id="topnav_current">留言板</a> 
		    </nav> 
		</header>
		<article>
		<h2 class="about_h">
			您现在的位置是：<a href="../index/index">首页</a>&gt;<a
				href="../critique/critique">留言板</a>
		</h2>
		<div class="template">
			<h3>
				<p>
					<span>最新留言</span>
				</p>
			</h3>
			<ul class="pl_n">
                <%
                       List<Critique>    critiquesPage=(List<Critique>)request.getAttribute("critiquesPage");
                       Iterator<Critique>    iterator=critiquesPage.iterator();
                       while(iterator.hasNext()){
                    	         Critique    critique=iterator.next();
                    
                %>
				<dl>
					<dt>
						<img src="../include/images/s8.jpg">
					</dt>
					<dt></dt>
					<dd>
						<table align="left" width="200">
							<tbody>
								<tr>
									<td width="80"><%=critique.getName() %></td>
									<td><time><%=critique.getTime() %></time></td>
								</tr>
							</tbody>
						</table>
					</dd>
					<dd>
						<a href="../critique/critique#">
							 <%=critique.getContent()%>
							 <!--   <s:property value="content" escape="false"/>  -->
						</a>
					</dd>
				</dl>
                <%} %>
			</ul>


			<div class="page">
                 <!--
		          ${page1}:获取   前面request.setAttribute("page1", page);page的值 
		      
		          test:是一个属性名 判断条件跟java中if里面
		          var ：是定义一个属性
		          result:是把${page==1}结果的值(值是true或者false)给result
		          
			          这里是判断是否是第一页，因为第一页不需要跳转
			     -->
			    <c:if test="${page==1}"  var="result"> 
			          <a href="#">&lt;</a>
			    </c:if>
			    <!-- 相当于是else 如果上面是true，这里就是fals；如果上面是false，这里就是true-->
			    <c:if test="${!result }">
			          <a href="../critique/critique?page=${page-1}">&lt;</a>
			    </c:if>
			    
				
				<!-- 相当于java中的for循环
				       var="i"相当于java的int i
				       begin=1相当于java的  i=1
				       end相当于1<=${totalPage }
				 -->
				<c:forEach  var="i"   begin="1"   end="${totalPage }">
				            <!-- 判断是否是当前页，如果是当前页要是黑体 -->
				          <c:if test="${page==i}" var="result2">
				                <b>${i}</b>
				          </c:if>
				          <!-- 下面代表不是当前页 -->
				          <c:if test="${!result2 }">
				                 <a href="../critique/critique?page=${i}">${i }</a>   
				          </c:if>
				</c:forEach>
				
				
				<!-- 这里是判断是否是最后一页，最后一页也不需要跳转 
				-->
				<c:if test="${page==totalPage }" var="result1">
				        <a href="javascript:(0)">&gt;</a>
				</c:if>
				<!-- 如果是最后一页，result1就是true，就不执行下面的代码；
				     如果不是最后一页，result1就是false,那么就执行下面的代码
				 -->
				<c:if test="${!result1 }">
				        <a 	href="../critique/critique?page=${page+1 }">&gt;</a>
				</c:if>
			</div>

			<h3>
				<p>
					<span>随便说说</span>
				</p>
				<a href="../critique/critique#"
					target="_blank" class="more"></a>
			</h3>
			<form  		action="../critique/critique_add"  	method="post">
				<table>
					<tbody>
						<tr>
							<td><span>您的姓名:</span></td>
							<td><input name="name"></td>
						</tr>
						<tr>
							<td><div style="width: 70px; padding-bottom: 189px;">
									<span>留言内容:</span>
								</div></td>
							<td><textarea name="content" 	style="height: 200px; width: 630px;"></textarea></td>
						</tr>
						<tr>
							<td></td>
							<td><button type="submit"
									style="width: 60px; height: 30px; font-size: larger;">提交</button></td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>
		</article>
		<aside>
		<div class="rnav">
			<li class="rnav1 "><a
				href="http://blog_hao.jd-app.com/index/index">个人博客</a></li>
			<li class="rnav2 "><a href="http://user.qzone.qq.com/6576382618">QQ空间</a></li>
			<li class="rnav3 "><a
				href="../critique/critique#">个人作品</a></li>
			<li class="rnav4 "><a
				href="../critique/critique#">随便逛逛</a></li>
		</div>
		<div class="ph_news">
			<h2>
				<p>点击排行</p>
			</h2>
			<ul class="ph_n">
				 <%
			         int   num=0;
	                //获取对应页数的数据
	                List<Article>   articlesHot=(List<Article>)request.getAttribute("articlesHot");
	                Iterator<Article>    iterator2=articlesHot.iterator();
	                while(iterator2.hasNext()){
	              	     num++;
	                	 Article   article2=iterator2.next();//获取一篇文章
	                	 request.setAttribute("num", num);
	              	    
			    %>
				<li>
				    <!-- ${num}   num必须是request.setAttribute("num",值) -->
				    <c:if test="${num<4}"  var="result">
				          <span class="num1"><%=num %></span>
				    </c:if>
				    <!-- 下面是没有样式的，上面是有样式的 -->
				    <c:if test="${!result}">
				          <span><%=num %></span>
				    </c:if>   
				    <a  	href="../article/article_detail?id=<%=article2.getId() %>">
						   <%=article2.getTitle() %>
				    </a>
			    </li> 
			    <%} %>
			</ul>
			<h2>
				<p>栏目推荐</p>
			</h2>
			<ul>
				<%
                      //获取对应页数的数据
                      List<Article>   articlesRecommend=(List<Article>)request.getAttribute("articlesRecommend");
                      Iterator<Article>    iterator3=articlesRecommend.iterator();
                      while(iterator3.hasNext()){
                    	    Article   article3=iterator3.next();//获取一篇文章
                 %>
				            <li>
							   <a href="../article/article_detail?id=<%=article3.getId()%>">
							         <%=article3.getTitle() %>
							   </a>
							</li>
  				<%     } %>

			</ul>
			<div class="copyright">
				<ul>
					<p>
						Design by <a
							href="../critique/critique#">jim</a>
					</p>
					<p></p>
					<p></p>
				</ul>
			</div>
		</div>
		</aside>
		<script src="../include/js/silder.js"></script>
		<div class="clear"></div>
		<!-- 清除浮动 -->
	</div>
</body>
</html>