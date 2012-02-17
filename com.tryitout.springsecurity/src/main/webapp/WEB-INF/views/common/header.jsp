<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> 
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css" />' />
	<script src='<c:url value="/script/base64.js" />' ></script>
	<script src='<c:url value="/script/main.js" />'></script>
	<script src='<c:url value="/script/jquery-1.7.1.js" />'></script>


<title>JBCP Pets: ${pageTitle}</title>
</head>

<body>
	<div id="header">
		<ul>
			<c:url value="/home.htm" var="homeUrl"/>
			<li><a href="${homeUrl}">Home</a></li>
	
			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<li><a href="${logoutUrl}">Log out</a></li>

			<c:url value="/account/home.htm" var="accountUrl"/>
			<li><a href="${accountUrl}">My Account</a></li>
		</ul>
		<br />
	</div>
