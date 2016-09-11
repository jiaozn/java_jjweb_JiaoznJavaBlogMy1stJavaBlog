<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>
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
   
Personal introduction shows here:<br>
  1.PersonalIntroduction对象是否拿到： <s:property value="personalIntroduction"/><br>
 <hr>
   2.自我介绍：<s:property value="#request.personalIntroductionContent.content" /><br>
   <hr>
   3.更新时间：<s:property value="#request.personalIntroductionContent.date"/><br>
   4.<s:debug></s:debug>
   <a href="service_personalIntroduction!edit" >编辑</a>
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
