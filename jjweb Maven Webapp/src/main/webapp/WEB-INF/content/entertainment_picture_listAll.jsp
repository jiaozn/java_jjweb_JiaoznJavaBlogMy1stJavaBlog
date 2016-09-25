<%@ page language="java" import="java.util.*,com.jjweb.model.UploadFileDTO" pageEncoding="UTF-8"%>
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
   
entertainment_picture_listAll.jsp<br>
<h2>文件列表-路径：</h2>
<h4><s:property value="savePath"/></h4>
<hr>
<table class="table">
<tr><th>文件名</th>
<th>大小</th>
<th>操作</th></tr>
		
	<s:iterator value="uploadFileDTOs" id="dto">
		
		<tr><td><s:property value="#dto.fileName"/></td>
		<td><s:property value="#dto.size"/></td>
		<td><a href="upload!downLoad?fileStr=<s:property value="#dto.file"/>">下载   </a>
		<a href="upload!delete?fileStr=<s:property value="#dto.file"/>">删除   </a></td></tr>
	</s:iterator>
	</table>
	<s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
