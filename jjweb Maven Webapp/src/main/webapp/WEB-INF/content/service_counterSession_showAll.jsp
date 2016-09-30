<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<title>Hello,world</title>
  </head>
  
  <body>
   <jsp:include page="main_head.jsp"></jsp:include>
   
<h2>访问记录：</h2>
<hr>
<table class="table">
<tr><td>记录id</td>
		<td>用户IP</td>
		<td>访问时间 </td>
		
	<s:iterator value="listCounterSession" var="art">
		
		<tr><td><s:property value="#art.id"/></td>
		<td><s:property value="#art.Ip"/></td>
		<td><s:property value="#art.time"/></td>
		</tr>
	</s:iterator>
	</table>
	
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
