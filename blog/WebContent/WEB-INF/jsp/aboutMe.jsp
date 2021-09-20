<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page language="java" import="com.blog.bean.*"  %>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>个人博客——关于我</title>
<meta name="keywords" content="个人博客模板,博客模板,响应式">
<meta name="description" content="如影随形主题的个人博客模板，神秘、俏皮。">
<link href="../include/css/base.css" rel="stylesheet">
<link href="../include/css/about.css" rel="stylesheet">
<link href="../include/css/media.css" rel="stylesheet">
<meta name="viewport"  	content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
<!--[if lt IE 9]>
		<script src="../include/js/modernizr.js"></script>
		<![endif]-->
<script src="../include/css/share.js"></script>
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
			    <a href="../about/about" id="topnav_current">关于我</a>
			    <a href="../article/article">慢生活</a> 
			    <a href="../album/album" >我的相册</a> 
			    <a href="../critique/critique"   >留言板</a> 
	        </nav> 
		</header>
		<article>
		<h3 class="about_h">
			您现在的位置是：<a href="../index/index">首页</a><a
				href="../about/about">关于我</a>
		</h3>
		<div class="about">
			<h2>Just about me</h2>
			<ul>

				<p>
					${me.content}
				</p>


			</ul>
			<h2>About my blog</h2>
			<ul class="blog_a">
				<p>域 名：www.jim.tk</p>
				<p>服务器：京东云</p>
				<p>程 序：原创程序</p>
				<p>微信公众号:Jim</p>
			</ul>
		</div>
		</article>
		<aside>

		<div class="avatar">
			<a href="../about/about#"><span>关于Jim</span></a>
		</div>
		<div class="topspaceinfo">
			<h1>执子之手，与子偕老</h1>
			<p>于千万人之中，我遇见了我所遇见的人....</p>
		</div>
		<div class="about_c">
			<p>网名：jim</p>
			<p>职业：Java程序员</p>
			<p>籍贯：江西-鹰潭</p>
			<p>QQ：3535305171</p>
			<p>邮箱：3535305171@qq.com</p>
		</div>
		<div class="bdsharebuttonbox bdshare-button-style1-32"
			data-bd-bind="1527750586617">
			<a href="../about/about#"
				class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a
				href="../about/about#"
				class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a
				href="../about/about#"
				class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a
				href="../about/about#"
				class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a
				href="../about/about#"
				class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a
				href="../about/about#"
				class="bds_more" data-cmd="more"></a>
		</div>


		</aside>
		<script src="../include/css/silder.js"></script>
		<div class="clear"></div>
		<!-- 清除浮动 -->
	</div>
</body>
</html>