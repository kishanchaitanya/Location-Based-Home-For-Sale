<%@page import="com.propertymanagement.DTO.AdvertsimentInfo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REALTO & CO.</title>
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
		<%
			AdvertsimentInfo addInfo = (AdvertsimentInfo) session
					.getAttribute("addInfo");
		%>
		<form class="well" action="AddMod" method="post">
			<table cellpadding="100px" cellspacing="150px" class="">
				<tr>
					<td>Property Id</td>
					<td><input type="text" placeholder="Property Id"
						class="form-control" required 
						value="<%=addInfo.getPropertyId()%>" disabled name="pId"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Property Info</td>
					<td><input type="text" placeholder="Property Info"
						class="form-control" required value="<%=addInfo.getPropertyInfo()%>"
						name="pInfo"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Property Type</td>
					<td><select name="pType" required class="form-control"
						value="<%=addInfo.getPropertyType()%>">
							<option value="Condo">Condo</option>
							<option value="Town House">Town House</option>
							<option value="Apartment">Apartment</option>
							<option value="Single Family Home">Single Family Home</option>
							<option value="Coop">Coop</option>
							<option value="Loft">Loft</option>
					</select></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" placeholder="Address"
						class="form-control" value="<%=addInfo.getAddress()%>" required
						name="pAddress"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>City</td>
					<td><input type="text" placeholder="City" class="form-control"
						required name="pCity" value="<%=addInfo.getCityName()%>"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Zip Code</td>
					<td><input type="text" placeholder="City" class="form-control"
						required name="pZip" value="<%=addInfo.getZipCode()%>"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Longitude</td>
					<td><input type="text" placeholder="Longitude"
						class="form-control" required name="pLang"
						value="<%=addInfo.getLang()%>"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>Latitude</td>
					<td><input type="text" placeholder="Latitude"
						class="form-control" required name="pLat"
						value="<%=addInfo.getLat()%>"></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
				</tr>
				<tr>
				<td>Price</td>
				<td><input type="text" placeholder="Price" name="pPrice" required class="form-control" value="<%=addInfo.getPrice()%>"></td>
			</tr>
			<tr>
				<td>
				&nbsp;
				</td>
			</tr>
			</table>
			<button type="submit" class="btn btn-success">Modify</button>
		</form>
	</center>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>