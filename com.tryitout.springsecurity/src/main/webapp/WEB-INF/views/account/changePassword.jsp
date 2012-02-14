<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp">
	<jsp:param name="pageTitle" value="Change Password" />
</jsp:include>

<h1>Change your password</h1>
<form  method="POST">
	<label for="oldPassword" >Old Password: </label> 
	<input type="password" id="oldPassword" name="oldPassword" maxlength="50" size="20" /> <br/>
	<label for="newPassword" >New Password: </label> 
	<input type="password" id="newPassword" name="newPassword" maxlength="50" size="20" /> <br/>
	<input type="submit" value="Change Password" />
</form>

<jsp:include page="../common/footer.jsp" />