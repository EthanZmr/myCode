<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	window.onload = function(){ //文档加载完毕后执行
		var btn = document.getElementById("btn");
		
		
		btn.onclick = function(){
			
			var xmlHttp = createXmlHttpRequest();
			
			xmlHttp.open("POST","/ajax/AjaxServlet",true);
			
			xmlHttp.setRequestHeader("content-Type", "application/x-www-form-urlencoded");
			
			xmlHttp.send("username=张三&&password=123");
			
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					var content = xmlHttp.responseText;
					var h1 = document.getElementById("h1");
					h1.innerHTML = content;
				}
			}
		};
	};
	
	function createXmlHttpRequest(){
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					return new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					throw e;
				}
			}
		}
	}
</script>
<body>
	<button id="btn">点这里</button>
	
	<h1 id=h1></h1>
</body>
</html>