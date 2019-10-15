<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Person</h1>
	
		<h3>${message}</h3>
	<!-- display all person records-->
	<table border="1px solid gray">
		<tr>
			<td>Email Address</td>
			<td>Name</td>
			<td>Birthday</td>
			<td>Address</td>
		</tr>
		<c:forEach items="${records}" var="person">
			<tr>
				<td>${person.emailAddress}</td>
				<td>${person.name}</td>
				<td>${person.birthday}</td>
				<td>${person.address}</td>
			</tr>
		</c:forEach>
	</table>
	Person: ********-${person}-***********
	<h1>New Person Info:</h1>
	<form action="<%=request.getContextPath()%>/personSave" method="get" id="personForm">
		<table>
			<tr>
				<td>Email Add: </td>
				<td><input type="text" name="emailAddress" value="${person.emailAddress}"><input type="button" 
					onclick="submitForm('<%=request.getContextPath()%>', 'personSearch');" value="Search"></td>
			</tr>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" value="${person.name}"></td>
			</tr>
			<tr>
				<td>Birthday: </td>
				<td><input type="date" name="birthday" value="${person.birthday}"></td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><input type="text" name="address" value="${person.address}"></td>
			</tr>
		</table>
		<input type="submit" value="Save">
		<input type="button" onclick="submitForm('<%=request.getContextPath()%>', 'personUpdate');" value="Update">
		<input type="button" onclick="submitForm('<%=request.getContextPath()%>', 'personDelete');" value="Delete">
		
	</form>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
		
	</script>
</body>
</html>