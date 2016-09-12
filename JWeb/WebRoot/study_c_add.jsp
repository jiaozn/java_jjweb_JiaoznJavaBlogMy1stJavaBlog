<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

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
   
study_c .jsp   
<form action="artical!executeAdd" name="artical" method="post" >
   标题：<input type="text" name="artical.title"/>
   正文：<textarea rows="5" cols="20" name="artical.content"></textarea>
   作者：<input type="text" name="artical.author"/>
   分类：<input type="text" name="category_id"/>
   <input type="submit"/> 
   </form>
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
