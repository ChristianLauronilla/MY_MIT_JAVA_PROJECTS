<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navmain.jsp"  />
<head>
<title>List Of Certificate</title>
</head><br>
	<div class="container">
	<form action="<%=request.getContextPath()%>/admin/insertCertificate" method="get" id="personForm">
		<table>
			<tr>
				<td width="100px">Certificate ID : </td>
				<td><input type="text" name="certificate_id" value="${certificate.certificate_id}">
				<input type="button" class="btn btn-raised btn-default" onclick="submitForm('<%=request.getContextPath()%>', 'certificateSearch');" value="Search"></td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td>Certificate Name : </td>
				<td><input type="text" name="certificate_name" value="${certificate.certificate_name}"></td>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td>Certificate Amount: </td>
				<td><input type="number" name="certificate_amount" value="${certificate.certificate_amount}"></td>
			</tr>
				<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>	
		</table>
		<input class="button is-success is-small" type="submit" value="Add">
		<input type="button" class="button is-warning is-small" onclick="submitForm('<%=request.getContextPath()%>', 'certificateUpdate');" value="Update">
		<input type="button" class="button is-danger is-small" onclick="submitForm('<%=request.getContextPath()%>', 'certificateDelete');" value="Delete">
		
	</form>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
		
	</script>
	<!-- display all userr records-->
	<table class="table is-bordered is-striped is-narrow is-hoverable is-fullwidth">
		<tr>
			<td><b>Certificate ID</b></td>
			<td><b>Certificate Name</b></td>
			<td><b>Certificate Amount</b></td>
		</tr>
		<c:forEach items="${records}" var="certificate">
			<tr>
				<td>${certificate.certificate_id}</td>
				<td>${certificate.certificate_name}</td>
				<td>${certificate.certificate_amount}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	