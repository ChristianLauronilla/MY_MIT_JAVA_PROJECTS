<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bulma/0.7.5/css/bulma.min.css">
<script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<br />
<div class="container">
<nav class="breadcrumb" aria-label="breadcrumbs">
  <ul>
    <li><a href="<%=request.getContextPath()%>/user/home">Order Of Payment System</a></li>
    <li><a href="<%=request.getContextPath()%>/admin/listUser">User</a></li>
    <li><a href="<%=request.getContextPath()%>/admin/certificate">Certificate</a></li>
    <li><a href="<%=request.getContextPath()%>/admin/forApproval">For Approval</a></li>
    <li><a href="<%=request.getContextPath()%>/admin/allRecords">All Records</a></li>
    <li><a href="<%=request.getContextPath()%>/user/newOrder">New Order</a></li>
    <li><a class="dropdown-item" href="<%=request.getContextPath()%>/j_spring_security_logout">Logout</a></li>
  </ul>
</nav>
<hr />
</div>