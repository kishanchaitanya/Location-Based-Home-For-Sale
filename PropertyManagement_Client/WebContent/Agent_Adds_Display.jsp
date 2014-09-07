
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
<title>REALTO & CO.</title>
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

			<div class="span9">


				<%
					if (session.getAttribute("manager") != null) {
						AgentManager aManager = (AgentManager) session
								.getAttribute("manager");
						if (aManager.getAgentInfo().getAddList() != null
								&& aManager.getAgentInfo().getAddList().size() > 0) {
				%>

				<%
					List<AdvertsimentInfo> addList = aManager.getAgentInfo()
									.getAddList();
				%>

				<br> <br> <br>
				<div class="row-fluid">
					<ul class="thumbnails">
						<%
							for (int i = 0; i < addList.size(); i++) {
						%>

						<%
							if (i % 3 == 0 && i != 0) {
						%>
					</ul>
				</div>
				<div class="row-fluid">
					<ul class="thumbnails">
						<%
							}
						%>
						<li class="span4">

							<div class="thumbnail">
								<%
									if (addList.get(i).getImgLocation() != null) {
								%>
								<img src="http://localhost:8080/PropertyManagement_Client/images/<%=addList.get(i).getImgLocation().size() > 0 ? addList.get(i).getImgLocation().get(0)	: ""%>"
									width="100" height="100">
								<%
									}
								%>
								<h3><%=addList.get(i).getPropertyType()%></h3>
								<h4><%=addList.get(i).getPropertyInfo()%></h4>
								<form class="" method="post" action="VAdd">
									<input type="hidden"
										value="<%=addList.get(i).getPropertyId()%>" name="pId">
									<center>
										<input type="submit" value="View>>" class="btn btn-danger">
									</center>
								</form>
							</div>
						</li>

						<%
							}
						%>
					</ul>
				</div>
				<%
					} else {
				%>
				<font color="white">
					<h3>No Adds Posted Yet</h3>
				</font>
				<%
					}
					}
				%>
			</div>
		</div>