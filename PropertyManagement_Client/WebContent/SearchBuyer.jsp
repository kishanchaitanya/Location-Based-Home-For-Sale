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
<body>
	<br>
	<br>

	<form class="well" method="get" action="SAdd">
		<label><h3>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Search Buyer</h3></label>
		<table cellpadding="60px" cellspacing="15px" class="">
			<tr>
				<td>Address</td>
				<td><input type="text" placeholder="Address"
					class="form-control" name="pAddress"><br></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" placeholder="City"
					class="form-control" name="pCity"><br></td>
			</tr>
			<tr>
				<td>Zip Code</td>
				<td><input type="text" placeholder="Zip" class="form-control" name="pZip"
					><br></td>
			</tr>
		</table>

		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button type="submit" class="btn btn-warning">Search >></button>
	</form>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>