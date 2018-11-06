<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息列表</title>
</head>
<body>
<h1>班级信息</h1>
<table border="1" width="90%">
    <tr>
        <td>编号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>电话</td>
        <td>照片</td>
        <td>操作</td>
    </tr>
<c:forEach var="stu" items="${STU_LIST}">
    <tr>
        <td><a href="<%=basePath%>/StudentServlet?method=findOne&id=${stu.id}">${stu.id}</a></td>
        <td>${stu.stuName}</td>
        <td>${stu.age}</td>
        <td>${stu.tel}</td>
        <td><img width="100" src="<%=basePath%>/asset/images/${stu.picUrl}"/></td>
         <td><a href="<%=basePath%>/StudentServlet?method=findOne&id=${stu.id}">查看</a></td>
    </tr>
</c:forEach>
</table>
</body>
</html>