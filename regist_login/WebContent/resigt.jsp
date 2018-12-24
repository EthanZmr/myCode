<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>注册</h1>
	<h2>${message }</h2>
	<form action="${pageContext.request.contextPath }/RegistServlet" method="post">
		用户名:<input type="text" name="username"/>
		密码:<input type="password" name="password"/>
		<input type="submit" value="注册"/>
	</form>
</body>
</html>