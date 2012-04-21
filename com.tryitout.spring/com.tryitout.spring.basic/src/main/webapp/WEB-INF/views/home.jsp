<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/header.jsp">
	<jsp:param name="pageTitle" value="Home"/>
</jsp:include>

	<h1>Welcome, it works. Today is:</h1> 
	<p><c:out value="${today}"/></p>
	<br/>
	<h2>List data:</h2>
	<ul>
		<c:forEach var="item" items="${readerData}">
			<li>${item}</li>	
		</c:forEach>
	</ul>
	<br/>
	<a>You have currently ${shoppingBasketsNum } shopping baskets.</a>
	
	<h2>Orders:</h2>
	<ul>
		<c:forEach var="order" items="${orders}">
			<li>${order}</li>	
		</c:forEach>
	</ul>
	<br/>
	<p>Order for customer 1 is ${order}</p>
<jsp:include page="common/footer.jsp" />
	