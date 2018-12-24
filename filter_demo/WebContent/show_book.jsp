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
	<h1 align="center">图书列表</h1>
	<table align="center" width="60%" border="1">
		<tr>
			<th>图书名称</th>
			<th>单价</th>
			<th>分类</th>
		</tr>
		<c:forEach items="${bookList }" var="book">
		<tr>
			<td>${book.bname }</td>
			<td>${book.price }</td>
			<td>${book.category }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>