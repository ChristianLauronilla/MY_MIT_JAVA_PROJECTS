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
<title>Add New Section</title>
</head>
<body>
<jsp:include page="navmain.jsp"  />
	<form action="<%=request.getContextPath()%>/admin/insertSection" method="GET" id="personForm"><br><br><br>
	<div class="container">
		<h3>Add New Section</h3>
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>
	<table class="nav-justified">
        <tr>
            <td style="width: 162px">Section Name :</td>
            <td>
            <input value="${section.section_name}" style="width : 300px" class="form form-control" type="text" name="section_name" required="required">
            </td>
            <td><input type="button" class="btn btn btn-outline-info" onclick="submitForm('<%=request.getContextPath()%>', 'sectionSearch');" value="Search"></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">Student Capacity :</td>
            <td><input value="${section.section_capacity }" style="width : 300px" class="form form-control" type="number" name="section_capacity " required="required"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Status :</td>
            <td style="height: 16px"><select style="width : 300px" class="form form-control" name="section_status">
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
            <td style="width: 162px">&nbsp;</td>
            <td><input class="btn btn-primary" type="submit" value="Add Section">
            	<input class="btn btn-info" type="submit" value="Update" onclick="submitForm('<%=request.getContextPath()%>', 'sectionUpdate');">
            	<input class="btn btn-danger" type="submit" value="Delete" onclick="submitForm('<%=request.getContextPath()%>', 'sectionDelete');">
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
	</div>
	</form>
	<br><br>
	<!-- list of user -->
	<div class="container">
	<h3>List Of Section</h3>	
	<table class="table table-bordered table-striped">
		<tr>
			<td><b>Section ID</b></td>
			<td><b>Section Name</b></td>
			<td><b>Capacity</b></td>
			<td><b>Status</b></td>
		</tr>
		<c:forEach items="${records}" var="section">
			<tr>
				<td>${section.section_id}</td>
				<td>${section.section_name}</td>
				<td>${section.section_capacity}</td>
				<td>${section.section_status}</td>
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