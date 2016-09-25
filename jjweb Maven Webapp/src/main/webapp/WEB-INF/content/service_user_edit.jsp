<%@ page language="java" import="java.util.*,com.jjweb.model.User" pageEncoding="UTF-8"%>
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
<s:property value="user.id"/>
 <form action="user_editCommit" name="userForm" method="post" role="form" >
<div class="form-group">
<input type="hidden" value='<s:property value="user.id"/>' name="user.id"/>
   <label>用户名：</label><input type="text" name="user.name" class="form-control" value="<s:property value="user.name"/>"/>
   </div>
   <div class="form-group">
   <label>密码：</label><input type="text" name="user.password" class="form-control" value=${user.password}>
   </div>
   <div class="form-group">
   <label>年龄：</label><input type="text" name="user.age" class="form-control" value=${user.age}>
   </div>
   <div class="form-group">
   <label>性别：</label><input type="text" name="user.sex" class="form-control" value=${user.sex}>
   </div>
   <div class="form-group">
   <label>邮箱：</label><input type="text" name="user.email" class="form-control" value=${user.email}>
   </div>
   <div class="form-group">
   <label>地址：</label><input type="text" name="user.address" class="form-control" value=${user.address}>
   </div>
   <div class="form-group">
   <label>QQ：</label><input type="text" name="user.qq" class="form-control" value=${user.qq}>
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
   <% User userx = (User)session.getAttribute("userx");
   if(userx.getAuthority()>5){%>
   <div class="form-group">
   <label>权限：</label><input type="text" name="user.authority" class="form-control" value=${user.authority}>
   </div>
  <%}%>
 
   <input type="submit" class="btn btn-default"/> 
   </form>
   <s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
