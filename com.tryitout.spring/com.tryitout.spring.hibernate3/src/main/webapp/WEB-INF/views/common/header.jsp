<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
	<link rel="stylesheet" type="text/css" href='<c:url value="/css/style.css" />' />
	<script src='<c:url value="/script/jquery-1.7.1.js" />'></script>


<title>Spring & Hibernate: ${pageTitle}</title>
</head>

<body>
	<div id="header">
		<ul>
			<c:url value="/home.htm" var="homeUrl"/>
			<li><a href="${homeUrl}">Home</a></li>
		</ul>
		<br />
	</div>
