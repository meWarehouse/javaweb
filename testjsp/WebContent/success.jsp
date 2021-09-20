<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("roou") && password.equals("123456"))
        {
      	  //设置session属性username值为name
      	  session.setAttribute("name",username);
      	  //通过getAttribute（）方法获取会话的username属性值，即name的值
      	  String user=(String)session.getAttribute("name");
      	  out.print("欢迎:"+user);
        }
        else
        {
      	  out.print("<script type=\"text/javascript\"> alert('对不起，用户名或密码错误');history.go(-1);</script>");
        }
	%>

</body>
</html>