
To check custom authentication implementation of Single Sign-On:
1. Add to request headers attributes: 
	j_username = guest
	j_password = guest
	j_signature = guest|+|guest
2. Go to url:
	http://localhost:8090/com.tryitout.springsecurity/j_spring_security_filter


Useful tools
============= 
Connecting to HSQL DB using DBVisualizer http://jlorenzen.blogspot.com/2008/01/how-to-connect-to-grails-hsql-database.html

View designer: http://www.guuui.com/issues/02_07.php
http://projects.gnome.org/dia/
http://www.openoffice.org/product/draw.html


A browser extension for Mozilla Firefox, called Modify Headers:
http://modifyheaders.mozdev.org/
Very straightforward tool for simulating requests that rely on manipulation on HTTP request headers.
For Chrome there is ModHeader plugin accessible on Chrome Web Store

Web Application Security Project - info about security attacks and design guidelines
https://www.owasp.org/