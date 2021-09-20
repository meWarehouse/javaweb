<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,com.blog.bean.*" 	pageEncoding="utf-8"%>
<%@ taglib   prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0049)../album/album -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人博客——相册</title>
<meta name="keywords" content="个人博客模板,博客模板,响应式">
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。">
<link href="../include/css/base.css" rel="stylesheet">
<link href="../include/css/style.css" rel="stylesheet">
<link href="../include/css/media.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<!--[if lt IE 9]>
		<script src="js/modernizr.js"></script>
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
			    <a href="../album/album" id="topnav_current">我的相册</a> 
			    <a href="../critique/critique"   >留言板</a> 
	     </nav> 
	   </header>
		<article>
		<h2 class="about_h">
			您现在的位置是：<a href="../index/index">首页</a><a 	href="../album/album">相册</a>
		</h2>
		<div class="template">
			<h3>
				<p>
					<span>个人相册</span>
				</p>
				<a href="../album/album#" 		class="more"></a>
			</h3>
			<ul>
                <%
                        List<Album>    albumsAll=(List<Album>)request.getAttribute("albumsAll");
		                Iterator<Album>    iterator=albumsAll.iterator();
		                while(iterator.hasNext()){
		                	Album    album=iterator.next();
                %>
								<li>
								   <a	href="../album/album_detail?id=<%=album.getId()%>">
								      <img	src="<%=album.getImage()%>">
								   </a>
								   <span><%=album.getTitle()%></span>
								</li>
               <%       } %>
			

			</ul>
			<h3>
				<p>
					<span>最新评论</span>
				</p>
			</h3>
			<ul class="pl_n">
                 <%
                       List<Critique>    critiquesNew=(List<Critique>)request.getAttribute("critiquesNew");
                       Iterator<Critique>    iterator2=critiquesNew.iterator();
                       while(iterator2.hasNext()){
                    	         Critique    critique=iterator2.next();
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
		</div>
		</article>
		<aside>
		<div class="rnav">
			<li class="rnav1 "><a
				href="http://blog_hao.jd-app.com/index/index">个人博客</a></li>
			<li class="rnav2 "><a href="http://user.qzone.qq.com/657623482618">QQ空间</a></li>
			<li class="rnav3 "><a
				href="../album/album#">个人作品</a></li>
			<li class="rnav4 "><a
				href="../album/album#">原创程序</a></li>
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
	                Iterator<Article>    iterator5=articlesHot.iterator();
	                while(iterator5.hasNext()){
	              	     num++;
	                	 Article   article2=iterator5.next();//获取一篇文章
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
		</div>

		<div class="copyright">
			<ul>
				<p>
					Design by <a
						href="../album/album#">jim</a>
				</p>
				<p></p>
				<p></p>
			</ul>
		</div>
		</aside>
		<script src="../include/css/silder.js"></script>
		<div class="clear"></div>
		<!-- 清除浮动 -->
	</div>
</body>
</html>