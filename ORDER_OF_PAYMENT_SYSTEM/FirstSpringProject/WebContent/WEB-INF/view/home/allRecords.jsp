<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<jsp:include page="navmain.jsp"  />
<head>
<title>List Of All Records</title>
</head><br>
	<div class="container">
	<!-- display all userr records-->
	<table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
		<tr>
			<td><b>Order ID</b></td>
			<td><b>Entity Name</b></td>
			<td><b>Serial No</b></td>
			<td><b>Fund Cluster</b></td>
			<td><b>Date Encoded</b></td>
			<td><b>Payer Name</b></td>
			<td><b>Payer Address</b></td>
			<td><b>Certificate</b></td>
			<td><b>Certificate Amount</b></td>
			<td><b>Prepared By</b></td>
			<td><b>Approved By</b></td>
			<td><b>Status</b></td>
		</tr>
		<c:forEach items="${records}" var="order">
			<tr>
				<td>${order.order_id}</td>
				<td>${order.entity_name}</td>
				<td>${order.serial_no}</td>
				<td>${order.fund_cluster}</td>
				<td>${order.date_encoded}</td>
				<td>${order.payor_name}</td>
				<td>${order.payor_address}</td>
				<td>${order.certificate_name}</td>
				<td>${order.certificate_amount}</td>
				<td>${order.prepared_by}</td>
				<td>${order.approved_by}</td>
				<td>${order.status}</td>
				
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
	