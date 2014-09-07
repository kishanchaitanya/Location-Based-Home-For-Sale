
<%@page import="com.propertymanagement.agent.AgentManager"%>
<%@page import="com.propertymanagement.DTO.AdvertsimentInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.propertymanagement.agent.AgentAddSearchCriteria"%>
<%@page import="java.util.List"%>



<%@page import="com.propertymanagement.DTO.AdvertsimentInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.propertymanagement.agent.AgentAddSearchCriteria"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<link href="assets/css/bootstrap.css" rel="stylesheet">
</head>
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
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row-fluid">

			<div class="span15 well">


				<%
					if (session.getAttribute("addInfo") != null) {
						AdvertsimentInfo addInfo = (AdvertsimentInfo) session
								.getAttribute("addInfo");
				%>
				<center>
					<h1><%=addInfo.getPropertyType()%></h1>

					<br> <br> <br> <br> <img
						src="images/<%=addInfo.getImgLocation().size() > 0 ? addInfo
						.getImgLocation().get(0) : ""%>"
						alt="images/4.jpg" height="50%;" width="300px;"> <img
						src="images/<%=addInfo.getImgLocation().size() > 1 ? addInfo
						.getImgLocation().get(1) : ""%>"
						alt="images/4.jpg" height="50%;" width="300px;"> <img
						src="images/<%=addInfo.getImgLocation().size() > 2 ? addInfo
						.getImgLocation().get(2) : ""%>"
						alt="images/4.jpg" height="50%;" width="300px;"> <br> <br> <br> <br>


					<table cellpadding="10px" cellspacing="100px">
						<tr>
							<td>Property Id</td>
							<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><%=addInfo.getPropertyId()%></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td>Property Info</td>
							<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><%=addInfo.getPropertyInfo()%></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td>Property Type</td>
							<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><%=addInfo.getPropertyType()%></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td>Address</td>
							<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><%=addInfo.getAddress()%></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td>City</td>
							<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><%=addInfo.getCityName()%></td>
						</tr>

						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td>Zip Code</td>
							<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><%=addInfo.getZipCode()%></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td>Price</td>
							<td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</td>
							<td><%=addInfo.getPrice()%></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td><br></td>
						</tr>
						<tr>
							<td><a href="AddDisplay.jsp" class="btn btn-success"><< Back</a></td>
							
							<td></td>
						</tr>
					</table>
					<br>
					<br>
					<br>
					<label>Contact Agent</label>
					<form method="post" action="AMail">
					<textarea rows="10" cols="100" name="MailC"></textarea>
					<br>
					<input type="submit" value="Send Mail" class="btn btn-danger"></form>
				</center>
				<br> <br> <br>
				<%
					}
				%>
			</div>
		</div>
	</div>
	</div>
	</div>

</body>
</html>
