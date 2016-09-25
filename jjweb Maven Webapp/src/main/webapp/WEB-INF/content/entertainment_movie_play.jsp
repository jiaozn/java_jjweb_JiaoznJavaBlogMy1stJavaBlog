<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    

    <link href="http://vjs.zencdn.net/5.8.8/video-js.css" rel="stylesheet">

  <script src="http://vjs.zencdn.net/ie8/1.1.2/videojs-ie8.min.js"></script>
  
  
  
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
   
study_c .jsp   

<div align="center">
<video id="my-video" class="video-js" controls preload="auto" width="auto" height="264"
  poster="MY_VIDEO_POSTER.jpg" data-setup="{}" autoplay="autoplay">
    <source src="movies/<s:property value="fileFileName"/>" type='video/mp4'></source>
    <p class="vjs-no-js">
      To view this video please enable JavaScript, and consider upgrading to a web browser that
      <a href="http://videojs.com/html5-video-support/" target="_blank">supports HTML5 video</a>
    </p>
  </video>
</div>
<s:debug></s:debug>

  <script src="http://vjs.zencdn.net/5.8.8/video.js"></script>


<!--  

<video src="uploadFiles/3.mp4" controls height="600" width="800" autoplay preload>您的浏览器不支持video标签</video>


-->
   
   <jsp:include page="main_foot.jsp"></jsp:include>
  </body>
</html>
