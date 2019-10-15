<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<jsp:include page="navmain.jsp"  />
<head>
<title>List Of Approval</title>
</head><br>
	<div class="container">
	<form action="<%=request.getContextPath()%>/admin/updateApprove" method="get" id="personForm">
		<c:if test="${not empty message}">
			<div class="notification is-primary">${message}</div>
		</c:if>
	
		<table>
			<tr>
				<td width="100px">Entity Name : </td>
				<td><input type="text" name="entity_name" value="${order.entity_name}">
				<input type="button" class="btn btn-raised btn-default" onclick="submitForm('<%=request.getContextPath()%>', 'admin/orderSearch');" value="Search"></td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td>Serial No : </td>
				<td><input type="text" name="serial_no" value="${order.serial_no}"></td>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td>Payer : </td>
				<td><input type="text" name="payor_name" value="${order.payor_name}"></td>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td>Prepared By : </td>
				<td><input type="text" name="prepared_by" value="${order.prepared_by}"></td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td width="150px">Approve By : </td>
				<td>
					<input type="text" name="approved_by" value="<%=((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()%>">
				</td>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
		</table>
		<input class="button is-success is-small" type="submit" value="Approve">
		<input type="button" class="button is-danger is-small" onclick="submitForm('<%=request.getContextPath()%>', 'admin/updateDecline');" value="Decline">
	</form>

	<!-- display all userr records-->
	<table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
		<tr>
			<td><b>Order ID</b></td>
			<td><b>Entity Name</b></td>
			<td><b>Serial No</b></td>
			<td><b>Fund Cluster</b></td>
			<td><b>Date Encoded</b></td>
			<td><b>Payer Name</b></td>
			<td><b>Certificate</b></td>
			<td><b>Prepared By</b></td>
		</tr>
		<c:forEach items="${records}" var="order">
			<tr>
				<td>${order.order_id}</td>
				<td>${order.entity_name}</td>
				<td>${order.serial_no}</td>
				<td>${order.fund_cluster}</td>
				<td>${order.date_encoded}</td>
				<td>${order.payor_name}</td>
				<td>${order.certificate_name}</td>
				<td>${order.prepared_by}</td>
			</tr>
		</c:forEach>
	</table>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
		
	</script>
	</div>
	