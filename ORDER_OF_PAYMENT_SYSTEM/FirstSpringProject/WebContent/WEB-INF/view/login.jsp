<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.min.css">
<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<title>Login</title>
</head>
<body class="text-center">
    <br><br><br>
	<div class="container">
    <c:if test="${not empty message}">
		<div class="alert alert-danger">${message}</div>
	</c:if>
    <form class="" action="j_spring_security_check" method="POST">
    <h1>Login</h1>
        
    <hr />
     <table class="w-100">
        <tr>
            <td width="100px">
                <div class="field">
				  <label class="label">Username</label>				  
				</div>
            </td>
            <td>
            	<div class="control">
				  <input type="text" placeholder="Username" name="j_username" required="required" autofocus="">
			  </div>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>
                <label class="label">Password</label>	
            </td>
            <td>
                <input type="password" placeholder="Password" name="j_password" required="required">
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>
                <button class="button is-primary" type="submit" >Sign in</button>
            </td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
    </table>
    </form>
    </div>
</body>
</html>