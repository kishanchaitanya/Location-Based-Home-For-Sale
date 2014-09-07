<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<style>
body {
	background-image: url(assets/img/main-bg.jpg);
	/*You will specify your image path here.*/
	-moz-background-size: cover;
	-webkit-background-size: cover;
	background-size: cover;
	background-position: top center !important;
	background-repeat: no-repeat !important;
	background-attachment: fixed;
}
</style>

<body>
	<jsp:include page="Navbar.jsp">
		<jsp:param name="xx" value="xx" />
	</jsp:include>
	<br>
	<br>
	<center>
	<form  method="get" action="CreateAd">
		<div class="well span10">
		<h3>New Add</h3>
		<br>
		<br><br>
		<table cellpadding="60px" cellspacing="15px" class="">
			<tr>
				<td>Property Id</td>
				<td><input type="text" placeholder="PropertyId" name="pId"
					required class="form-control"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>Property Info</td>
				<td><textarea rows="4" cols="15" name="pInfo" required class="form-control">
 			</textarea></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>Property Type</td>
				<td><select name="pType" required class="form-control">
						<option value="Condo">Condo</option>
						<option value="Town House">Town House</option>
						<option value="Apartment">Apartment</option>
						<option value="Single Family Home">Single Family Home</option>
						<option value="Coop">Coop</option>
						<option value="Loft">Loft</option>
				</select></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" placeholder="Address" name="pAdd" required class="form-control"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" placeholder="City" name="pCity" required class="form-control"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>Zip</td>
				<td><input type="text" placeholder="Zip" name="pZip" required class="form-control"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>Latitude</td>
				<td><input type="text" placeholder="Latitude" name="pLat" required class="form-control"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>Longitude</td>
				<td><input type="text" placeholder="Longitude" name="pLong" required class="form-control"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="text" placeholder="Price" name="pPrice" required class="form-control"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
		</table>
		<br>
		<br>
		<br>
		<br>
		<input type="submit" class="btn btn-danger" value="Continue>>">
		</div>
	</form>
	</center>
	
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
