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
   <jsp:include page="main_head.jsp"></jsp:include><%--
   
study_c .jsp   

<form name="uploadForm" method="POST"  
    enctype="MULTIPART/FORM-DATA"  
    action="upload">  
    <table>  
      <tr>  
       <td><div align="right">User Name:</div></td>  
       <td><input type="text" name="username" size="30"/> </td>  
      </tr>  
      <tr>  
       <td><div align="right">Upload File1:</div></td>  
       <td><input type="file" name="file1" size="30"/> </td>  
      </tr>  
      <tr>  
        <td><div align="right">Upload File2:</div></td>  
        <td><input type="file" name="file2" size="30"/> </td>  
      </tr>  
      <tr>  
        <td><input type="submit" name="submit" value="upload"></td>  
        <td><input type="reset" name="reset" value="reset"></td>  
      </tr>  
    </table>  
  </form>  
   --%>
   
   <form action="upload" method="post" enctype="multipart/form-data" role="form">  
   <div class="form-group">
标题：<input class="form-control" type="text" name="title">  </div>
<div class="form-group">
文件（目前仅支持mp4格式，英文文件名）：<input type="file" name="File">  </div>
<br>  
<div class="form-group">
<input type="submit" value="上传" class="btn btn-default">  </div>
</form>  
   
   
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
