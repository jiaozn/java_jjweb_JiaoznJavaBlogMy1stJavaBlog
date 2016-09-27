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
<h2>所有的文章访问记录：</h2>
<hr>
<table class="table">
<tr><td>记录id</td>
		<td>用户Ip</td>
		<td>目的地址</td>
		<td>说明</td>
		<td>时间</td>
		
	<s:iterator value="listAccessRecord" var="art">
		
		<tr><td><s:property value="#art.id"/></td>
		<td><s:property value="#art.ip"/></td>
		<td><s:property value="#art.destination"/></td>
		<td><s:property value="#art.aintroduction"/></td>
		<td><s:property value="#art.time"/></td>
		</tr>
	</s:iterator>
	</table>
	

	
	
	
	<s:debug></s:debug>
   <jsp:include page="main_foot.jsp"></jsp:include>
  
  </body>
</html>
