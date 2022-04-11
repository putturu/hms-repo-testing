<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
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
<link href="css/add-doc.css" rel="stylesheet">
<script type="text/javascript" src="./js/patient-validate.js"></script>
</head>
<body>
	<div class="container d-flex flex-column justify-content-center">
		<h4 align="center" class="heading">Patient Registration Form</h4>
		<div class="reg-container ">
			<form class="" method="post" action="PatientRegistrationServlet"
				onsubmit="return validate()">
				<div class="container">
					<div class="row">
					<div class="form-group col-12 col-lg-6">
							<label for="patient_name">User Name</label> <input type="text"
								id="username" value="${user.userName}" name="userName"
								placeholder="Enter First Name Here.." readonly="readonly" class="form-control"
								onblur="isValidPName()">
						</div>
						<div class="form-group col-12 col-lg-6">
							<label for="patient_name">password</label> <input type="password"
								id="password" value="${user.password}" name="password"
								placeholder="Enter First Name Here.." readonly="readonly" class="form-control"
								onblur="isValidPName()">
						</div>
						<div class="form-group col-12 col-lg-6">
							<label for="patient_name">role</label> <input type="text"
								id="role" value="${user.role}" name="role"
								placeholder="Enter First Name Here.." readonly="readonly" class="form-control"
								onblur="isValidPName()">
						</div>
						<div class="form-group col-12 col-lg-6">
							<label for="patient_name">Patient Name</label> <input type="text"
								id="pname" name="patient_name"
								placeholder="Enter First Name Here.." class="form-control"
								onblur="isValidPName()">
						</div>
						<div class="form-group col-12 col-lg-3">
							<label for="gender">Gender</label> <select name="gender"
								class="form-control" id="gender">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
								<option value="Other">Other</option>
							</select>
						</div>
						<div class="form-group col-12 col-lg-4">
							<label for="bloodGroup">Blood Group</label> <select
								name="blood_group" class="form-control" id="bloodGroup">
								<option value="A+ve">A+ve</option>
								<option value="B+ve">B+ve</option>
								<option value="O+ve">O+ve</option>
								<option value="A-ve">A-ve</option>
								<option value="B-ve">B-ve</option>
								<option value="O-ve">O-ve</option>
							</select>
						</div>
						<div class="form-group col-12 col-lg-5">
							<label for="birthdate">Date of Birth</label> <input type="date"
								name="birthdate" class="form-control" id="Bithdate"
								placeholder="Ex : 2022-01-20" size="30" required
								pattern="[0-9]{4}-[0-9]{2}-[0-9]{2}" />
						</div>
						<div class="form-group col-12 col-lg-6">
							<label for="mobile">Phone Number</label> <input type="text"
								name="mobile" id="mobile"
								placeholder="Enter Phone Number Here.." class="form-control"
								onblur="isValidMobile()">
						</div>
						<div class="form-group col-12 col-lg-6">
							<label for="email">Email Address</label> <input type="text"
								name="email" id="email" placeholder="Enter Email Address Here.."
								class="form-control" onblur="isValidEmail()">
						</div>
						<div class="form-group col-12">
							<label for="address">Address</label>
							<textarea name="address" id="address"
								placeholder="Enter Address Here.." rows="3" class="form-control"></textarea>
						</div>
						<div class="d-flex flex-row justify-content-start ">
							<button type="submit" class="btn btn-lg btn-success mr-2">Register</button>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</body>
</html>

