<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<div id="header" class="moviesHeader">
		<ul>
			<c:url value="/movies/create.htm" var="createUrl"/>
			<li><a href="${createUrl}">New Movie</a></li>
			
			<li class="separator">|</li>
			
			<c:url value="/movies/list.htm" var="listUrl"/>
			<li><a href="${listUrl}">List</a></li>
			
		</ul>
		<br />
	</div>
AEROLIA_PLM-1165
AEROLIA_PLM-1168
AEROLIA_PLM-1167 -

AEROLIA_PLM-1148
AEROLIA_PLM-1170
 AEROLIA_PLM-1172