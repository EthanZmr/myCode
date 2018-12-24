/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.91
 * Generated at: 2018-12-22 12:18:33 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class province_005fcity_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<title>Insert title here</title>\n");
      out.write("</head>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("\t/*\n");
      out.write("\t\t1.在文档加载完毕时发送请求，得到所有省份元素，显示在<select name=\"province\"/>中\n");
      out.write("\t\t2.在选择了新的省份时，发送请求（参数为省名称），得到xml文档，即<province>元素\n");
      out.write("\t\t  解析xml文档，得到其中所有的<city>，再得到每个<city>元素的内容，即市名，使用市名生成<option>，插入到<select name=\"city\">元素中\n");
      out.write("\t*/\n");
      out.write("\twindow.onload = function(){\n");
      out.write("\t\tvar xmlHttp = createXmlHttpRequest();\n");
      out.write("\t\txmlHttp.open(\"GET\",\"/ajax/ProvinceServlet\",true);\n");
      out.write("\t\txmlHttp.send(null);\n");
      out.write("\t\txmlHttp.onreadystatechange = function(){\n");
      out.write("\t\t\t//获取服务器响应\n");
      out.write("\t\t\tif(xmlHttp.readyState == 4 && xmlHttp.status == 200){\n");
      out.write("\t\t\t\tvar text = xmlHttp.responseText;\n");
      out.write("\t\t\t\tvar arr = text.split(\",\");\n");
      out.write("\t\t\t\t//循环遍历每个省份名称，每个名称生成一个option对象，添加到<select>中\n");
      out.write("\t\t\t\tfor (var i = 0; i < arr.length; i++) {\n");
      out.write("\t\t\t\t\tvar op = document.createElement(\"option\");\n");
      out.write("\t\t\t\t\top.value = arr[i]; //设置op实际值\n");
      out.write("\t\t\t\t\tvar textNode = document.createTextNode(arr[i]); //创建文本节点\n");
      out.write("\t\t\t\t\top.appendChild(textNode);//把文本字节点添加到元素中\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"pro\").appendChild(op);\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t};\n");
      out.write("\t\t\n");
      out.write("\t\t//给<select name=\"province\">添加改变监听器，使用选择的省份名称请求CityServlet，得到<province>元素(xml元素)!!!\n");
      out.write("\t\t//获取<province>元素中所有的<city>元素，遍历，获取每个<city>的文本内容，即市名称\n");
      out.write("\t\t//使用每个市名称创建<option>元素添加到<select name=\"city\">中\n");
      out.write("\t\tvar proSelect = document.getElementById(\"pro\");\n");
      out.write("\t\tproSelect.onchange = function(){\n");
      out.write("\t\t\tvar xmlHttp = createXmlHttpRequest();\n");
      out.write("\t\t\txmlHttp.open(\"POST\",\"/ajax/CityServlet\",true);\n");
      out.write("\t\t\txmlHttp.setRequestHeader(\"Content-Type\", \"application/x-www-form-urlencoded\");\n");
      out.write("\t\t\txmlHttp.send(\"pname=\" + proSelect.value); //把下拉列表中选择的值发送给服务器\n");
      out.write("\t\t\txmlHttp.onreadystatechange = function(){\n");
      out.write("\t\t\t\tif(xmlHttp.readyState == 4 && xmlHttp.status == 200){\n");
      out.write("\t\t\t\t\t/*\n");
      out.write("\t\t\t\t\t\t把select中的option移除（除了请选择）\n");
      out.write("\t\t\t\t\t*/\n");
      out.write("\t\t\t\t\tvar citySel = document.getElementById(\"city\");\n");
      out.write("\t\t\t\t\tvar optionList = citySel.getElementsByTagName(\"option\");\n");
      out.write("\t\t\t\t\twhile(optionList.length > 1){\n");
      out.write("\t\t\t\t\t\t//总是删除下标为1的元素，因为1删除了 下标2就变成下标1了\n");
      out.write("\t\t\t\t\t\tcitySel.removeChild(optionList[1]);\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t\tvar doc = xmlHttp.responseXML;\n");
      out.write("\t\t\t\t\t//得到所有名为city的元素\n");
      out.write("\t\t\t\t\tvar cityElementList = doc.getElementsByTagName(\"city\");\n");
      out.write("\t\t\t\t\t//循环遍历每个city元素\n");
      out.write("\t\t\t\t\tfor (var i = 0; i < cityElementList.length; i++) {\n");
      out.write("\t\t\t\t\t\tvar cityEle = cityElementList[i];//得到每个city元素\n");
      out.write("\t\t\t\t\t\tvar cityName;\n");
      out.write("\t\t\t\t\t\t//处理浏览器差异\n");
      out.write("\t\t\t\t\t\tif(window.addEventListener){ //\n");
      out.write("\t\t\t\t\t\t\tcityName = cityEle.textContent;\n");
      out.write("\t\t\t\t\t\t} else {\n");
      out.write("\t\t\t\t\t\t\tcityName = cityEle.text;\n");
      out.write("\t\t\t\t\t\t}\n");
      out.write("\t\t\t\t\t\t//使用市名称创建option元素 添加到select\n");
      out.write("\t\t\t\t\t\tvar op = document.createElement(\"option\");\n");
      out.write("\t\t\t\t\t\top.value = cityName;\n");
      out.write("\t\t\t\t\t\t//创建文本节点\n");
      out.write("\t\t\t\t\t\tvar textNode = document.createTextNode(cityName);\n");
      out.write("\t\t\t\t\t\t//把文本节点追加到op元素中\n");
      out.write("\t\t\t\t\t\top.appendChild(textNode);\n");
      out.write("\t\t\t\t\t\t//把op添加到select元素中\n");
      out.write("\t\t\t\t\t\tcitySel.appendChild(op);\n");
      out.write("\t\t\t\t\t}\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("   function createXmlHttpRequest(){\n");
      out.write("\t\ttry {\n");
      out.write("\t\t\treturn new XMLHttpRequest();\n");
      out.write("\t\t} catch (e) {\n");
      out.write("\t\t\ttry {\n");
      out.write("\t\t\t\treturn new ActiveXObject(\"Msxml2.XMLHTTP\");\n");
      out.write("\t\t\t} catch (e) {\n");
      out.write("\t\t\t\ttry {\n");
      out.write("\t\t\t\t\treturn new ActiveXObject(\"Microsoft.XMLHTTP\");\n");
      out.write("\t\t\t\t} catch (e) {\n");
      out.write("\t\t\t\t\tthrow e;\n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t}\n");
      out.write("\t\t}\n");
      out.write("\t}\n");
      out.write("</script>\n");
      out.write("<body>\n");
      out.write("\t<h1>省市联动</h1>\n");
      out.write("\t<select name=\"province\" id=\"pro\">\n");
      out.write("\t\t<option>===请选择省===</option>\n");
      out.write("\t</select>\n");
      out.write("\t<select name=\"city\" id=\"city\">\n");
      out.write("\t\t<option>===请选择市===</option>\n");
      out.write("\t</select>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}