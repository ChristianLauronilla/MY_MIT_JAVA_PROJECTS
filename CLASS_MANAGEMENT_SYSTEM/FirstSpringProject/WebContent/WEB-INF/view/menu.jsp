<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/">
		<input type="text" name="homeParam">
		<input type="submit" value="Home">
	</form>
	<br>
	<form action="<%=request.getContextPath()%>/" method="post">
		<input type="text" name="dashboardParam">
		<input type="submit" value="Dashboard">
	</form>
</body>
</html>