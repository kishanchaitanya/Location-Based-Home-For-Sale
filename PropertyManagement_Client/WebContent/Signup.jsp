
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sign in &middot; Twitter Bootstrap</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Le styles -->
<link href="assets/css/bootstrap.css" rel="stylesheet">
<style type="text/css">
body {
	padding-top: 40px;
	padding-bottom: 40px;
	background-color: #f5f5f5;
}

.form-signin {
	max-width: 300px;
	padding: 19px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .form-signin-heading,.form-signin .checkbox {
	margin-bottom: 10px;
}

.form-signin input[type="text"],.form-signin input[type="password"] {
	font-size: 16px;
	height: auto;
	margin-bottom: 15px;
	padding: 7px 9px;
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
<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="../assets/js/html5shiv.js"></script>
    <![endif]-->


</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="Landing.jsp">REALTO</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">

				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<br>
	<br>
	<br>
	<div class="container">

		<form class="form-signin" action="SignUpp" method="post">
			<h2 class="form-signin-heading">Please sign up</h2>
			<input type="text" class="input-block-level" placeholder="Username"
				name="uName" required> <input type="password"
				class="input-block-level" placeholder="Password" required
				name="uPass"> <input type="password"
				class="input-block-level" placeholder="Re - Password" required
				name="uRPass"> <input type="radio" value="1" name="uType"
				checked> Buyer <input type="radio" value="0" name="uType">
			Agent <br> <br> <label> <%
 	if (session.getAttribute("Lerror") != null) {
 %> <%
 	}
 %>
			</label>
			<button class="btn btn-large btn-danger" type="submit">Continue>></button>

		</form>

	</div>
	<!-- /container -->

	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>

</body>
</html>
