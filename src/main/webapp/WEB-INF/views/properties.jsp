<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Properties</title>
<style><%@include file="/WEB-INF/css/styles.css"%></style>
</head>
<body>
	<!--Top bar -->
	<div class="header">ReetMoove</div>
	<div class="topnav">
		<a href="/">Home</a>
		<a href="/filter">Filter</a>
	</div>
	<c:choose>
		<c:when test="${properties.size() != 0}">
			<!-- Page Title -->
			<h1>Results for ${filter}</h1>
			<!-- Sort by -->
				<form:form action="sort" method="post" modelAttribute="sortForm">
					<table>
						<tr>
							<td>Sort By</td>
							<td>
								<form:select path="type" onchange="this.form.submit()">
									<c:forEach items="${sortingTypes}" var="type">
										<form:option value="${type}" label="${type.name}"></form:option>
									</c:forEach>
								</form:select>
							</td>
						</tr>
					</table>
				</form:form>
				<!-- Display properties -->
				<c:forEach items="${properties}" var="property">
					<div class="property">
						<a href="/property/${property.id}">
							<h2>${property}</h2>
							<img src="${property.url}"/>
						</a>
						<c:choose>
							<c:when test="${LET == true}">
								<h3><b>£${property.price} pcm</b></h3>
							</c:when>
							<c:otherwise>
								<h3><b>£${property.price}</b></h3>
							</c:otherwise>
						</c:choose>
					</div>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<h1>There are no ${filter}</h1>
		</c:otherwise>
	</c:choose>
	
</body>
</html>