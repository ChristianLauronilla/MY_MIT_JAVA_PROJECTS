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
	<h1>New Person Info:</h1>
	<form:form action="<%=request.getContextPath() + \"/savePerson\"%>" modelAttribute="person"> <!-- default method is POST -->
		<table>
			<tr>
				<td><form:label path="emailAddress">Email Address:</form:label></td>
				<td><form:input path="emailAddress" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="name">Name:</form:label></td>
				<td><form:input path="name" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender:</form:label></td>
				<td><form:input path="gender" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="birthday">Birthday:</form:label></td>
				<td><form:input type="date" path="birthday" readonly="true"/></td>
			</tr>
			<tr>
				<td><form:label path="address">Address:</form:label></td>
				<td><form:input path="address" readonly="true"/></td>
			</tr>
		</table>
		<form:button>Submit</form:button>
	</form:form>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
		
	</script>
</body>
</html>