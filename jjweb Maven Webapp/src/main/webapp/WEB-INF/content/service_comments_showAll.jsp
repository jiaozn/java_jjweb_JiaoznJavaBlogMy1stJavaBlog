<%@ page language="java" import="java.util.*,com.jjweb.model.User" pageEncoding="UTF-8"%>
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
   
   	 <%! int au; %>
<%
			User userx= (User)session.getAttribute("userx") ;
	if (userx==null)
			au=0;
	else
	au=userx.getAuthority();
			//游客0，登陆3，管理7
				%>
   
study_c_listAll.jsp<br>
<h2>评论列表：</h2>
<hr>
<table class="table">
<tr><td>评论id</td>
		<td>内容</td>
		<td>评论者 </td>
		<td>出处</td>
		<td>时间</td>
		<%if(au==7){ %><td>操作</td>
		<%} %>
		</tr>
		
	<s:iterator value="listCommentsDTO" var="art">
		
		<tr><td><s:property value="#art.id"/></td>
		<td><s:property value="#art.content"/></td>
		<td><s:property value="#art.user.name"/></td>
		<td><s:property value="#art.artical.title"/></td>
		<td><s:property value="#art.time"/></td>
		<%if(au==7){ %>
		<td><a href="comments_edit?comments.id=<s:property value="#art.id"/>">修改   </a>
		<a href="comments_delete?comments.id=<s:property value="#art.id"/>">删除   </a></td></tr>
		<%} %>
	</s:iterator>
	</table>
	
	<s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
