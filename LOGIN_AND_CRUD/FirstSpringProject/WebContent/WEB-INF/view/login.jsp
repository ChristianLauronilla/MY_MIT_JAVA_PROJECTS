<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
<link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
<style>
	.form-signin{
		width: 100%;
		max-width: 330px;
		padding: 15px;
		margin: 0 auto;
	}
</style>
<title>Login</title>
</head>
<body class="text-center">
	<c:if test="${not empty message}">
		<div class="alert alert-danger">${message}</div>
	</c:if>
    <form class="form-signin" action="j_spring_security_check" method="POST">
    <br><br><br>
      <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
      <label for="inputEmail" class="sr-only">User Name</label>
      <input type="text" class="form-control" placeholder="Username" name="j_username" required="required" autofocus="">
      <br>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" class="form-control" placeholder="Password" name="j_password" required="required">
      <br><br>
      <button class="btn btn-lg btn-info btn-block btn-raised" type="submit" >Sign in</button>
    </form>
</body>
</html>