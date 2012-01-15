<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Simple jQuery and JSP example</title>
<script src="script/jquery-1.7.1.js" type="text/javascript"></script>
<script src="script/script.js" type="text/javascript"></script>
</head>
<body>
	<form id="form" action="jsp/calculate.jsp" method="post">
		Enter number: <input id="number" type="text" name="number" /> <input
			id="submit" type="submit" value="Calculate Square Root" name="submit" />
	</form>
	<p id="result"></p>

	<jsp:useBean id="cache" class="domain.UsersCache" scope="session" />

	<input id="appendButton" type="button" value="Append text" />

	<div id="list">
		<c:forEach var="user" items="${cache.users}" varStatus="status">

			<a>${user.surname}</a>
			${not status.last ? '<hr/>' : ''}		
			 
		</c:forEach>
	</div>

	<div id="twitterSearch">
		<input type="text" id="query" />
		<button>Search</button>
		<div id="results"></div>
	</div>
</body>
</html>