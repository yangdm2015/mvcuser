<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/main.css">
</head>
<body>
<a href="add">Add</a>-->${loginUser.nickname }--${tttt }<br/>
<c:forEach items="${users }" var="user">
<!--  -->
	<a href="${user.value.username }">${user.value.username }</a>--------
	
	${user.value.nickname }-------
	${user.value.password }----${user.value.email }
	<!--  
	<a href="${user.value.username }/update">更新</a>
	<a href="${user.value.username }/delete">删除</a>
	-->
	<br/>
</c:forEach>
</body>
</html>