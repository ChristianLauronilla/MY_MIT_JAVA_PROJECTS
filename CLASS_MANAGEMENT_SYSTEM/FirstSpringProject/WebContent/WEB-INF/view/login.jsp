<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
	.form-signin{
		width: 100%;
		max-width: 330px;
		padding: 23px;
		margin-top: 0px;
		margin-left: 90px;
	}
</style>
<title>Login</title>
</head>
<body class="text-center">
<style>
	.bg-light{
		background-color : #ffea58 !important;
	}
</style>
<nav class="navbar navbar-expand-lg navbar-light fixed-top bg-light">
	<div class="container">
      <a class="navbar-brand" href="http://localhost:8080/FirstSpringProject/user/home">CMS</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">          
        </ul>
        <ul class="nav navbar-nav navbar-right">
               <li class="nav-item">
               	<a class="nav-link" href="http://localhost:8080/FirstSpringProject/user/home">Sign In</a>
               </li>
         </ul>
      </div>
      <hr />
      </div>
    </nav>
    <br><br>
    <form class="form-signin" action="j_spring_security_check" method="POST">
    <br>
    <c:if test="${not empty message}">
		<div class="alert alert-danger">${message}</div>
	</c:if>
      <h1 class="h4 mb-4 font-weight-normal">Class Management System</h4>
      <label for="inputEmail" class="sr-only">User Name</label>
      <input type="text" class="form-control" placeholder="Username" name="j_username" required="required" autofocus="">
      <br>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" class="form-control" placeholder="Password" name="j_password" required="required">
      <br>
      <button class="btn btn-lg btn-primary btn-block btn-raised" type="submit" >Sign in</button>
    </form>
</body>
</html>