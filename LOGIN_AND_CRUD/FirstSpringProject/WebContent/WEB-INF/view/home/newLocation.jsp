<jsp:include page="navmain.jsp"  />
<title>Add New Location</title>
	<form action="<%=request.getContextPath()%>/user/insertLocation" method="get"><br><br><br>
	<div class="container">
		<h1>Add New Location</h1>	
	<table class="nav-justified">
        <tr>
            <td style="width: 162px">Location name :</td>
            <td><input style="width : 300px" class="form form-control" type="text" name="location" required="required"></td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td>&nbsp;</td>
            <td>&nbsp;</td>
        </tr>
        <tr>
            <td style="width: 162px">&nbsp;</td>
            <td><input class="btn btn-raised btn-info" type="submit" value="Add"></td>
            <td>&nbsp;</td>
        </tr>
    </table>
	</div>
	</form>
	
	<div class="container">
		<footer>
		<hr>
	        <p>OOP - CHRISTIAN LAURONILLA - 2019 </p>
	    </footer>
    </div>