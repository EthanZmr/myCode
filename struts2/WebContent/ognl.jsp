<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 使用ognl+struts2标签实现计算字符串长度 
		value:ognl表达式
	-->
	<%-- <s:property value="'alsdjfasjf'.length()"/> --%>
	<!-- 获取值栈中对象的值 -->
	<s:property value="user.username"/>
	<s:property value="user.password"/>
	<s:property value="user.address"/>
	
	<!-- 获取值栈中list集合数据 -->
	<s:property value="list[0].username"/>
	<s:property value="list[0].password"/>
	<s:property value="list[0].address"/>
	<br>
	<s:property value="list[1].username"/>
	<s:property value="list[1].password"/>
	<s:property value="list[1].address"/>
	<br>
	<!-- 第二种方式获取list集合 -->
	<s:iterator value="list">
		<!-- 遍历list -->
		<s:property value="username"/>
		<s:property value="password"/>
		<s:property value="address"/>
		<br>
	</s:iterator>
	
	<!-- 第三种方式 -->
	<s:iterator value="list" var="user">
		<!-- 遍历值栈集合，得到每个user对象
			机制：把每次遍历出来的user对象放到context里面
			获取context里面数据特点：写ognl表达式 使用特殊符号# -->
		<s:property value="#user.username"/>
		<s:property value="#user.password"/>
		<s:property value="#user.address"/>
	</s:iterator>
	
	<!-- 获取push方法设置的值 -->
	<s:property value="[0].top"/>
</body>
</html>