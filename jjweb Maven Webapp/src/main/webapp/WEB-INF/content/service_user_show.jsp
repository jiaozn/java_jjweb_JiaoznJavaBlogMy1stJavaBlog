<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <!-- Make sure the path to CKEditor is correct. -->
        <script src="ckeditor/ckeditor.js"></script>
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
   
<h6>study_c .jsp</h6> 
用戶id:<s:property value="user.id"/><br>
   <label>用户名：</label><s:property value="user.name"/><br>
   <label>密码：</label><s:property value="user.password"/><br>
   <label>年龄：</label><s:property value="user.age"/><br>
   <label>性别：</label><s:property value="user.sex"/><br>
   <label>邮箱：</label><s:property value="user.email"/><br>
   <label>地址：</label><s:property value="user.address"/><br>
   <label>QQ：</label><s:property value="user.qq"/><br>
   <label>正文：</label><s:property value="user.pintroduction"/><br>
   <label>权限：</label><s:property value="user.authority"/><br>
  <a href="user_showAll">返回列表</a>
   <s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
