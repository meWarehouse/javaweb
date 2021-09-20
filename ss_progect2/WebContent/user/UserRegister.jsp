<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript" src="${path}/js/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/js/jquery-ui.min.css"  /> 
<script type="text/javascript" src="${path}/js/jquery-ui.min.js"></script>
<script type="text/javascript">

	function checkForm(){
		
		var userName = $("#userName").val();
		if(userName == null || userName.trim() == ""){
			alert("用户名不能为空");
			return false;
		}
		
		var userPassword = $("#userPassword").val();
		if(userPassword == null || userPassword.trim() == ""){
			alert("密码不能为空");
			return false;
		}
		
		
		
		var userRePassword = $("#userRePassword").val();
		if(userRePassword == null || userRePassword.trim() == ""){
			alert("确密码不能为空");
			return false;
		}
		

		if(userPassword != userRePassword){
			alert("两次输入的密码不一致");
			return false;
		}
		
		// is(":checked") 如果选中返回 true 否则返回 false
		
		var userNan = $("#userNan").is(":checked");
		var userNv = $("#userNv").is(":checked");
		if(userNan == false && userNv == false){
			alert("性别不能为空");
			return false;
		}
		
		var userBrithday = $("#userBrithday").val();
		
		alert("birthday:"+userBrithday);
		
		if(userBrithday == null || userBrithday.trim() == ""){
			alert("生日不能为空");
			return false;
		} 
		
		var userGender = null;
		if(userNan){
			userGender = '男';
		}else{
			userGender = '女';
		}
		
		
		//ajax 请求提交表达数据
		$.post("${pageContext.servletContext.contextPath }/userRegisterServlet",{
			username:userName,
			userpassword:userPassword,
			usergender:userGender,
			userbrithday:userBrithday,
			},function(data,status){
					
			if(data.msg == "ok"){
				alert("注册成功");
			}else{
				alert("注册失败");
			}
				
		},"json")
		
		
		
	}
	
	$(function(){
		/*$("#userBrithday").datepicker(); */
		 $("#userBrithday").datepicker({dateFormat:"yy-mm-dd"});
		
		
		
		
	});


	

</script>


</head>
<body>

	${path }

	<h4>用户注册</h4>
	
	<!-- onsubmi 是表单提交是执行的方法  onsubmith方法中的返回值为false则不会提交   ${pageContext.servletContext.contextPath }-->
	<%-- <form action="${pageContext.servletContext.contextPath }/userRegisterServlet" method="post" onsubmit="return checkForm()" > --%>
	<form onsubmit="return checkForm()" >
		用户名：<input type="text" id="userName" name="userName" value="${param.userName}"/>
		<br>
		密码：<input type="password" id="userPassword" name="userPassword" />
		<br>
		确认密码：<input type="password" id="userRePassword" name="userRePassword" />
		<br>
		性别：<input type="radio" id="userNan" name="userGender" value="男" />男,
			<input type="radio" id="userNv" name="userGender" value="女" />女
		<br>
		生日：<input type="text" id="userBrithday" name="userBrithday" value="${param.userBrithday}"  />
		<br>
		<input type="submit" value="提交" />
	</form>
	
	<c:if test="${requestScope.user != null }">
		${requestScope.user}
	</c:if>
	

</body>
</html>