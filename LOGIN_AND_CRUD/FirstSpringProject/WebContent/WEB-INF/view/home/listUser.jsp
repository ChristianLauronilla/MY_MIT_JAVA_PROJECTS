<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navmain.jsp"  />
<head>
<title>List Of User</title>
</head>
	<br><br><br>
	<div class="container">
	<h1>List</h1>	
	<form action="<%=request.getContextPath()%>/userrSave" method="get" id="personForm">
		<table>
			<tr>
				<td>User Name : </td>
				<td><input type="text" name="username" value="${userr.username}">
				<input type="button" class="btn btn-raised btn-default" onclick="submitForm('<%=request.getContextPath()%>', 'userrSearch');" value="Search"></td>
			</tr>
			<tr>
				<td>Name: </td>
				<td><input type="text" name="name" value="${userr.name}"></td>
			</tr>
			<tr>
				<td>Role : </td>
				<td>
				<select style="width : 300px" class="form form-control" path="role" name="role">
					<option>ROLE_USER</option>
					<option>ROLE_ADMIN</option>
				</select>
			</tr>
		</table>
		<input type="button" class="btn btn-raised btn-info" onclick="submitForm('<%=request.getContextPath()%>', 'userrUpdate');" value="Update">
		<input type="button" class="btn btn-raised btn-danger" onclick="submitForm('<%=request.getContextPath()%>', 'userrDelete');" value="Delete">
		
	</form>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
		
	</script>
	<!-- display all userr records-->
	<table class="table table-bordered table-striped">
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
	
	<div class="container">
		<footer>
		<hr>
	        <p>OOP - CHRISTIAN LAURONILLA - 2019 </p>
	    </footer>
    </div>