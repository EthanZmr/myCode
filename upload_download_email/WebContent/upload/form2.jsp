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
	<h1>上传2</h1>
	<form action="<c:url value='/Upload2Servlet'/>" method="post" enctype="multipart/form-data">
		用户名：<input type="text" name="username"/>
		照片：<input type="file" name="picture"/>
		<input type="submit" value="上传"/>
	</form>
	
</body>
</html>