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
<title>Add New Teacher</title>
</head>
<body>
<jsp:include page="navmain.jsp"  />
	<form action="<%=request.getContextPath()%>/admin/insertUserr" method="GET" id="personForm"><br><br><br>
	<div class="container">
		<h3>Add New Teacher</h3>
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>
	<table class="nav-justified">
        <tr>
            <td style="width: 162px">User name :</td>
            <td>
            <input value="${userr.username}" style="width : 300px" class="form form-control" type="text" name="username" path="username" required="required">
            </td>
            <td><input type="button" class="btn btn btn-outline-info" onclick="submitForm('<%=request.getContextPath()%>', 'userrSearch');" value="Search"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">Password :</td>
            <td><input value="${userr.password}" style="width : 300px" class="form form-control" type="password" name="password" path="password" required="required"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">First Name :</td>
            <td style="height: 16px"><input value="${userr.fname}" style="width : 300px" class="form form-control" type="text" name="fname" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Last Name :</td>
            <td style="height: 16px"><input value="${userr.lname}" style="width : 300px" class="form form-control" type="text" name="lname" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Mobile Number :</td>
            <td style="height: 16px"><input value="${userr.mobile_no}" style="width : 300px" class="form form-control" type="text" name="mobile_no" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Date Added :</td>
            <td style="height: 16px"><input value="${userr.date_added}" style="width : 300px" class="form form-control" type="date" name="date_added" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">Role :</td>
            <td>
            		<select style="width : 300px" class="form form-control" path="role" name="role">
						<option>ROLE_USER</option>
						<option>ROLE_ADMIN</option>
					</select>
			</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td><input class="btn btn-primary" type="submit" value="Add Teacher">
            	<input class="btn btn-info" type="submit" value="Update" onclick="submitForm('<%=request.getContextPath()%>', 'userrUpdate');">
            	<input class="btn btn-danger" type="submit" value="Delete" onclick="submitForm('<%=request.getContextPath()%>', 'userrDelete');">
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
	</div>
	</form>
	<br><br>
	<!-- list of user -->
	<div class="container">
	<h3>List Of Teacher</h3>	
	<table class="table table-bordered table-striped">
		<tr>
			<td><b>User name</b></td>
			<td><b>First name</b></td>
			<td><b>Last name</b></td>
			<td><b>Role</b></td>
			<td><b>Mobile Number</b></td>
			<td><b>Date Added</b></td>
			<td><b>Status</b></td>
		</tr>
		<c:forEach items="${records}" var="userr">
			<tr>
				<td>${userr.username}</td>
				<td>${userr.fname}</td>
				<td>${userr.lname}</td>
				<td>${userr.role}</td>
				<td>${userr.mobile_no}</td>
				<td>${userr.date_added}</td>	
				<td>${userr.status}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
	</script>
</body>
</html>