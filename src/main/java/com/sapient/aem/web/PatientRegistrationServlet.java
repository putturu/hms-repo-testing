package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Patient;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;

@WebServlet("/PatientRegistrationServlet")
public class PatientRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserService userService = new UserServiceImpl();
	private static PatientService pateintService = new PatientServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String patientname= request.getParameter("patient_name");
			String gender= request.getParameter("gender");
			LocalDate birthdate= LocalDate.parse(request.getParameter("birthdate"));
			String bloodgroup=request.getParameter("blood_group");
			Long mobile=Long.parseLong(request.getParameter("mobile"));
			String email=request.getParameter("email");
			String address=request.getParameter("address");
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			Role role = Role.PATIENT;
			Patient patient = new Patient(patientname,gender,birthdate,bloodgroup,mobile,address,email,userName);
			User user = new User(userName,password,role);
			userService.addUser(user);
			if(userService.isValidUser(userName, role)) {
				pateintService.addPatient(patient);
				String message ="sing up successfully completed ! Please  sing in";
				out.print("<html><body><h6 align=\"center\" style=\"color: green;\">"+message+"</h6></body><html>");
			}else {
				out.print("<html><body><h6 align=\"center\" style=\"color: red;\">Unauthorized user ,please register as user !</h4></body><html>");
			}
			request.getRequestDispatcher("login.html").include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
