<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="navmain.jsp"  />
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<head>

<script type="text/javascript">
  
</script>

<title>Order</title>
</head><br>
	<div class="container">
	<form action="<%=request.getContextPath()%>/user/insertOrder" method="get" id="personForm">
			<c:if test="${not empty message}">
			<div class="notification is-primary">${message}</div>
		</c:if>
		
		<table>
			<tr>
			<td style="width: 162px">Certificate :</td>
            <td style="height: 16px">
            <select style="width : 150px" id="div1" name="certificate_name_search" onchange="submitForm('<%=request.getContextPath()%>', 'certificateSearchOrder');">
	            <option> Select Certificate » </option>
	            <c:forEach var="certificate" items="${certificate}">
			       <option>${certificate.certificate_name}</option>
			    </c:forEach>
			</select>			
            </td>
            <td></td>
        	</tr>
        	<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td width="150px">Certificate : </td>
				<td>
					<input type="text" name="certificate_name" value="${certificateorder.certificate_name}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td width="150px">Certificate Amount : </td>
				<td>
					<input type="text" name="certificate_amount" value="${certificateorder.certificate_amount}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
			<tr>
				<td width="150px">Entity Name : </td>
				<td>
					<input type="text" name="entity_name" value="${order.entity_name}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td width="150px">Serial Number : </td>
				<td>
					<input type="text" name="serial_no" value="${order.serial_no}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td width="150px">Fund Cluster : </td>
				<td>
					<input type="text" name="fund_cluster" value="${order.fund_cluster}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td width="150px">Date Encoded :</td>
				<td>
					<input type="date" id="date" name="date_encoded" value="${order.date_encoded}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td width="150px">Payer Name : </td>
				<td>
					<input type="text" name="payor_name" value="${order.payor_name}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
        	<tr>
				<td width="150px">Payer Address : </td>
				<td>
					<input type="text" name="payor_address" value="${order.payor_address}">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>

        	<tr>
				<td width="150px">Prepared By : </td>
				<td>
					<input type="text" name="prepared_by" value="<%=((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername()%>">
				</td>
			</tr>
			<tr>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        	</tr>
		</table>
		<input class="button is-success is-small" type="submit" value="Add Order">
		
	</form>
	<script type="text/javascript">
		function submitForm(url, action) {
			var form = document.getElementById("personForm");
			form.action= url+"/"+action;
			form.submit();
		}
		
	</script>
	
	</div>
	