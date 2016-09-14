<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
   
study_c_updateArticalSuccess.jsp
更新成功！
文章id:<s:property value="#request.articalUpdated.id"></s:property><br>
题目：<s:property value="#request.articalUpdated.title"></s:property><br>
作者：<s:property value="#request.articalUpdated.author"></s:property><br>
日期：<s:property value="#request.articalUpdated.date"></s:property><br>
<hr>
正文：<s:property value="#request.articalUpdated.content"></s:property><br>
  <s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>

  </body>
</html>
