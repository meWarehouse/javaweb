<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4> download.jap </h4>
	
	
	<c:if test="${requestScope.fileList != null  }">
		<form action="" method="post">
		
			<table border="1" cellpadding="10" cellspacing="0">
				<tr>
					<th>文件名</th>
					<th>下载</th>
				</tr>
				<c:forEach items="${requestScope.fileList }" var="file">
					<tr>
						<td>${file.fileName }</td>
						<td>
							<!-- 
								实际路径： 可以通过ServletContext 的 getRealPath 获取
								虚拟路径：localhost:8080\xxx
								
								下载路径为实际路径
							
							<a href="upload1/${file.fileName }"> 点击下载 </a>
							 -->
							 <a href="downloadServletq?fileId=${file.fileId }"> 点击下载 </a>
						</td>
					</tr>
				</c:forEach>
			
			</table>
		
		</form>
		
	</c:if>
	

</body>
</html>