<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<h1>Inventory Management System</h1><hr/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<hr><h2>Login</h2></hr>
<spring:form action=".html" method="POST" modelAttribute="loginBean">
<table>
<tr><td>Username:<spring:input path="username"/>
<tr><td>Password:<spring:input path="password"/>
</table>
<spring:errors path="*" cssClass="error"/>
</spring:form>
<input type="submit" value="Submit"/>
<hr>
<div>
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p>
</div>
${error}
</body>
</html>