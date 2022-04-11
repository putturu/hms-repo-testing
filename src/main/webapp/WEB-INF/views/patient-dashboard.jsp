<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
<link href="css/nav.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

		<div class="icon-container">
			<img
				src="https://www.kindpng.com/picc/m/127-1272273_doctors-logo-black-and-white-vector-png-download.png"
				class="logo" />
		</div>

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon "> </span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">

			<ul class="navbar-nav p-3">

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle text-white" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Patient </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item text-dark" href="PatientDetaislServlet">All
							Patients</a>

					</div></li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item ml-lg-auto">
					<form class="form-inline my-2 my-lg-0" action="SearchDoctorServlet"
						method="post">
						<input class="form-control mr-sm-2" type="text" name="search"
							placeholder="Search for doctors or sepcialities or qualification"
							aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>
				</li>
			</ul>
			<ul class="navbar-nav ml-auto">
				<li class="nav-item ml-lg-auto"><a class="nav-link text-white"
					href="LogoutServlet"><button class="btn btn-outline-info"
							type="button">Logout</button></a></li>
			</ul>
		</div>
	</nav>
	<div class="doc-bottom-container">
		<h1 class="heading">Patient DashBoard</h1>
		<h6 align="center">${message}</h6>
		<div class="container" style="width: 500px; height: 500px;">

			<form action="DoctorSearchBySpecializationAndLocationServlet"
				class="mt-4">
				<div class="form-group">
					<input type="text" class="form-control" name="specialization"
						id="specialization" aria-describedby="helpId"
						placeholder="specialization">
				</div>



				<div class="form-group">
					<input type="text" class="form-control" name="location"
						id="location" aria-describedby="helpId" placeholder="location">
				</div>
				<input type="text" hidden name="patientId" value="${patientId}">
				<button type="submit">Search</button>
			</form>



		</div>
	</div>
</body>
</html>