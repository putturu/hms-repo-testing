<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
<head>
<title>Title</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://use.fontawesome.com/04855142ca.js"></script>
</head>
<style>
.card {
	flex: 0 0 300px;
	padding-top: 10px;
	margin: 10px;
	border: 1px solid #ccc;
	background-color: #1c2329e4;
	color: aliceblue;
	box-shadow: 2px 2px 6px 0px rgba(0, 0, 0, 0.3);
}

.card:hover {
	box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2);
}

.container {
	padding: 2px 16px;
}

.cards {
	display: flex;
	flex-wrap: wrap;
}
</style>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" style="color: white;">Admin  ${username}</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="#">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Patient </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="#">Add Patient</a> <a
							class="dropdown-item" href="PatientDetaislServlet">All
							Patients</a> <a class="dropdown-item"
							href="PatientDetailsByIdServlet">Search by id</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Doctor </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="AddDoctorServlet">Add Doctor</a> <a
							class="dropdown-item" href="ListOfDoctor">All Doctors</a> <a
							class="dropdown-item" href="#">Search by id</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Patient case </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="AddPatientCaseServlet">Add Patient case</a> <a
							class="dropdown-item" href="ListOfPatientcaseSheets">All
							Patient case</a> <a class="dropdown-item" href="#">Search by id</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Patient History </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item" href="GoToAddPatientHistoryServlet">Add
							Patient History</a> <a class="dropdown-item"
							href="ListOfPatientHistory">Patient History</a> <a
							class="dropdown-item" href="#">Search by id</a>
					</div></li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
			<div class="ml-2">
				<a href="LogoutServlet">Logout</a>
			</div>
		</div>
	</nav>
	<div>
		<div class="cards">

			<div class="card">
				<div class="container">
					<div>
						<i class="fa fa-user-md fa-3x" aria-hidden="true"></i>
					</div>
					<h4>
						<b>DOCTORS</b>
					</h4>
					<p>${doctors}</p>
				</div>
			</div>
			<div class="card">
				<div class="container">
					<i class="fa fa-wheelchair fa-3x" aria-hidden="true"></i>
					<h4>
						<b>PATIENTS</b>
					</h4>
					<p>${patients}</p>
				</div>
			</div>
			<div class="card">
				<div class="container">
					<i class="fa fa-check fa-3x" aria-hidden="true"></i>
					<h4>
						<b>ACTIVE CASES</b>
					</h4>
					<p>${caseSheets}</p>
				</div>
			</div>
			<div class="card">
				<div class="container">
					<i class="fa fa-history fa-3x" aria-hidden="true"></i>
					<h4>
						<b>OLD CASES</b>
					</h4>
					<p>${history }</p>
				</div>
			</div>

		</div>
		<div></div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>