<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${property}</title>
<style>
	td {
		width: 100px;
	}
</style>
</head>
<body>
	<h1>${property}</h1>
	<img src="${property.url}" width="500px"/>
	<c:choose>
		<c:when test="${LET == true}">
			<h3><b>£${property.price} pcm</b></h3>
		</c:when>
		<c:otherwise>
			<h3><b>£${property.price}</b></h3>
		</c:otherwise>
	</c:choose>
	<table>
		<tr>
			<td>Location</td>
			<td>${property.location}</td>
		</tr>
		<tr>
			<td>Bedrooms</td>
			<td>${property.numberOfBedrooms}</td>
		</tr>
		<tr>
			<td>Property Type</td>
			<td>${property.propertyType.display()}</td>
		</tr>
	</table>
	<h3>Description</h3>
	<p>${property.description}</p>
</body>
</html>