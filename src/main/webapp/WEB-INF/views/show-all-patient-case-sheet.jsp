<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2 align="center">Patient Case Sheet List</h2>
		<form action="addPatientCaseSheetPage">
			<div class="form-group" align="left">
				<button type="submit" class="btn btn-primary">Add Patient Case Sheet</button>
			</div>
		</form>
		<table class="table">
			<thead>
				<tr>					
					<th>PatientCaseSheetId</th>
					<th>PatientCaseSheetName</th>
					<th>caseSheetOpenDate</th>
					<th>caseSheetCloseDate</th>
					<th>hostipalDetails</th>
					<th>healthStatistics</th>										
					<th>symptoms</th>
					<th>prescription</th>
					<th>diet</th>
					<th>status</th>
					<th>patientId</th>
					<th>doctorId</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
			    <%-- <c:forEach> is a jstl core tag that iterates through a list --%>
				<%-- we are able to iterate through an arraylist
				     using jstl tag without writing any Java code --%>
				<c:forEach var="pc" items="${patientCaseSheetList}">
					<tr class="success">						
						<td>${pc.patientCaseSheetId}</td>
						<td>${pc.patientName}</td>
						<td>${pc.caseSheetOpenDate}</td>
						<td>${pc.caseSheetCloseDate}</td>
						<td>${pc.hostipalDetails}</td>	
						<td>${pc.healthStatistics}</td>	
						<td>${pc.symptoms}</td>
						<td>${pc.prescription}</td>		
						<td>${pc.diet}</td>	
						<td>${pc.status}</td>	
						<td>${pc.patientId}</td>	
						<td>${pc.doctorId}</td>			
						<td><a href="editPatientCaseSheet?id=${pc.patientCaseSheetId}">edit</a></td>
						<td><a href="deletePatientCaseSheet?id=${pc.patientCaseSheetId}">delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>