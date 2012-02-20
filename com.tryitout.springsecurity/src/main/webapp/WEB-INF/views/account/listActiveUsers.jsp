<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="List Active Users" />
</jsp:include>

<h1>Active Users</h1>
<ul>
<c:forEach var="userInfo" items="${activeUsers}">
  <li>${userInfo.key.username} / Last Active: ${userInfo.value}</li>	
</c:forEach>
</ul>

<jsp:include page="../common/footer.jsp" />