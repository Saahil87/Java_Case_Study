<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="error" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h1>Inventory Management System</h1><hr/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<hr><h2>Login</h2></hr>
<spring:form action="validateLogin.html" method="POST" modelAttribute="loginBean">
<table>
<tr><td>Username:<spring:input path="username"/>
<tr><td>Password:<spring:password path="password"/>
<tr><td><input type="submit" value="Login"/>
</table>
<error:hasBindErrors name="loginBean">
<spring:errors cssClass="error" path="*"></spring:errors>
</error:hasBindErrors>
</spring:form>

<hr>
<div>
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright � 2018 Accenture All Rights Reserved.</p>
</div>
${invalid}
</body>
</html>