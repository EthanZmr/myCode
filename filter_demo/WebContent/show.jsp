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
<h1 align="center">显示结果</h1>
<table align="center" width="60%" border="1">
	<tr>
		<th>ip</th>
		<th>次数</th>
	</tr>
	<c:forEach items="${applicationScope.map }" var="entry">
	<tr>
		<td>${entry.key }</td>
		<td>${entry.value }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>