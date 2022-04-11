<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<form action="PatientByIdServlet">
				enter patient id <input type="number" name="patientId">
				<button tyep="submit" value="submit">Get</button>
		</div>
	</div>
	</form>
	patient id : ${patient.patientId}
	<br> name : ${patient.patientName}
	<br> gender: ${patient.gender}
	<br> Birthdate : ${patient.birthdate}
	<br> blood Group : ${patient.bloodGroup}
	<br> mobile :${patient.mobile}
	<br> address : ${patient.address}
	<br> email: ${patient.email}
	<br>
</body>
</html>