<%@ page language="java" import="java.util.*,com.jjweb.model.User" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s" %>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<base href="<%=basePath%>">

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h1>Welcome to JWeb</h1>
	<br>
<%! int au; %>
<%
			User userx= (User)session.getAttribute("userx") ;
	if (userx==null)
			au=0;
	else
	au=userx.getAuthority();
			//游客0，登陆3，管理7
				%>
				 
				 
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display 
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Brand</a>
    </div>
-->
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="introduction_show">主页 </a>
					</li>
					<!-- <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Index!<span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="introduction_show">显示个人介绍</a></li>
            <li><a href="introduction_edit">修改个人介绍</a></li>
             <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">One more separated link</a></li>
             
          </ul>
        </li>-->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">日志<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="artical_showAll">显示所有</a>
							</li>
							<%if(au>2){ %>	
							<li><a href="artical_add">新增日志</a>
							</li>
							<%} %>
							
						</ul></li>
						
						<%if(au==7){ %>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">日志分类<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="category_showAll">显示所有</a>
							</li>
							
							<li><a href="category_add">新增分类</a>
							</li>
						</ul></li>
						<%} %>
						
						
						
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">文件管理<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="upload!listAll">显示所有</a>
							</li>
							<%if(au==7){ %>
							<li><a href="upload">新增</a>
							</li>
							<%} %>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">视频<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="movie!listAll">显示所有</a>
							</li>
							<%if(au==7){ %>
							<li><a href="movie">新增</a>
							</li>
							<%} %>
						</ul></li>
				
				<%if(au>2){ %>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">欢迎，<s:property value="#session.userx.name" /><span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="user_edit?user.id=<s:property value="#session.userx.id"/>">编辑</a>
							</li>
							<li><a href="user_logout?user.id=<s:property value="#session.userx.id"/>">注销</a>
							</li>
						</ul></li>
					<%} %>
					
					<%if(au==7){ %>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">用戶管理<span class="caret"></span>
					</a>
						<ul class="dropdown-menu">
							<li><a href="user_showAll">用戶清單</a>
							</li>
							<li><a href="counterSession_showAll">网站访问统计</a>
							</li>
							<li><a href="accessRecord_showAll">文章访问统计</a>
							</li>
						</ul></li>
						<%} %>
						
						
					<%if(au<3){ %>		
					<li><a href="user_login">登陆 </a>
					</li>
					<%} %>
					<li><a href="user_add">注册 </a>
					</li>
						
				</ul>
				<!-- 
      <form class="navbar-form navbar-left">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li role="separator" class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
       -->
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>



	<!-- 
    <a href="service_personalIntroduction">显示个人介绍</a>
       <a href="service_personalIntroduction!edit">修改个人介绍</a>
       <a href="artical!add">新增文章</a>
       <a href="artical!listAll">显示所有文章</a>
        -->
				 
				 

</body>
</html>
