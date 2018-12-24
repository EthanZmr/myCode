<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	/*
		1.在文档加载完毕时发送请求，得到所有省份元素，显示在<select name="province"/>中
		2.在选择了新的省份时，发送请求（参数为省名称），得到xml文档，即<province>元素
		  解析xml文档，得到其中所有的<city>，再得到每个<city>元素的内容，即市名，使用市名生成<option>，插入到<select name="city">元素中
	*/
	window.onload = function(){
		var xmlHttp = createXmlHttpRequest();
		xmlHttp.open("GET","/ajax/ProvinceServlet",true);
		xmlHttp.send(null);
		xmlHttp.onreadystatechange = function(){
			//获取服务器响应
			if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
				var text = xmlHttp.responseText;
				var arr = text.split(",");
				//循环遍历每个省份名称，每个名称生成一个option对象，添加到<select>中
				for (var i = 0; i < arr.length; i++) {
					var op = document.createElement("option");
					op.value = arr[i]; //设置op实际值
					var textNode = document.createTextNode(arr[i]); //创建文本节点
					op.appendChild(textNode);//把文本字节点添加到元素中
					document.getElementById("pro").appendChild(op);
				}
			}
		};
		
		//给<select name="province">添加改变监听器，使用选择的省份名称请求CityServlet，得到<province>元素(xml元素)!!!
		//获取<province>元素中所有的<city>元素，遍历，获取每个<city>的文本内容，即市名称
		//使用每个市名称创建<option>元素添加到<select name="city">中
		var proSelect = document.getElementById("pro");
		proSelect.onchange = function(){
			var xmlHttp = createXmlHttpRequest();
			xmlHttp.open("POST","/ajax/CityServlet",true);
			xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xmlHttp.send("pname=" + proSelect.value); //把下拉列表中选择的值发送给服务器
			xmlHttp.onreadystatechange = function(){
				if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
					/*
						把select中的option移除（除了请选择）
					*/
					var citySel = document.getElementById("city");
					var optionList = citySel.getElementsByTagName("option");
					while(optionList.length > 1){
						//总是删除下标为1的元素，因为1删除了 下标2就变成下标1了
						citySel.removeChild(optionList[1]);
					}
					
					var doc = xmlHttp.responseXML;
					//得到所有名为city的元素
					var cityElementList = doc.getElementsByTagName("city");
					//循环遍历每个city元素
					for (var i = 0; i < cityElementList.length; i++) {
						var cityEle = cityElementList[i];//得到每个city元素
						var cityName;
						//处理浏览器差异
						if(window.addEventListener){ //
							cityName = cityEle.textContent;
						} else {
							cityName = cityEle.text;
						}
						//使用市名称创建option元素 添加到select
						var op = document.createElement("option");
						op.value = cityName;
						//创建文本节点
						var textNode = document.createTextNode(cityName);
						//把文本节点追加到op元素中
						op.appendChild(textNode);
						//把op添加到select元素中
						citySel.appendChild(op);
					}
				}
			}
		}
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
	<h1>省市联动</h1>
	<select name="province" id="pro">
		<option>===请选择省===</option>
	</select>
	<select name="city" id="city">
		<option>===请选择市===</option>
	</select>
</body>
</html>