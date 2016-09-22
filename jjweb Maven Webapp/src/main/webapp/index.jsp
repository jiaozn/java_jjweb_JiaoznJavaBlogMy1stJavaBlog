<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
	<h2>Hello World!</h2>
	<s:form action="login">
		<s:textfield name="name" value="steve"></s:textfield>
		<s:textfield name="password" value="123"></s:textfield>
		<s:submit></s:submit>
	</s:form>
</body>
</html>
