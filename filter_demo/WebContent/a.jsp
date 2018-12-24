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
<h1>你就是个傻逼</h1>
<a href="<c:url value='/a.jsp'/>">游客入口</a>
<a href="<c:url value='/users/u.jsp'/>">会员入口</a>
<a href="<c:url value='/admin/a.jsp'/>">管理员入口</a>
</body>
</html>