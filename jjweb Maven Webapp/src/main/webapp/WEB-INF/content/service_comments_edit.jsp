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


<%! int au; %>
<%
			User userx= (User)session.getAttribute("userx") ;
	if (userx==null){
			userx=new User();
			userx.setAuthority(0);
			userx.setId(0);
			userx.setName("游客");
			au=0;
			}
	else{
	au=userx.getAuthority();}
			//游客0，登陆3，管理7
				%>






<form action="comments_editCommit" name="articalForm" method="post" role="form" >
<div class="form-group">
评论id：<input type="text" name="comments.id" value="${commentsDTO.id}"/>
<div class="form-group">
   <label>评论内容</label>
   <textarea id="editor1" name="comments.content" class="form-control" rows="3" >${commentsDTO.content}</textarea>
   <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'editor1' );
            </script>
   </div>
   评论人：<input type="text" value="${commentsDTO.user.id}" name="comments.userid"/> and Name <input type="text" value="${commentsDTO.user.name}" /><br>
评论时间：<input type="text" value="${commentsDTO.time}" name="comments.time"/><br>
评论对象：<input type="text" value="${commentsDTO.artical.id}" name="comments.articalid"/><br>
  <input type="submit" class="btn btn-default"/> 

   </form>
   <s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
