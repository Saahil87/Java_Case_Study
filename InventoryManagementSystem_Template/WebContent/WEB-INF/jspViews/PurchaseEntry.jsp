<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a {
  padding-right: 30px;
}
</style>
<h1>Inventory Management System</h1><hr/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<a  href="#">Purchase Entry</a>
  <a  href="#">Purchase Report-Date Wise</a>
  <a  href="#">Vendor-Purchased Item Report</a>
  <a  href="#">Logout</a>

  <hr/>
<body>
<center>
<h2>Material Purchase Entry</h2></center>
<spring:form action="" method="POST" modelAttribute="purchaseBean">
<table>
<tr><td>Vendor Name <spring:select path="vendorName" items="${getVendorName}"/>
<tr><td>Material Category<spring:select path="materialCategoryName" items="${getmaterialCategoryName}"/>
<tr><td>Material Type<spring:select path="materialTypeName" items="${getmaterialTypeName}"/>
<tr><td>Unit <spring:select path="unitName" items="${getunitName}"/>
<tr><td>Brand Name <spring:input path="brandName"/>
<tr><td>Quantity <spring:input path="quantity"/>
<tr><td>Purchase Amount <spring:input path="purchaseAmount"/>
<tr><td>Purchase Date <spring:input path="purchaseDate"/>
<tr><td><input type="submit" value="Add Purchase Entry"/>
</table>
<spring:errors cssClass="error" path="*"></spring:errors>
</spring:form>

{successful}

<hr>
<div>
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p>
</div>
</body>
</html>