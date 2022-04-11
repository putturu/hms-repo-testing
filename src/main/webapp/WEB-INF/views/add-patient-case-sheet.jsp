<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Registration Form</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Josefin+Slab&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	font-family: "Josafin Slab", serif;
}

nav {
	width: 100%;
	height: 14vh;
	background: rgb(0 0 0/ 58%);
	color: white;
	display: flex;
	justify-content: space-between;
	align-items: center;
	text_transform: uppercase;
}
/*            nav .logo{
                           align:center;       
                        }*/
nav .logo-text {
	width: 25%;
	text-align: center;
	position: relative;
}

nav .menu {
	width: 70%;
	height: 5vh;
	font-size: 20px;
	display: flex;
	justify-content: flex-end;
}

nav .menu a {
	width: 10%;
	text-decoration: none;
	color: white;
	font-weight: bold;
}

select {
	display: block;
	width: 100%;
	height: 34px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-shadow: 0 1px 1px rgba(0, 0, 0, .075);
}

.button-1 {
	width: 25%;
	border: none;
	border-radius: 4px;
	color: white;
	display: block;
	padding: 12px;
	font-size: 16px;
	background-color: cornflowerblue;
}

.button-1:hover {
	background-color: #2691d9;
}

.footer {
	position: absolute;
	width: 100% !important;
	background-color: #353535;
	color: white;
	text-align: center;
	bottom: -310;
	padding: 35px 50px;
	padding-top: 0px;
	padding-right: 50px;
	padding-bottom: -0;
	padding-left: 20px;
}

.container {
	font-size: 17px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h2 style="text-align: center">Patient Case Sheet Registration
						Form</h2>
				</div>
				<div class="panel-body">

					<form action="PatientCaseSheetRegistrationServlet" method="post">

						<div class="form-group">
							<label>Enter Patient name</label> 
							<input type="text" class="form-control" name="patientName" placeholder="Enter patient name">
						</div>
						<div>
							<label>Case Sheet Open Date</label> <input type="date" class="form-control" name="caseSheetOpenDate" placeholder="case sheet open date">
						</div>
						
						<div>
						<label>Case Sheet Close Date</label> <input type="date" class="form-control" name="caseSheetCloseDate" placeholder="case sheet close date">
				</div>
				<div class="form-group">
					<label>Enter hostipal details</label> <input type="text"
						class="form-control" name="hostipalDetails"
						placeholder="Enter hostipal details">
				</div>
				<div class="form-group">
					<label>Enter your health statistics</label> <input type="text"
						class="form-control" name="healthStatistics"
						placeholder="Enter your health statistics">
				</div>
				<div class="form-group">
					<label>symptoms </label> <input type="text" class="form-control"
						name="symptoms" placeholder="symptoms ">
				</div>

				<div class="form-group">
					<label>prescription</label> <input type="text" class="form-control"
						name="prescription" placeholder="prescription">
				</div>
				<div class="form-group">
					<label>diet</label> <input type="text" class="form-control"
						name="diet" placeholder="diet">
				</div>
				<div class="form-group">
					<label>status</label> <input type="text" class="form-control"
						name="status" placeholder="status">
				</div>



				<div class="form-group">
					<label>Patient Id</label> <input type="text" class="form-control"
						name="patient-id" placeholder="patient id">
				</div>

				<div class="form-group">
					<label>Doctor Id</label> <input type="text" class="form-control"
						name="doctor-id" placeholder="doctor id">
				</div>

				<div class="form-group mt-3">
					<select name="role" class="form-control">
						<option value="">Select Role</option>
						<option value="PATIENT">Patient</option>
					</select>
				</div>
				<div class="form-group">
					<button class="button-1" type="submit" name="dregister"
						value="sdgsdfg">Register</button>
				</div>
				</form>
			</div>
		</div>
	</div>

</body>

</html>