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
		response.addCookie(new Cookie("username","zhangsan"));
		response.addCookie(new Cookie("password","123456"));
	%>
</body>
</html>