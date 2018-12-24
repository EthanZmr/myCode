<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	window.onload = function(){
		//在文档加载完成之后马上执行
		//得到btn元素
		var btn = document.getElementById("btn");
		btn.onclick = function(){
			var h1 = document.getElementById("h1");
			h1.innerHTML = "Hello Js";
		}
	}
</script>
<body>
	<button id="btn">点这里</button>
	
	<h1 id=h1></h1>
</body>
</html>