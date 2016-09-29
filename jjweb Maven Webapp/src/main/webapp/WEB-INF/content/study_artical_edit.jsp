<%@ page language="java" import="java.util.*,com.jjweb.model.Category,com.jjweb.model.Artical" pageEncoding="UTF-8"%>
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
<form action="artical_editCommit" name="articalForm" method="post" role="form" >
<div class="form-group">
<input type="hidden" value="<s:property value="artical.id"/>" name="artical.id"/>
<input type="hidden" value="<s:property value="artical.access"/>" name="artical.access"/>
   <label>标题：</label><input type="text" name="artical.title" class="form-control" value="<s:property value="artical.title"/>" />
   </div>
   <div class="form-group">
   <label>正文：</label>
   <textarea id="editor1" name="artical.content" class="form-control" rows="3" ><s:property value="artical.content"/></textarea>
   <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'editor1' );
            </script>
   </div>
   
   <%--
   <div class="form-group">
   <label>作者：</label>
   <input type="text" name="artical.author" class="form-control" value="<s:property value="artical.author"/>"/>
   </div>
   --%>
     <input type="hidden" name="artical.author" value="<s:property value="#session.userx.name"/>"/>
   作者：<s:property value="#session.userx.name"/>
   <div class="form-group">
<label>分类：</label>
<% //request.setAttribute("categories", "(List<Category>)(request.getAttribute('categories').remove(0))"); 
((List<Category>)request.getAttribute("categories")).remove(0);
//int catid=((Artical)request.getAttribute("artical")).getCategory().getId()-1;
//System.out.println(catid);
%>

<s:select list="categories" listValue="name" listKey="id" name="category.id" value="%{artical.category.id}"></s:select> 
<s:property value="artical.category.id"/>
   </div>
   <input type="submit" class="btn btn-default"/> 
   </form>
   <jsp:include page="main_foot.jsp"></jsp:include>
   <s:debug></s:debug>
  </body>
</html>
