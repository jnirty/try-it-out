<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/header.jsp">
	<jsp:param name="pageTitle" value="Category details"/>
</jsp:include>
 
	<p>Category ${category.name}</p>
	<p> Item list</p>
	<ul>
	<c:forEach var="item" items="${items}">
	  <li>${item.name}</li>
	</c:forEach>

</ul>

	

<jsp:include page="common/footer.jsp" />