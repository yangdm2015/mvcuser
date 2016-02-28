<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<sf:form method="post" modelAttribute="user">
UserName:<sf:input path="username"/><sf:errors path="username"/><br/>
Password:<sf:password path="password"/><sf:errors path="password"/><br/>
Nickname:<sf:input path="nickname"/><sf:errors path="nickname"/><br/>
Email: <sf:input path="email"/><sf:errors path="email"/><br/>
<input type="submit"/>
</sf:form>
</body>
</html>