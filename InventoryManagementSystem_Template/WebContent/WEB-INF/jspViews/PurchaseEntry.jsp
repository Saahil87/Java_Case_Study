.<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
a {
  padding-right: 30px;
}

.error{
color: red;
}

</style>
<h1>Inventory Management System</h1><hr/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<a  href="loadPurchaseEntryPage.html">Purchase Entry</a>
  <a  href="loadDateWisePurchaseReportPage.html">Purchase Report-Date Wise</a>
  <a  href="loadVendorWisePurchaseReportPage.html">Vendor-Purchased Item Report</a>
  <a  href="logout.html">Logout</a>

  <hr/>
<body>

<script type="text/javascript">

 

function getUnitAndTypeList(){   

document.forms["form1"].action="fetchMaterialTypesAndMaterialUnitsList.html";

    document.forms["form1"].method="post";

    document.forms["form1"].submit();

}

 

</script>

<center>
<h2>Material Purchase Entry</h2></center>
<spring:form action="addPurchaseEntry.html" method="POST" modelAttribute="purchaseBean" name="form1">
<table>

<tr>
	<td>Vendor Name</td>
	<td><spring:select path="vendorName">
			<spring:options items="${generateVendorList}" itemValue="vendorName" itemLabel="vendorName"/>
	</spring:select></td>
	<td><spring:errors path="vendorName" cssClass="error"></spring:errors></td>
</tr>
<tr>
	<td>Material Category</td>
	<td><spring:select path="materialCatergoryId" onchange="getUnitAndTypeList();">
		<spring:option value="" label="--Select--"></spring:option>
		<spring:options items="${generateMaterialCategoryList}" itemValue="categoryId" itemLabel="categoryName"/>
	</spring:select></td>
	<td><spring:errors path="materialCatergoryId" cssClass="error"></spring:errors></td>
<tr>


<tr>
	<td>Material Type</td>
	<td><spring:select path="materialTypeId">
		<spring:option value="" label="--Select--"></spring:option>
		<spring:options items="${materialTypeBeans}" itemValue="typeId" itemLabel="typeName"/>
	</spring:select></td>
	<td><spring:errors path="materialTypeId" cssClass="error"></spring:errors></td>
</tr>
<tr>
	<td>Unit</td>
	<td><spring:select path="unitId">
		<spring:option value="" label="--Select--"></spring:option>
		<spring:options items="${unitBeans}" itemValue="unitId" itemLabel="unitName"/>
	</spring:select></td>
	<td><spring:errors path="unitId" cssClass="error"></spring:errors></td>
</tr>

<tr><td>Brand Name <spring:input path="brandName"/></td><td><spring:errors path="brandName" cssClass="error"></spring:errors></td>
<tr><td>Quantity <spring:input path="quantity"/></td><td><spring:errors path="quantity" cssClass="error"></spring:errors></td>
<tr><td>Purchase Amount <spring:input path="purchaseAmount"/></td><td><spring:errors path="purchaseAmount" cssClass="error"></spring:errors></td>
<tr><td>Purchase Date <spring:input path="purchaseDate"/></td><td><spring:errors path="purchaseDate" cssClass="error"></spring:errors></td>
<tr><td><input type="submit" value="Add Purchase Entry"/></td>
</table>
</spring:form>

<p style="color:red">${successful}</p>

<hr>
<div>
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p>
</div>
</body>
</html>