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
   
 <p> 编辑主页文字:<br></p>
   <form action="introduction_editCommit" method="post" role="form">
   <label>正文内容：</label>
<s:textarea name="introduction.content" class="form-control" rows="3"></s:textarea><br>


   <input type="submit" value="提交" class="btn btn-default"/>
   </form>
   
      <s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
