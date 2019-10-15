<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Collection"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>
	<jsp:include page="navmain.jsp"  />
	<br><br><br>
	<div class="container">
	<div class="alert alert-success" role="alert">
		<h3>Web Based Inventory Management Software</h3><br><br>
	  <p><b>Inventory Management Software</b> is a software system for tracking inventory levels, orders, sales and deliveries. It can also be used in the manufacturing industry to create a work order, bill of materials and other production-related documents.</p>
	</div>
	</div>
	<div class="container">
		<footer>
			<hr>
	        <p>OOP - CHRISTIAN LAURONILLA - 2019 </p>
	    </footer>
    </div>
</body>
</html>