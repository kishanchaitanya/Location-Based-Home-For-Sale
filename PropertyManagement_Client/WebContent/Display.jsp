
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
<style>
html,body,#map-canvas {
	height: 400px;
	width: 900px margin:  0px;
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
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBo4uWkbt2sj0oa0YAMPUphcmqFpD4FrfQ&sensor=FALSE"></script>
<script>
// This example displays a marker at the center of Australia.
// When the user clicks the marker, an info window opens.

function initialize() {
  var myLatlng = new google.maps.LatLng(39.50,-98.35);
  var mapOptions = {
    zoom: 4,
    center: myLatlng
  };

  var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);


      <%if(session.getAttribute("newsFeed")!=null)
      {
    	  List<AdvertsimentInfo> aList=(List<AdvertsimentInfo>)session.getAttribute("newsFeed");
    	  int counter=1;
    	  for(AdvertsimentInfo aInfo:aList)
    	  {
    		  counter++;%>
  					var contentString<%out.print(counter);%> = '<div id="content">' + '<%out.print(aInfo.getPropertyInfo());%>'+'<br>' + '<%out.print(aInfo.getPropertyType());%>'+'<br>'+'<%out.print(aInfo.getAddress());%>'+'<br>'+'<%out.print(aInfo.getCityName());%>'+'<br>'+'<%out.print(aInfo.getZipCode());%>'+'<br>'+'</div>';
	 
  var infowindow<%out.print(counter);%> = new google.maps.InfoWindow({
      content: contentString<%out.print(counter);%>
  });
  
  var myLatlng<%out.print(counter);%> = new google.maps.LatLng(<%out.print(aInfo.getLat());%>,<%out.print(aInfo.getLang());%>);
  var marker<%out.print(counter);%> = new google.maps.Marker({
      position: myLatlng<%out.print(counter);%>,
      map: map,
      title: '<%out.print(aInfo.getPropertyType());%>'
  });
  google.maps.event.addListener(marker<%out.print(counter);%>, 'click', function() {
    infowindow<%out.print(counter);%>
	.open(map,marker<%out.print(counter);%>	);
				});
<%}
			}%>
	}

	google.maps.event.addDomListener(window, 'load', initialize);
</script>
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

				<jsp:include page="Search_Add.jsp">
					<jsp:param name="xx" value="xx" />
				</jsp:include>


			</div>


			<div class="span9">
			
				<center>

					<font color="white"> <b>
							<h1>Recently Added</h1>
					</b>
					</font>
				</center>
		<div id="map-canvas" >slmndsdln</div>

				<%
					AgentAddSearchCriteria searchInfo = new AgentAddSearchCriteria();
					if (session.getAttribute("newsFeed") != null) {
						searchInfo.setSearchedList((List<AdvertsimentInfo>) session
								.getAttribute("newsFeed"));
					}
				%>

				<%
					List<AdvertsimentInfo> addList = searchInfo.getSearchedList();
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
								<img src="http://localhost:8080/PropertyManagement_Client/images/<%=addList.get(i).getImgLocation().get(0)%>"
									>
								<h3><%=addList.get(i).getPropertyType()%></h3>
								<h4><%=addList.get(i).getPropertyInfo()%></h4>
							</div>
						</li>

						<%
							}
						%>
					</ul>
				</div>

			</div>
		</div>
	</div>



</body>

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
</html>