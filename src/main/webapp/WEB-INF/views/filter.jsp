<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Filter</title>
<style><%@include file="/WEB-INF/css/forms.css"%></style>
</head>
<body>
	<div class="form">
		<form:form action="filter" method="post" modelAttribute="filterForm">
			<c:choose>
				<c:when test="${lastFilter != null}">
					<table>
						<tr>
							<td>Location</td>
							<td><form:input path="location" value="${lastFilter.location}" required="true"/></td>
						</tr>
						<tr>
							<td>Min Price</td>
							<td>£<form:input path="minPrice" value="${lastFilter.minPrice}" type="number" step="1" min="0" max="100000000"/></td>
							<td>Max Price</td>
							<td>£<form:input path="maxPrice" value="${lastFilter.maxPrice}" type="number" step="1" min="0" max="100000000"/></td>
						</tr>
						<tr>
							<td>Property Type</td>
							<td>
								<form:select path="propertyType">
									<c:choose>
										<c:when test="${lastFilter.propertyType != null}">
											<form:option value="${lastFilter.propertyType}" label="${lastFilter.propertyType}"/>
										</c:when>
										<c:otherwise>
											<form:option value="" label="Select"/>
										</c:otherwise>
									</c:choose>
									<form:options items="${types}"/>
									<form:option value="" label="Select"/>
								</form:select>
							</td>
						</tr>
						<tr>
							<td>Min Bedrooms</td>
							<td><form:input path="minNumberOfBedrooms" value="${lastFilter.minNumberOfBedrooms}" type="number" step="1" min="0" max="10"/></td>
							<td>Max Bedrooms</td>
							<td><form:input path="maxNumberOfBedrooms" value="${lastFilter.maxNumberOfBedrooms}" type="number" step="1" min="0" max="10"/></td>
						</tr>
						<tr>
							<td><input type="submit" value="Filter"/></td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<td>Location</td>
							<td><form:input path="location" placeholder="e.g. Hull" required="true"/></td>
						</tr>
						<tr>
							<td>Min Price</td>
							<td>£<form:input path="minPrice" type="number" step="1" min="0" max="100000000"/></td>
							<td>Max Price</td>
							<td>£<form:input path="maxPrice" type="number" step="1" min="0" max="100000000"/></td>
						</tr>
						<tr>
							<td>Property Type</td>
							<td>
								<form:select path="propertyType">
									<form:option value="" label="Select"/>
									<form:options items="${types}"/>
								</form:select>
							</td>
						</tr>
						<tr>
							<td>Min Bedrooms</td>
							<td><form:input path="minNumberOfBedrooms" type="number" step="1" min="0" max="10"/></td>
							<td>Max Bedrooms</td>
							<td><form:input path="maxNumberOfBedrooms" type="number" step="1" min="0" max="10"/></td>
						</tr>
						<tr>
							<td><input type="submit" value="Filter"/></td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</form:form>
	</div>
</body>
</html>