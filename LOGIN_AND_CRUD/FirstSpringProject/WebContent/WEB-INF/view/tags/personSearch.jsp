<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Person</h1>
	${message}
	<h1>Enter email address of a person:</h1>
	<form action="<%=request.getContextPath()%>/searchPerson">
		<label for="emailAddress">Email Address</label>
		<input type="text" name="emailAddress" id="emailAddress"/>
		<input type="submit" value="Search">
	</form>
</body>
</html>