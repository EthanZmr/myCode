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

function ajax(option){
	var xmlHttp = createXmlHttpRequest();
	if(!option.method){
		option.method = "GET";
	}
	if(option.asyn == undefined){
		option.asyn = true;
	}
	xmlHttp.open(option.method,option.url,option.asyn);
	if("POST" == option.method){
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	}
	xmlHttp.send(option.params);
	xmlHttp.onreadystatechange = function(){
		if(xmlHttp.readyState == 4 && xmlHttp.status == 200){
			//获取服务器的响应数据，进行转换
			if(!option.type){
				data = xmlHttp.responseText;
			}else if(option.type == "xml"){
				data = xmlHttp.responseXML;
			}else if(option.type == "text"){
				data = xmlHttp.responseText;
			}else if(option.type = "json"){
				var text = xmlHttp.responseText;
				data = eval("(" + text + ")");
			}
			//调用回调方法
			option.callback(data);
		}
	}
}