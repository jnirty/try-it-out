<%@ page contentType="text/html;charset=UTF-8" language="java"
	session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html> 
<head>
<title>Simple Spring MVC</title>
</head>
<body>
 
	<p>Login to application</p>
	<form action="j_spring_security_check" method="post">
		<label for="j_username" >Login </label><input id="j_username" name="j_username" size="20" maxlength="50" type="text" /><br/>
		<label for="j_password" >Password </label><input id="j_password" name="j_password" size="20" maxlength="50" type="password" /><br/>
		<input type="submit" value="Login" />
	</form>
</body>
</html>