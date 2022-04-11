<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<h2>patient details</h2>
	 <form action="SearchPatienHistory" class="mt-2">
     <input type="text" name="search" placeholder="search...."/>
     <button type="submit">search</button>
     </form>
	<table border="1px"class="table table-dark mt-2">
		<tr>
			<th>patient id</th>
			<th>patient name</th>
			<th>gender</th>
			<th>birthdate</th>
			<th>bloodGroup</th>
			<th>mobile</th>
			<th>adress</th>
			<th>email</th>
			<th>Edit</th>
			<th>Delete</th>
			<th>View<th>
		</tr>
		<c:forEach var="p" items="${patient}">
			<tr>
				<td>${p.patientId}</td>
				<td>${p.patientName}</td>
				<td>${p.gender}</td>
				<td>${p.birthdate}</td>
				<td>${p.bloodGroup}</td>
				<td>${p.mobile}</td>
				<td>${p.address}</td>
				<td>${p.email}</td>
				<td><a href="updateservlet?id=${p.patientId }">edit</a></td>
				<td><a href="DeletePatientServlet?id=${p.patientId }">delete</a></td>
				<td><a href="ViewPatientDetails?id=${p.patientId }">View</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>