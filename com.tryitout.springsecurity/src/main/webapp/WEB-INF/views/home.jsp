<%@ page contentType="text/html;charset=UTF-8" language="java"
	session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html> 
<head>
<title>Simple Spring MVC</title>
</head>
<body>
	<h1>Welcome, it works. Today is:</h1> 
	<p><c:out value="${today}"/></p>


</body>
</html>