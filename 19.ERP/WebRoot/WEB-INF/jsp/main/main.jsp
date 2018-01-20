<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>信息管理系统界面</title>
</head>
<frameset rows="88,*,31" cols="*" frameborder="no" border="0"
	framespacing="0">
	<frame src="admin_top.action" name="topFrame" scrolling="Yse"
		noresize="noresize" id="topFrame" title="topFrame" />
	<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
		<frame src="admin_left.action" name="leftFrame" scrolling="No"
			noresize="noresize" id="leftFrame" title="leftFrame" />
		<frame src="admin_index.action" name="bottomFrame" scrolling="Yse"
			noresize="noresize" id="bottomFrame" title="bottomFrame" />
	</frameset>
	<frame src="admin_footer.action" name="bottomFrame" scrolling="Yse" noresize="noresize" id="bottomFrame" 
</frameset>
<noframes>
	<body>
	</body>
</noframes>
</html>
