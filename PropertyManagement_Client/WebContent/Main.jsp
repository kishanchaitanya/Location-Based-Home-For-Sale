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

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3 well">

				<jsp:include page="Search_Add.jsp">
					<jsp:param name="xx" value="xx" />
				</jsp:include>


			</div>
			<div class="span9">
				<%
					if (session.getAttribute("centerPage") != null) {
						String val = (String) session.getAttribute("centerPage");
				%>

				<jsp:include page="<%=val%>">
					<jsp:param name="xx" value="xx" />
				</jsp:include>
				<%
					}
				%>
			</div>
		</div>
	</div>


			<jsp:include page="Agent_Adds_Display.jsp">
				<jsp:param name="xx" value="xx" />
			</jsp:include>
			<jsp:include page="Create_Add_Img.jsp">
				<jsp:param name="xx" value="xx" />
			</jsp:include>
</body>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
</html>