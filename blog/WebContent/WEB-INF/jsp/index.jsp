<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*,com.blog.bean.Article" 	pageEncoding="utf-8"%>
<%@ taglib   prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人博客——主页</title>
		<meta name="keywords" content="个人博客模板,博客模板,响应式">
		<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。">
		<link href="../include/css/base.css" rel="stylesheet">
		<link href="../include/css/index.css" rel="stylesheet">
		<link href="../include/css/style.css" rel="stylesheet">
		<link href="../include/css/media.css" rel="stylesheet">
		<style type="text/css">
					/*为段落定义样式*/
		</style>
		<meta name="viewport" 	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
		<!--[if lt IE 9]>
				<script src="../include/js/modernizr.js"></script>
		<![endif]-->
		<script src="../include/js/share.js"></script>
</head>
<body>
	<div class="ibody">
		<header>
			<h1>提拉米苏.甜腻的苦涩</h1>
			<h2>做好的提拉米苏被遗忘在角落 我的手再也挽留不住你离去的脚步 爱情是甜蜜的苦涩,无奈的别离 苦涩的怕不是味道,而是心绪</h2>
			<div class="logo">
				<a href="../index/index?page=1"></a>
			</div>
			<nav id="topnav"> 
			    <a href="../index/index?page=1" id="topnav_current">首页</a>
			    <a href="../about/about">关于我</a>
			    <a href="../article/article">慢生活</a> 
			    <a href="../album/album">我的相册</a> 
			    <a href="../critique/critique">留言板</a> 
			 </nav> 
		</header>
		<article>
			<div class="banner">
				<ul class="texts">
					<p>The best life is use of willing attitude, a happy-go-lucky
						life.</p>
					<p>最好的生活是用心甘情愿的态度，过随遇而安的生活。</p>
				</ul>
			</div>
		<div class="bloglist">
			<h2>
				<p>
					<span>推荐</span>文章
				</p>
			</h2>
            
            <%
                      //获取对应页数的数据
                      List<Article>   articlesPage=(List<Article>)request.getAttribute("articlesPage");
                      Iterator<Article>    iterator=articlesPage.iterator();
                      while(iterator.hasNext()){
                    	    Article   article=iterator.next();//获取一篇文章
                    
            %>
			<div class="blogs">
				<h3>
					<a 	href="../article/article_detail?id=<%=article.getId()%>">
						   <%=article.getTitle() %>
				    </a>
				</h3>
				<figure>
				<img src="<%=article.getImage()%>"></figure>
				<ul>
					<div class="content" style="height: 12em; clear: both;">
                          <%=article.getContent() %> 
					</div>
					<a href="../article/article_detail?id=<%=article.getId()%>" target="_blank" class="readmore" style="color:white;">阅读全文&gt;&gt;</a>
				</ul>
				<p class="autor">
					<span>作者：<%=article.getEditer() %></span>
					<span>分类：【<a href="http://localhost:8080/"><%=article.getType() %></a>】</span>
					<span>浏览（<a href="http://localhost:8080/"><%=article.getCount() %></a>）</span>
					<span>评论（<a href="http://localhost:8080/"><%=article.getCount1() %></a>）</span>
				</p>
				<div class="dateview"><%=article.getTime() %></div>
			</div>
            <%
                      }
            %>
            
            <!-- ?????????????????????????????????????????????????????? --> 
		</div>
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
		          <a href="../index/index?page=${page-1}">&lt;</a>
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
			                 <a href="../index/index?page=${i}">${i }</a>   
			          </c:if>
			</c:forEach>
			
			
			
			
			<!-- 这里是判断是否是最后一页，最后一页也不需要跳转 
			-->
			<c:if test="${page==totalPage }" var="result1">
			        <a href="#">&gt;</a>
			</c:if>
			<!-- 如果是最后一页，result1就是true，就不执行下面的代码；
			     如果不是最后一页，result1就是false,那么就执行下面的代码
			 -->
			<c:if test="${!result1 }">
			        <a 	href="../index/index?page=${page+1 }">&gt;</a>
			</c:if>
		</div>
		</article>
		<aside>

		<div class="avatar">
			<a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"><span>关于Jim</span></a>
		</div>
		<div class="topspaceinfo">
			<h1>执子之手，与子偕老</h1>
			<p>于千万人之中，我遇见了我所遇见的人....</p>
		</div>
		<div class="about_c">
			<p>网名：jim</p>
			<p>职业：Java程序员</p>
			<p>籍贯：江西-鹰潭</p>
			<p>QQ：35353051711</p>
			<p>邮箱：35353051711@qq.com</p>
		</div>
		<div class="bdsharebuttonbox bdshare-button-style1-32"
			data-bd-bind="1527750390322">
			<a href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"
				class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a
				href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"
				class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a
				href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"
				class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a
				href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"
				class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a
				href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"
				class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a
				href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#"
				class="bds_more" data-cmd="more"></a>
		</div>
		<div class="tj_news">
			<h2>
				<p class="tj_t1">最新文章</p>
			</h2>
			<ul>
                <%
                      //获取对应页数的数据
                      List<Article>   articlesNew=(List<Article>)request.getAttribute("articlesNew");
                      Iterator<Article>    iterator2=articlesNew.iterator();
                      while(iterator2.hasNext()){
                    	    Article   article=iterator2.next();//获取一篇文章
                    
                 %>
							<li>
							   <a href="../article/article_detail?id=<%=article.getId()%>">
							         <%=article.getTitle() %>
							   </a>
							</li>
		  
		       <%     } %>
			</ul>
			<h2>
				<p class="tj_t2">推荐文章</p>
			</h2>
			<ul>
                 <%
                      //获取对应页数的数据
                      List<Article>   articlesRecommend=(List<Article>)request.getAttribute("articlesRecommend");
                      Iterator<Article>    iterator3=articlesRecommend.iterator();
                      while(iterator3.hasNext()){
                    	    Article   article=iterator3.next();//获取一篇文章
                    
                 %>
				            <li>
							   <a href="../article/article_detail?id=<%=article.getId()%>">
							         <%=article.getTitle() %>
							   </a>
							</li>
  				<%     } %>
			</ul>
		</div>
		<div class="links">
			<h2>
				<p>友情链接</p>
			</h2>
			<ul>
				<li><a href="http://blog_hao.jd-app.com/index/index">个人博客</a></li>
				<li><a href="http://user.qzone.qq.com/657682342618">QQ空间</a></li>
			</ul>
		</div>

		<div class="copyright">
			<ul>
				<p>
					Design by <a
						href="http://localhost:8080/BlogJSPServlet2/index/index?page=1#">jim</a>
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