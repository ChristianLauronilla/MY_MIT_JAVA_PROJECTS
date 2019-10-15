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
<title>Class Assignment</title>
<style>
	#div2 {
 display:none;
}
</style>
</head>
<body>
<jsp:include page="navmain.jsp"  />
	<form action="<%=request.getContextPath()%>/admin/assign" method="GET" id="personForm"><br><br><br>
	<div class="container">
		<h3>Class Assignment</h3>
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>
	<table class="nav-justified">
        <tr>
            <td style="width: 162px"></td>
            <td>
            <select style="width : 300px" class="form form-control" name="student_id" onchange="submitForm('<%=request.getContextPath()%>', 'studentSearchAssign');">
            	<option>SELECT STUDENT »</option>
				<c:forEach var="student" items="${studentname}">
			       <option value="${student.student_id}">${student.student_id}</option>   
			   	</c:forEach>
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
            <td style="width: 162px">Student Id:</td>
            <td>
            <input value="${student.student_id}" style="width : 300px" class="form form-control" type="text" name="student_id_name" required="required">
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">Student Name:</td>
            <td>
            <input value="${student.student_fname}, ${student.student_lname}" style="width : 300px" class="form form-control" type="text" name="student_name" required="required">
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">Section :</td>
            <td style="height: 16px">
            <select style="width : 300px" class="form form-control" name="section_name">
	            <c:forEach var="section" items="${sectionname}">
			       <option>${section.section_name}</option>   
			    </c:forEach>
			</select>
            </td>
            <td></td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">Teacher :</td>
            <td>
            <select style="width : 300px" class="form form-control" name="teacher_username">
				 <c:forEach var="teacher" items="${teachername}">
			       <option>${teacher.username}</option>   
			   	</c:forEach>
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
            <td>
            <input class="btn btn-primary" type="submit" value="Assign">
            </td>
            <td>&nbsp;</td>
        </tr>
    </table>
	</div>
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