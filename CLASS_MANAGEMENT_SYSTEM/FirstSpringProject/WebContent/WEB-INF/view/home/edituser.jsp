<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Collection"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit User</title>
</head>
<body>
<jsp:include page="navmain.jsp"  />
	<br><br><br>
	<div class="container">
		<h1>Edit User</h1>
	<form:form method="POST" action="<%=request.getContextPath()%>/admin/saveEditUserr">  
      	<table >  
         <tr>  
          <td></td> 
          <td><form:input placeholder="Username" type="text" class="form form-control" path="username"  /></td>
         </tr>  
         <tr>  
          <td></td>  
          <td><form:input placeholder="Name" class="form form-control" path="name" /></td>
         </tr> 
         <tr>  
          <td></td>  
          <td><form:input placeholder="Role" class="form form-control" path="role" /></td>
         </tr> 
         <tr>  
         <tr>
          <td></td>  
          <td><input class="btn btn-info btn-raised" type="submit" value="update" /></td>  
         </tr>  
        </table>  
       </form:form>  
	</div>
	
	<div class="container">
		<footer>
		<hr>
	        <p>OOP - CHRISTIAN LAURONILLA - 2019 </p>
	    </footer>
    </div>
</body>
</html>