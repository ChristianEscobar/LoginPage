<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<form action="login" method="post">
		User Name:  <input type="text" name="userName"/> <br/>
		Password:  <input type="password" name="password"/> <br />
		<input type="submit"/>
	</form>
	<a href="${pageContext.request.contextPath}/register.jsp">Click here to register...</a>
</body>
</html>