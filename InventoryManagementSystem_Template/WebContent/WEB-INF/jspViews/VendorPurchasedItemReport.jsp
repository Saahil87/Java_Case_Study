<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<h2>Vendor-Purchased Item Report</h2>
<spring:form action="getVendorWisePurchaseReportPage.html" method="POST" modelAttribute="purchaseBean">
<table>
<tr>
	<td>Vendor Name</td>
	<td><spring:select path="vendorName">
			<spring:options items="${generateVendorList}" itemValue="vendorName" itemLabel="vendorName"/>
	</spring:select></td>
	<td><spring:errors cssClass="error" path="vendorName"></spring:errors></td>
</tr>


<tr><td><input type="submit" value="Search"/>
</table>
<spring:errors cssClass="error" path="*"></spring:errors>
</spring:form>

<c:if test="${not empty vendorWisePurchaseRecords}">
<table border="2">
<tr><th>Material Category</th><th>Material Type</th><th>Brand</th><th>Quantity</th><th>Unit</th><th>Price</th><th>Vendor</th><th>Purchase Date</th></tr>
<c:forEach items="${vendorWisePurchaseRecords}" var="material">
<tr>
	<td><c:out value="${material.materialCategoryName}"/></td>
	<td><c:out value="${material.materialTypeName}"></c:out></td>
	<td><c:out value="${material.brandName}"></c:out></td>
	<td><c:out value="${material.quantity}"></c:out></td>
	<td><c:out value="${material.unitName}"></c:out></td>
	<td><c:out value="${material.purchaseAmount}"></c:out></td>
	<td><c:out value="${material.vendorName}"></c:out></td>
	<td><c:out value="${material.purchaseDate}"></c:out></td>
</tr>
</c:forEach>
</table>
</c:if>
<hr>
${invalid}
<div>
  <p align="center" style="font-family: calibri;color: #6666CC;">Copyright © 2018 Accenture All Rights Reserved.</p>
</div>
</body>
</html>