<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>客户列表</h1>
	 <c:forEach items="${list }" var="customer">
		<ul>
			<li>${customer.custName }</li>
			<li>${customer.custLevel }</li>
			<li>${customer.custSource }</li>
			<li>${customer.custPhone }</li>
			<li>${customer.custMobile }</li>
		</ul>
	</c:forEach>
	<s:iterator value="list" var="customer">
		<s:property value="#customer.custName"/>
		<s:property value="#customer.custLevel"/>
		<s:property value="#customer.custSource"/>
		<s:property value="#customer.custPhone"/>
		<s:property value="#customer.custMobile"/>
		<br>
	</s:iterator>
	<br>
	<s:iterator value="list">
		<s:property value="custName"/>
		<s:property value="custLevel"/>
		<s:property value="custSource"/>
		<s:property value="custPhone"/>
		<s:property value="custMobile"/>
		<br>
	</s:iterator>
</body>
</html>