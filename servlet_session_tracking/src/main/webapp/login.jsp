<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>

	<%
	String msg = (String) request.getAttribute("msg");
	%>
	<form action="login" method="post">
		<c:out value="${msg}"></c:out>
		<br>
		<label>UserName</label>
		<br>
		<input type="text" placeholder="username" name="userName">
		<br>
		<label>Password</label>
		<br>
		<input type="password" placeholder="password" name="userPassword">
		<br>

		<input type="submit" value="Login">
	</form>
</body>
</html>