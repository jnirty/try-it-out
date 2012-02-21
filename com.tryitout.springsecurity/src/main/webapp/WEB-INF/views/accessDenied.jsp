<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:include page="common/header.jsp">
	<jsp:param name="pageTitle" value="Login"/>
</jsp:include>
 
	<p>Access Denied Exception occurred</p>
	<br/>
	<a>${errorDetails}</a>
	<br/><br/>
	<em>Stack trace is:</em>
	<br/>
	<blockquote>
		<pre>
			${errorTrace}
		</pre>
	</blockquote>

<jsp:include page="common/footer.jsp" />