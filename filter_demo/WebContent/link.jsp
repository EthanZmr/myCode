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
<h1>链接页面</h1>
<a href="<c:url value='/bookServlet?method=findAll'/>">查询所有</a>
<a href="<c:url value='/bookServlet?method=findByCategory&category=1'/>">查询SE</a>
<a href="<c:url value='/bookServlet?method=findByCategory&category=2'/>">查询EE</a>
<a href="<c:url value='/bookServlet?method=findByCategory&category=3'/>">查询Framework</a>
</body>
</html>