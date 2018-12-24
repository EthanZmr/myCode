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
		//var person = {"name":"zhangsan","age":18,"sex":"male"};
		//console.log(person.name + "," + person.age);
		
		var btn = document.getElementById("btn");
		btn.onclick = function(){
			var xmlHttp = createXmlHttpRequest();
			xmlHttp.open("GET","/ajax/JsonServlet",true);
			xmlHttp.send(null);
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					var json_ = xmlHttp.responseText;
					var person = eval("(" + json_ + ")");
					var str = person.name + "," + person.age + "," + person.sex;
					document.getElementById("h3").innerHTML = str;
				}
			}
		};
	}
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
	<h1>json的应用</h1><br>
	<button id="btn">点击这里</button><br>
	<h3 id="h3"></h3>
</body>
</html>