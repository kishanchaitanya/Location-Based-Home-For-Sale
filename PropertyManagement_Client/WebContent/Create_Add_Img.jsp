<%@page import="com.propertymanagement.agent.AgentManager"%>
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
		<form action="UploadImage" method="post" enctype="multipart/form-data"
			class="well">

			<h3>New Add - Images</h3>
			<br> <br> <br>
			<table cellpadding="60px" cellspacing="15px" class="">
				<tr>
					<td>Image</td>
					<td><input type="file" name="file" size="50" /> <br /> <input
						type="submit" value="Upload File" /></td>
				</tr>
				<tr>
					<td>Max Three Images Allowed</td>
				</tr>
			</table>
		</form>
		<%
			if (session.getAttribute("manager") != null) {
				AgentManager aManger = (AgentManager) session
						.getAttribute("manager");
				if (aManger.getAddInfo().getImgLocation() != null) {
		%>
		<label> Image Info</label>
		<%
			for (String info : aManger.getAddInfo().getImgLocation()) {
		%>
		<%=info%><br>
		<%
			}
				}
			}
		%>
		<br> <br> <br> <br>
		<form method="post" action="CreateAd">
			<input type="submit" class="btn btn-success" value="Post Add">
		</form>

	</center>

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
