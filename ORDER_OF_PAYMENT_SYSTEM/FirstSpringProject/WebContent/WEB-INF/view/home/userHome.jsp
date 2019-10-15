<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/addUser">
		<h1>Add User</h1>
		<table>
			<tr>
				<td>Email Address:</td>
				<td><input type="email" name="emailAddress"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<select name="gender">
						<option>Male</option>
						<option>Female</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type="date" name="birthday"></td>
			</tr>
		</table>
		<input type="submit" value="Save">
	</form>
	

</body>
</html>