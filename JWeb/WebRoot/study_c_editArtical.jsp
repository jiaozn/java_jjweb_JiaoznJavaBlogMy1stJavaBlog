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
   
study_c_editArtical.jsp
<form action="artical!updateArticalById">
<input type="hidden" name="artical.id" value="<s:property value="#request.artical.id"/>"/>
题目：<textarea name="artical.title"><s:property value="#request.artical.title"/></textarea><br>
作者：<textarea name="artical.author"><s:property value="#request.artical.author"/></textarea><br>
分类：<textarea name="artical.category.id"><s:property value="#request.artical.category.id"/></textarea><br>
<hr>
正文：<textarea name="artical.content"><s:property value="#request.artical.content"/></textarea><br>
<input type="submit"></form>
  <s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>

  </body>
</html>
