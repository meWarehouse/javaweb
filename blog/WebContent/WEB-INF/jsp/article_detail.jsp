<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,com.blog.bean.*" 	pageEncoding="utf-8"%>
<%@ taglib   prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人博客——详细内容</title>
<meta name="keywords" content="个人博客模板,博客模板,响应式">
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。">
<link href="../include/css/base.css" rel="stylesheet">
<link href="../include/css/style.css" rel="stylesheet">
<link href="../include/css/media.css" rel="stylesheet">
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<!--[if lt IE 9]>
		<script src="../include/js/modernizr.js"></script>
		<![endif]-->
<script src="../include/js/share.js"></script>
</head>
<body>
	<div class="ibody">
		<header>
			<h1>提拉米苏.甜腻的苦涩</h1>
			<h2>做好的提拉米苏被遗忘在角落 我的手再也挽留不住你离去的脚步 爱情是甜蜜的苦涩，无奈的别离 苦涩的怕不是味道，而是心绪</h2>
			<div class="logo">
				<a href="../index/index"></a>
			</div>
	
			<nav id="topnav"> <a
				href="../index/index">首页</a> <a
				href="../about/about">关于我</a> <a
				href="../article/article" id="topnav_current">慢生活</a> <a
				href="../album/album">我的相册</a> <a
				href="../critique/critique">留言板</a>
		    </nav>
		</header>
		<article>
		<h2 class="about_h">
			您现在的位置是：<a href="../index/index">首页</a>&gt;<a
				href="../article/article">慢生活</a>&gt;
				<a	href="#">详细内容</a>
		</h2>
		<div class="index_about">
		    <%
		          Article   article=(Article)request.getAttribute("article");
		    %>
			<h2 class="c_titile"><%=article.getTitle()%></h2>
			<p class="box_c">
				<span class="d_time">发布时间：<%=article.getTime()%></span>
				<span>编辑：<%=article.getEditer()%></span>
				<span>浏览(<%=article.getCount()%>)</span>
				<span>评论(<%=article.getCount1()%>)</span>
			</p>
			<ul class="infos">
                   <%=article.getContent() %>
			</ul>
			<!-- ======================================================== -->
			<div class="keybq">
				<p>
					<span>关键字词</span>：<%=article.getKeywords() %>
				</p>
			</div>
			<div class="nextinfo">
			   <c:if test="${articleBefore!=null}">
			        <p>
						上一篇：<a href="../article/article_detail?id=${articleBefore.id}">${articleBefore.title}</a>
					</p>
			   </c:if> 
			   <c:if test="${articleAfter!=null}">
			        <p>
						下一篇：<a href="../article/article_detail?id=${articleAfter.id}">${articleAfter.title}</a>
					</p>
			   </c:if> 
			</div>
		</div>
		</article>
		<aside>
		<div class="rnav">
			<li class="rnav1 "><a
				href="../article/article_detail?id=<%=article.getId()%>">日记</a></li>
			<li class="rnav2 "><a
				href="../article/article_detail?id=<%=article.getId()%>">欣赏</a></li>
			<li class="rnav3 "><a
				href="../article/article_detail?id=<%=article.getId()%>">程序人生</a></li>
			<li class="rnav4 "><a
				href="../article/article_detail?id=<%=article.getId()%>">经典语录</a></li>
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
	                Iterator<Article>    iterator=articlesHot.iterator();
	                while(iterator.hasNext()){
	              	     num++;
	                	 Article   article2=iterator.next();//获取一篇文章
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
                      Iterator<Article>    iterator2=articlesRecommend.iterator();
                      while(iterator2.hasNext()){
                    	    Article   article3=iterator2.next();//获取一篇文章
                 %>
				            <li>
							   <a href="../article/article_detail?id=<%=article3.getId()%>">
							         <%=article3.getTitle() %>
							   </a>
							</li>
  				<%     } %>
			</ul>
			
			
			<h2>
				<p>最新评论</p>
			</h2>
			<ul class="pl_n">
			    <%
                      //获取对应页数的数据
                      List<Critique>   critiquesNew=(List<Critique>)request.getAttribute("critiquesNew");
                      Iterator<Critique>    iterator3=critiquesNew.iterator();
                      while(iterator3.hasNext()){
                    	  Critique   critique=iterator3.next();//获取一篇文章
                 %>
				<dl>
					<dt>
						<img src="../include/images/s8.jpg">
					</dt>
					<dt></dt>
					<dd>
						<%=critique.getName() %>
						<time>
						     <%=critique.getName()%>
						</time>
					</dd>
					<dd>
						<a 		href="../article/article_detail?id=<%=article.getId()%>">
							       <%=critique.getContent() %>
						</a>
					</dd>
				</dl>
               <%} %>
			</ul>
		</div>

		<div class="copyright">
			<ul>
				<p>
					Design by 
					<a href="../article/article_detail?id=<%=article.getId()%>">jim</a>
				</p>
				<p></p>
				<p></p>
			</ul>
		</div>
		</aside>
		<script src="../include/js/silder.js"></script>
		<div class="clear"></div>
		<!-- 清除浮动 -->
	</div>
</body>
</html>