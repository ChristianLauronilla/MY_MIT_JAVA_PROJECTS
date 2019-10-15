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
<title>Add New Student</title>
</head>
<body>
<jsp:include page="navmain.jsp"  />
	<form action="<%=request.getContextPath()%>/admin/insertStudent" method="GET" id="personForm"><br><br><br>
	<div class="container">
		<h3>Add New Student</h3>
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>
	<table class="nav-justified">
        <tr>
            <td style="width: 162px">Student ID :</td>
            <td>
            <input value="${student.student_id}" style="width : 300px" class="form form-control" type="text" name="student_id" required="required">
            </td>
            <td><input type="button" class="btn btn btn-outline-info" onclick="submitForm('<%=request.getContextPath()%>', 'studentSearch');" value="Search"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">First Name :</td>
            <td><input value="${student.student_fname}" style="width : 300px" class="form form-control" type="text" name="student_fname" required="required"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Last Name :</td>
            <td style="height: 16px"><input value="${student.student_lname}" style="width : 300px" class="form form-control" type="text" name="student_lname" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Mobile Number :</td>
            <td style="height: 16px"><input value="${student.student_mobile_no}" style="width : 300px" class="form form-control" type="text" name="student_mobile_no" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Date Added :</td>
            <td style="height: 16px"><input value="${student.student_date_added}" style="width : 300px" class="form form-control" type="date" name="student_date_added" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
			<td>Status : </td>
			<td>
			<select style="width : 300px" class="form form-control" name="student_status">
				<option>Active</option>
				<option>Inactive</option>
			</select>
		</tr>
		<tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td><input class="btn btn-primary" type="submit" value="Add Student">
            	<input class="btn btn-info" type="submit" value="Update" onclick="submitForm('<%=request.getContextPath()%>', 'studentUpdate');">
            	<input class="btn btn-danger" type="submit" value="Delete" onclick="submitForm('<%=request.getContextPath()%>', 'studentDelete');">
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
	</div>
	</form>
	<br><br>
	<!-- list of user -->
	<div class="container">
	<h3>List Of Student</h3>	
	<table class="table table-bordered table-striped">
		<tr>
			<td><b>Student ID</b></td>
			<td><b>First Name</b></td>
			<td><b>Last Name</b></td>
			<td><b>Mobile Number</b></td>
			<td><b>Date Added</b></td>
			<td><b>Status</b></td>
		</tr>
		<c:forEach items="${records}" var="student">
			<tr>
				<td>${student.student_id}</td>
				<td>${student.student_fname}</td>
				<td>${student.student_lname}</td>
				<td>${student.student_mobile_no}</td>
				<td>${student.student_date_added}</td>	
				<td>${student.student_status}</td>
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