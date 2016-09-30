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
   
<h2>用户列表：</h2>
<hr>
<table class="table">
<tr><td>用户id</td>
		<td>用户名</td>
		<td>注册时间 </td>
		<td>操作</td></tr>
		
	<s:iterator value="listUser" var="art">
		
		<tr><td><s:property value="#art.id"/></td>
		<td><s:property value="#art.name"/></td>
		<td><s:property value="#art.time"/></td>
		<td><a href="user_show?user.id=<s:property value="#art.id"/>">查看   </a>
		<a href="user_adminEdit?user.id=<s:property value="#art.id"/>">修改   </a>
		<a href="user_delete?user.id=<s:property value="#art.id"/>">删除   </a></td></tr>
	</s:iterator>
	</table>
	<a href="user_add">新增</a>
	
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
