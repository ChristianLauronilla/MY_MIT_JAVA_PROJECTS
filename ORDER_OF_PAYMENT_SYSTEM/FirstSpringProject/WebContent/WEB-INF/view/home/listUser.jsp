<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navmain.jsp"  />
<head>
<title>List Of User</title>
</head><br>
	<div class="container">
	<form action="<%=request.getContextPath()%>/admin/insertUserr" method="get" id="personForm">
		<table>
			<tr>
				<td width="100px">Username : </td>
				<td><input type="text" name="username" value="${userr.username}">
				<input type="button" class="btn btn-raised btn-default" onclick="submitForm('<%=request.getContextPath()%>', 'userrSearch');" value="Search"></td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td>Password : </td>
				<td><input type="password" name="password" value="${userr.password}"></td>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" value="${userr.name}"></td>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td>Role : </td>
				<td>
				<select path="role" name="role">
					<option>ROLE_USER</option>
					<option>ROLE_ADMIN</option>
				</select>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
		</table>
		<input class="button is-success is-small" type="submit" value="Add">
		<input type="button" class="button is-warning is-small" onclick="submitForm('<%=request.getContextPath()%>', 'userrUpdate');" value="Update">
		<input type="button" class="button is-danger is-small" onclick="submitForm('<%=request.getContextPath()%>', 'userrDelete');" value="Delete">
		
	</form>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
		
	</script>
	<!-- display all userr records-->
	<table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
		<tr>
			<td><b>User Name</b></td>
			<td><b>Name</b></td>
			<td><b>Role</b></td>
		</tr>
		<c:forEach items="${records}" var="userr">
			<tr>
				<td>${userr.username}</td>
				<td>${userr.name}</td>
				<td>${userr.role}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	