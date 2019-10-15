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
<title>My Class</title>
</head>
<body>
<jsp:include page="navmain.jsp"  />
	<!-- list of myclass -->
	<br><br><br>
	<div class="container">
	<h3>List Of Students</h3>	
	<form action="<%=request.getContextPath()%>/admin/viewkljsa" method="GET" id="personForm">
	<div class="container">
	<table class="nav-justified">
        <tr>
            <td style="width: 162px">Teacher :</td>
            <td>
            <input value="<%=((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()%>" type="text" name="teacher_username" required="required">
            </td>
            <td>
            	<input type="button" class="btn btn btn-outline-info" onclick="submitForm('<%=request.getContextPath()%>', '/user/viewClassTeacher');" value="View Class">
            </td>
        </tr>
      </table>
      </div>
      </form>
	<br><br>
	<table class="table table-bordered table-striped">
		<tr>
			<td><b>Section Name</b></td>
			<td><b>Student ID</b></td>
			<td><b>Student Name</b></td>
		</tr>
		<c:forEach items="${records}" var="myclasss">
			<tr>
				<td>${myclasss.section_name}</td>
				<td>${myclasss.student_id}</td>
				<td>${myclasss.student_name}</td>
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