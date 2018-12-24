<%@page import="cn.ethan.demo.Person"%>
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
		pageContext.setAttribute("p1", new Person("zhangsan",23,"male"));
	%>
	${pageScope.p1.name }<br>
	${pageScope.p1.age }<br>
	${pageScope.p1.sex }<br>
</body>
</html>