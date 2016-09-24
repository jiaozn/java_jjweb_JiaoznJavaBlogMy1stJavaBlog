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
   
study_c_listAll.jsp<br>
<h2>分类列表：</h2>
<hr>
<table class="table">
<tr><td>文件夹id</td>
		<td>文件夹名字</td>
		<td>操作</td></tr>
		
	<s:iterator value="listCategory" var="cat">
		
		<tr><td><s:property value="#cat.id"/></td>
		<td><s:property value="#cat.name"/></td>
		<td>
		<a href="category_edit?category.id=<s:property value="#cat.id"/>">修改   </a>
		<a href="category_delete?category.id=<s:property value="#cat.id"/>">删除   </a></td></tr>
	</s:iterator>
	</table>
	<a href="category_add">新增</a>
	
	<s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
