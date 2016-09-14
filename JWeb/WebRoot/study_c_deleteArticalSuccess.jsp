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
   
study_c_deleteArticalSuccess.jsp<br>
删除成功！文章列表：
<hr>
<table border="1" align="center">
<tr><td>文章id</td>
		<td>作者</td>
		<td>题目 </td>
		<td>日期</td>
		<td>分类</td>
		<td>操作</td></tr>
		
	<s:iterator value="#request.list_Artical" id="art">
		
		<tr><td><s:property value="#art.id"/></td>
		<td><s:property value="#art.author"/></td>
		<td><s:property value="#art.title"/></td>
		<td><s:property value="#art.date"/></td>
		<td><s:property value="#art.category.name"/></td>
		<td><a href="artical!listArticalById?artical_id=<s:property value="#art.id"/>">查看   </a>
		<a href="artical!editArtical?artical_id=<s:property value="#art.id"/>">修改   </a>
		<a href="artical!delete?artical.id=<s:property value="#art.id"/>">删除   </a></td></tr>
	</s:iterator>
	</table>
	<s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
