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
	<input type="button" value="Check Security Cookie" onclick="getSecurityCookie();" /><br/>
	<p id="_cookie_out"></p>
	<div id="content" style="color:blue;font:bold 14px arial;padding-top:140px;"> 
	</div> 
<jsp:include page="common/footer.jsp" />
	