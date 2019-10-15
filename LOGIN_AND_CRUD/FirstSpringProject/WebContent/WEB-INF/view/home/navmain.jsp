<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Material+Icons">
<link rel="stylesheet" href="https://unpkg.com/bootstrap-material-design@4.1.1/dist/css/bootstrap-material-design.min.css" integrity="sha384-wXznGJNEXNG1NFsbm0ugrLFMQPWswR3lds2VeinahP8N0zJw9VWSopbjv2x7WCvX" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
<script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<div class="container">
      <a class="navbar-brand" href="http://localhost:8080/FirstSpringProject/user/home">WBPPoS</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">          
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">User</a>
            <div class="dropdown-menu" aria-labelledby="dropdown08">
              <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/newUser">New User</a>
              <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/listUser">List</a>
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Location</a>
            <div class="dropdown-menu" aria-labelledby="dropdown08">
              <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/newLocation">New Location</a>
              <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/listLocation">List</a>
            </div>
        </li>
        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="dropdown08" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Category</a>
            <div class="dropdown-menu" aria-labelledby="dropdown08">
              <a class="dropdown-item" href="<%=request.getContextPath()%>/user/newCategory">New Category</a>
              <a class="dropdown-item" href="<%=request.getContextPath()%>/admin/listCategory">List</a>
            </div>
        </li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
               <li class="nav-item dropdown">
                   <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="caret"><%=((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()%>
					<c:if test="${user.role eq 'ROLE_ADMIN'}">
						<a href="/admin/delete?id=???"></a>
					</c:if></span></a>
                   <div class="dropdown-menu" aria-labelledby="dropdown08">
                       <a class="dropdown-item" href="<%=request.getContextPath()%>/j_spring_security_logout">Logout</a>
                   </div>
               </li>
         </ul>
      </div>
      <hr />
      </div>
    </nav>