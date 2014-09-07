<%@page import="com.propertymanagement.buyer.BuyerManager"%>
<%@page import="com.propertymanagement.agent.AgentManager"%>
<%@page import="com.propertymanagement.DTO.UserInformation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<link href="assets/css/style.css" rel="stylesheet">
<link href="assets/css/bootstrap.css" rel="stylesheet">
<link href="assets/css/bootstrap-theme.css" rel="stylesheet">
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Display.jsp">REALTO</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<%
						if (session.getAttribute("usrGrp") != null) {
							
							if (((String)session.getAttribute("usrGrp")).equalsIgnoreCase("0")) {
					%>
							<li><font color="white"><%=((AgentManager)session.getAttribute("manager")).getAgentInfo().getAgencyName()%></font></li>
							<li><a href="Create_Add.jsp">Create Add</a></li>
							<li><a href="Agent_Adds_Display.jsp">View\Update My-Add</a></li>
							<li><a href="BuyerValue.jsp">Search Buyer</a></li>
						<%
							} else if(((String)session.getAttribute("usrGrp")).equalsIgnoreCase("1")) {%>
					
						<li><font color="white"><%=((BuyerManager)session.getAttribute("manager")).getbInfo().getfName()%> <%=((BuyerManager)session.getAttribute("manager")).getbInfo().getlName()%></font></li>
<!-- 							<li><a href="Create_Add.jsp">Add Location Pref</a></li> -->
						<%
						} %>
							<li><form method="post" action="SOut"><input type="submit" value="Signout" class="btn btn-link"></form></li>	
						<%
						}else{
					%>
					
					<li><a href="Signup.jsp">Sign up</a></li>
					<li><a href="SignIn.jsp">Sign in</a></li>
					<%
						}
					%>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</body>
</html>