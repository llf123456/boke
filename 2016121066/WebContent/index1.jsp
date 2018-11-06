<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>學生信息列表</title>
</head>
<body>
	<a href="<%=basePath%>/StudentServlet?method=findAll">查看所有学生信息列表</a>
</body>
</html> 