<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="com.blog.bean.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
   <head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>个人博客——慢生活</title>
		<meta name="keywords" content="个人博客,博客,响应式">
		<meta name="description" content="如影随形主题的个人博客，神秘、俏皮。">
		<link href="../include/css/base.css" rel="stylesheet">
		<link href="../include/css/style.css" rel="stylesheet">
		<link href="../include/css/media.css" rel="stylesheet">
		<meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0">
		<!--[if lt IE 9]>
		<script src="include/js/modernizr.js"></script>
		<![endif]-->
	    <script src="../include/css/share.js"></script><link rel="stylesheet" href="../include/css/share_style1_32.css">
  </head>
  
  <body>
     <div class="ibody">
     <header>    
		    <h1>提拉米苏.甜腻的苦涩</h1>
		    <h2>做好的提拉米苏被遗忘在角落 我的手再也挽留不住你离去的脚步 爱情是甜蜜的苦涩,无奈的别离 苦涩的怕不是味道,而是心绪</h2>
		    <div class="logo"><a href="../index/index"></a></div>
            <nav id="topnav"> 
		        <a href="../index/index">首页</a>
			    <a href="../about/about">关于我</a>
			    <a href="../article/article"  id="topnav_current">慢生活</a> 
			    <a href="../album/album" >我的相册</a> 
			    <a href="../critique/critique"   >留言板</a> 
	        </nav> 
     </header>
  	<article>
	    <h2 class="about_h">您现在的位置是：
	         <a href="../index/index">首页</a>
	         <a href="../article/article">慢生活</a>
	    </h2>
	    <div class="bloglist">
	       <!-- ??????????????????????????这是遍历文章？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？？ -->
	        <%
			            List<Article>   articlesPage=(List<Article>)request.getAttribute("articlesPage");
			            Iterator<Article>    iterator=articlesPage.iterator();
			            while(iterator.hasNext()){
			            	      Article  article=iterator.next();
	        %>   
		      <div class="newblog">
		        <ul>
		          <h3><a href="../article/article_detail?id=<%=article.getId()%>"><%=article.getTitle()%></a></h3>
		          <div class="autor">
		                  <span>作者：<a><%=article.getEditer()%></a></span>
		                  <span>分类：[<a href="http://localhost:8080/"><%=article.getType()%></a>]</span>
		                  <span>浏览（<a href="http://localhost:8080/"><%=article.getCount()%></a>）</span>
		                  <span>评论（<a href="http://localhost:8080/"><%=article.getCount1()%></a>）</span>
		          <span>
		          </span></div>
		          <div class="content" style="width:100%">
		                        <%=article.getContent()%>    
		          </div>
		          <a href="../article/article_detail?id=<%=article.getId()%>" class="readmore" style="display:inline-block;">全文</a>
		        </ul>
		        <figure><img src="<%=article.getImage()%>" width="200" height="100"></figure>
		        <div class="dateview"><%=article.getTime()%></div>
		      </div>
		   <%           } %>
      </div>
		 
	  <!-- ？？？？？？？？？？？？？？？？这是页数？？？？？？？？？？？？？？？？？？？？？ -->	 
			  <div class="page">
			       <%
			               /*
			                    //获取当前的页数
			                    int   page1=(Integer)request.getAttribute("page");
			                    //获取总共的页数
			                    int   totalPage=(Integer)request.getAttribute("totalPage");
			                    request.setAttribute("page", page1);   */
			       %>
			       
			       <!-- 如果页数是1，< 它就不需要跳转     如果页数大于1   <它就需要-1跳转      &lt;：代表<-->
			       <c:if test="${page==1 }"  var="result">
			                   <a href="#">&lt;</a>
			       </c:if>    
			       <c:if test="${!result }">
			             <a href="../article/article?page=${page-1}">&lt;</a>
			       </c:if>
			       
			       
			       <!-- 遍历1，2，3，4，5....     
			                          如果说是当前的页数，字体变黑而且不需要跳转       
			                           如果不是当前页，那么就需要跳转 -->
			        
			       <c:forEach   var="p"   begin="1"  end="${totalPage }">
			                     <c:if test="${page==p }"  var="result1">
			                               <b>${p}</b>
			                     </c:if>
			                     <c:if test="${!result1 }">
			                         <a href="../article/article?page=${p}">${p }</a>
			                     </c:if>
			       </c:forEach> 
			       
			       <!--&gt;：代表> 
			                           如果说是最后一页，就不需要跳转；
			                           如果说不是最后一页，那么跳转的时候我们就需要+1.
			         -->
			       <c:if test="${page==totalPage }"  var="result">
			               <a href="#">&gt;</a>
			       </c:if>    
			       <c:if test="${!result }">
			             <a href="../index/index?page=${page+1}">&gt;</a>
			       </c:if>
			  </div>               
  </article>
  <aside>
    <div class="rnav">
      <li class="rnav1 "><a href="../article/article">日记</a></li>
      <li class="rnav2 "><a href="../article/article">欣赏</a></li>
      <li class="rnav3 "><a href="../article/article">程序人生</a></li>
      <li class="rnav4 "><a href="../article/article">经典语录</a></li>
    </div>
    <div class="ph_news">
      <h2>
        <p>点击排行</p>
      </h2>
      <ul class="ph_n">
      <!-- ?????????????????????点击排行???????????????????????????????????? -->
      <%
                  int num=1;
       
                  List<Article>     articlesHot=(List<Article>)request.getAttribute("articlesHot");
			      Iterator<Article>    iterator1=articlesHot.iterator();
			     
			      while(iterator1.hasNext()){
			      	      Article  article=iterator1.next();
			      	      request.setAttribute("num1", num);
      %>
			      		<li>
			      		   <c:if test="${num1<4 }"  var="result4">
			      		       <span class="num1">
				      		      <%=num %>
				      		    </span>
			      		   </c:if>
			      		   <c:if test="${!result4 }">
			      		         <span>
				      		            <%=num %>
				      		    </span>
			      		   </c:if>
			      		   <a href="../article/article_detail?id=<%=article.getId()%>">
			      		           <%=article.getTitle() %>
			      		   </a>
			      		</li>
     <%      num++;     } %> 		
			      		
			      		
      </ul>
      
      
      <h2>
        <p>栏目推荐</p>
      </h2>
      <ul>
        <!-- ??????????????栏目推荐????????????????????????????????????? -->   
         <%
                  List<Article>     articlesRecommend=(List<Article>)request.getAttribute("articlesRecommend");
			      Iterator<Article>    iterator2=articlesRecommend.iterator();
			     
			      while(iterator2.hasNext()){
			      	      Article  article=iterator2.next();
        %>
                <li>
                    <a href="../article/article_detail?id=<%=article.getId()%>">
                         <%=article.getTitle() %>
                    </a>
                </li>
        <%        } %>
      </ul>
      
      
      
      <h2>
        <p>最新评论</p>
      </h2>
      <ul class="pl_n">
		        <!-- ???????????????????最新评论?????????????????????? -->  
		         <%
                  List<Critique>     critiquesNew=(List<Critique>)request.getAttribute("critiquesNew");
			      Iterator<Critique>    iterator3=critiquesNew.iterator();
			      while(iterator3.hasNext()){
			    	     Critique  critique=iterator3.next();
                %>
		        <dl>
		          <dt><img src="../include/images/s8.jpg"> </dt>
		          <dt> </dt>
		          <dd>
		            <%=critique.getName()%>
		            <time><%=critique.getTime()%></time>
		          </dd>
		          <dd>
		              <a href="../article/article"> 
		                 <%=critique.getContent()%>  
		                 <!--   <s:property value="content" escape="false"/>  -->
		              </a>
		         </dd>
		        </dl>
		       <%     } %> 
		       
      </ul>
    </div>
   
  <div class="copyright">
      <ul>
        <p> Design by <a href="../article/article">jim</a></p>
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
