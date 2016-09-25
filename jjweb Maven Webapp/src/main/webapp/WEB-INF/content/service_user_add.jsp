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
     <!-- Make sure the path to CKEditor is correct. -->
        <script src="ckeditor/ckeditor.js"></script>
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
<form action="user_addCommit" name="userForm" method="post" role="form" >
<div class="form-group">
   <label>用户名：</label><input type="text" name="user.name" class="form-control"/>
   </div>
   <div class="form-group">
   <label>密码：</label><input type="text" name="user.password" class="form-control"/>
   </div>
   <div class="form-group">
   <label>年龄：</label><input type="text" name="user.age" class="form-control"/>
   </div>
   <div class="form-group">
   <label>性别：</label><input type="text" name="user.sex" class="form-control" value="1"/>
   </div>
   <div class="form-group">
   <label>邮箱：</label><input type="text" name="user.email" class="form-control"/>
   </div>
   <div class="form-group">
   <label>地址：</label><input type="text" name="user.address" class="form-control"/>
   </div>
   <div class="form-group">
   <label>QQ：</label><input type="text" name="user.qq" class="form-control"/>
   </div>
   
   <div class="form-group">
   <label>正文：</label>
   <textarea id="editor1" name="user.pintroduction" class="form-control" rows="3"></textarea>
   <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'editor1' );
            </script>
   </div>
   <input type="hidden" name="user.authority" value="3"/>
  
   <input type="submit" class="btn btn-default"/> 
   </form>
   <jsp:include page="main_foot.jsp"></jsp:include>
   <s:debug></s:debug>
  </body>
</html>
