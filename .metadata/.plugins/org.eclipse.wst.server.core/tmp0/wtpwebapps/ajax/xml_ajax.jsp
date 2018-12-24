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
			
			xmlHttp.open("GET","/ajax/XMLServlet",true);
			
			xmlHttp.send(null);
			
			xmlHttp.onreadystatechange = function(){
				
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					console.log(xmlHttp.readyState)
					console.log(xmlHttp.status);
					//获取服务器响应结果（document）
					var doc = xmlHttp.responseXML;
					console.log(doc);
					var eleArr = doc.getElementsByTagName("student")[0];
					var number = eleArr.getAttribute("number");
					var name = eleArr.getElementsByTagName("name")[0].textContent;
					
					var text = number + "," + name;
					document.getElementById("h1").innerHTML = text;
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