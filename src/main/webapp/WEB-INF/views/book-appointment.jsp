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
<link href="css/appoint.css" rel="stylesheet">
<script type="text/javascript" src="js/validate.js"></script>
</head>
<body>
	<div class="container d-flex flex-column justify-content-center">

		<h4 align="center" class="heading">Appointment Form</h4>
		<div class="reg-container ">

			<form class="" method="post" action="BookAppointmentServlet">
				<div class="container p-3">
					<div class="row">
					<div class="form-group col-12 col-md-6 col-lg-4">
							<label for="docId">Doctor Id</label>
							<div class="input-group">
								<input type="number" class="form-control" name="doctorId"
									id="doctorId" value="${doctor.doctorId}" readonly="readonly" />
							</div>
							<p id="p2"></p>
						</div>
					
						<div class="form-group col-12 col-md-7 col-lg-4">
							<label for="appointmentDate">Appointment Date</label>
							<div class="input-group">
								<input type="date" class="form-control" name="appointmentDate"
									id="appointmentDate" placeholder="Select Date" />
							</div>
						</div>

						<div class="form-group col-12 col-md-4 col-lg-4">
							<label for="appointmentTime">Appointment Time</label>
							<div class="input-group">
								<input type="time" class="form-control" name="appointmentTime"
									id="appointmentTime" placeholder="Enter your  Available Time" />
							</div>
						</div>

						<div class="form-group col-12 col-md-5 col-lg-4">
							<label for="location">Location</label>
							<div class="input-group">
								<input type="text" value="${doctor.location}" class="form-control" name="location"
									id="location" readonly="readonly" />
							</div>
						</div>

						
						<div class="form-group col-12 col-md-8 col-lg-4">
							<label for="patientId">Patient Id</label>
							<div class="input-group">
								<input type="text" class="form-control"  value="${patientId }" name="patientId"
									id="patientId" readonly="readonly" />
							</div>
							<p id="p3"></p>
						</div>

					</div>
				</div>
				<div class="form-group ">
					<input type="submit" name="Submit"
						class="btn btn-primary btn-lg  login-button m-3" value="Submit">
				</div>
			</form>

		</div>
	</div>


</body>
</html>