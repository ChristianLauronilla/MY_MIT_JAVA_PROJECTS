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
<title>Home</title>
</head>
<body>
	<jsp:include page="navmain.jsp"  />
	<br><br>
	<div class="jumbotron">
    <div class="container">
      <h1 class="display-3">Hello, <%=((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()%>!</h1>
      <p><b>Classroom management systems</b> are effective because they increase student success by creating an orderly learning environment that enhances students' academic skills and competencies, as well as their social and emotional development</p>
      <p><a class="btn btn-primary btn" href="<%=request.getContextPath()%>/user/viewClass" role="button">Learn more »</a></p>
    </div>
  </div>
</body>
</html>