<%@page import="java.util.ArrayList"%>
<%@page import="com.propertymanagement.buyer.BuyerInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>REALTO & CO.</title>
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<style>
html,body,#map-canvas {
	height: 400px;
	width: 900px margin:   0px;
	padding: 0px
}

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
</head>
<body>
	<jsp:include page="Navbar.jsp">
		<jsp:param name="xx" value="xx" />
	</jsp:include>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>


	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3 well">

				<jsp:include page="SearchBuyer.jsp">
					<jsp:param name="xx" value="xx" />
				</jsp:include>


			</div>
			<div class="span8 well">
				<%
					if (session.getAttribute("searchedBuyer") != null) {
						List<BuyerInfo> bInfo = (List<BuyerInfo>) session
								.getAttribute("searchedBuyer");
						for (BuyerInfo bObj : bInfo) {
				%>
				<form method="get" action="AMail">
					<%=bObj.getfName()%>
					<%=bObj.getlName()%>
					<br>
					<textarea rows="10" cols="100" name="mailVal"></textarea>
					<br>
					<input type="hidden" value="<%=bObj.getEmailInfo()%>" name="eMail">
					<input type="submit" value="Send Mail" class="btn btn-success">
				</form>
				<br>
				<br>
				<br>
				<%
					}
					}
				%>
			</div>
		</div>
	</div>
</body>
</html>