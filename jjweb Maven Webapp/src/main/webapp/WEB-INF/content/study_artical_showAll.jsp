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
<h2>文章列表：</h2>
<hr>
<table class="table">
<tr><td>文章id</td>
		<td>作者</td>
		<td>题目 </td>
		<td>日期</td>
		<td>分类</td>
		<td>阅览量</td>
		<td>操作</td></tr>
		
	<s:iterator value="listArtical" var="art">
		
		<tr><td><s:property value="#art.id"/></td>
		<td><s:property value="#art.author"/></td>
		<td><s:property value="#art.title"/></td>
		<td><s:property value="#art.time"/></td>
		<td><s:property value="#art.category.name"/></td>
		<td><s:property value="#art.access"/></td>
		<td><a href="artical_show?artical.id=<s:property value="#art.id"/>">查看   </a>
		<%if(au==7){ %>
		<a href="artical_edit?artical.id=<s:property value="#art.id"/>">修改   </a>
		<a href="artical_delete?artical.id=<s:property value="#art.id"/>">删除   </a></td></tr>
		<%} %>
	</s:iterator>
	</table>
	

	
	
	
	<%if(au==7){ %>
	<a href="artical_add">新增</a>
	<%} %>
	<s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
