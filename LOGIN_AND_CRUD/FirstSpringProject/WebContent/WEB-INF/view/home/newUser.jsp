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
<title>Add New User</title>
</head>
<body>
<jsp:include page="navmain.jsp"  />
<title>Add New User</title>
	<form action="<%=request.getContextPath()%>/admin/insertUserr" method="GET"><br><br><br>
	<div class="container">
		<h1>Add New User</h1>
		<c:if test="${not empty message}">
			<div class="alert alert-info">${message}</div>
		</c:if>
	<table class="nav-justified">
        <tr>
            <td style="width: 162px">User name :</td>
            <td><input style="width : 300px" class="form form-control" type="text" name="username" path="username" required="required"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;"></td>
            <td style="height: 16px"></td>
            <td style="height: 16px"></td>
        </tr>
        <tr>
            <td style="width: 162px">Password :</td>
            <td><input style="width : 300px" class="form form-control" type="password" name="password" path="password" required="required"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px; height: 16px;">Name :</td>
            <td style="height: 16px"><input style="width : 300px" class="form form-control" type="text" path="name" name="name" required="required"></td>
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
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td><input class="btn btn-raised btn-info" type="submit" value="Add"></td>
            <td>&nbsp;</td>
        </tr>
    </table>
	</div>
	</form>
	
	<div class="container">
		<footer>
		<hr>
	        <p>OOP - CHRISTIAN LAURONILLA - 2019 </p>
	    </footer>
    </div>
</body>
</html>