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
<title>Add New Class</title>
</head>
<body>
<jsp:include page="navmain.jsp"  />
	<form action="<%=request.getContextPath()%>/admin/insertClass" method="GET" id="personForm"><br><br><br>
	<div class="container">
		<h3>Add New Class</h3>
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>
	<table class="nav-justified">
        <tr>
            <td style="width: 162px">Class ID :</td>
            <td>
            <input value="" style="width : 300px" class="form form-control" type="text" name="class_id" required="required">
            </td>
            <td><input type="button" class="btn btn btn-outline-info" onclick="submitForm('<%=request.getContextPath()%>', 'classSearch');" value="Search"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">Class Name : </td>
            <td><input value="" style="width : 300px" class="form form-control" type="text" name="class_name" required="required"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Class Status :</td>
            <td style="height: 16px"><select style="width : 300px" class="form form-control" name="class_status">
				<option>Active</option>
				<option>Inactive</option>
			</select></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Student Id:</td>
            <td style="height: 16px"><input value="${student.student_id}" style="width : 300px" class="form form-control" type="text" name="student_id" required="required"></td>
            <td style="height: 16px"><input type="button" class="btn btn btn-outline-info" onclick="submitForm('<%=request.getContextPath()%>', 'studentSearchClass');" value="Search"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Student First Name:</td>
            <td style="height: 16px"><input value="${student.student_fname}" style="width : 300px" class="form form-control" type="text" name="student_fname" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Student Last Name :</td>
            <td style="height: 16px"><input value="${student.student_lname}" style="width : 300px" class="form form-control" type="text" name="student_lname" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Teacher Id :</td>
            <td style="height: 16px"><input value="" style="width : 300px" class="form form-control" type="text" name="teacher_id" required="required"></td>
            <td style="height: 16px"></td>
        </tr>
		<tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Teacher Name:</td>
            <td style="height: 16px">
            <select style="width : 300px" class="form form-control" name="teacher_fname">
            	<c:forEach var="list" items="${teacher_fname}">
            		<option value="${list.fname}">${list.fname}</option>
            	</c:forEach>
			</select></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td><input class="btn btn-primary" type="submit" value="Add Student">
            	<input class="btn btn-info" type="submit" value="Update" onclick="submitForm('<%=request.getContextPath()%>', 'Update');">
            	<input class="btn btn-danger" type="submit" value="Delete" onclick="submitForm('<%=request.getContextPath()%>', 'studentDelete');">
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
	</div>
	</form>
	<br><br>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
	</script>
</body>
</html>