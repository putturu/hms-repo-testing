package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.Role;
import com.sapient.aem.model.User;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;
import com.sapient.aem.service.Validator;
@WebServlet("/DoctorRegistrationServlet")
public class DoctorRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DoctorService doctorService = new DoctorServiceImpl();
	private static UserService userService = new UserServiceImpl();
	private static Validator validator = new Validator();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String specilization = request.getParameter("specilization"),
			availabletimings = request.getParameter("availabletimings"),
			qualification = request.getParameter("qualification"),
			email = request.getParameter("email"),
			role = request.getParameter("role");
			Integer expirience = Integer.parseInt(request.getParameter("expirience"));
			Long mobileNumber = Long.parseLong(request.getParameter("mobileNumber"));
			Role myRole=null;
			String doctorName = request.getParameter("doctorName");
			String location= request.getParameter("location");
			String userName= request.getParameter("userName");
			String password = request.getParameter("password");
			if(validator.isValidName(doctorName)) {
				if(validator.isValidEmail(email)) {
					if(role.equals("DOCTOR")) {
						myRole= Role.DOCTOR;
						User user = new User(userName,password,myRole);
						userService.addUser(user);
						if(userService.isValidUser(userName, myRole)) {
							Integer  s=doctorService.addDoctor(new Doctor(doctorName,specilization,availabletimings,qualification,expirience,mobileNumber,email,location,userName));
							String message ="sing up successfully completed ! Please  sing in";
							out.print("<html><body><h6 align=\"center\" style=\"color: green;\">"+message+"</h6></body><html>");
						}
						else {
							out.print("<html><body><h6 align=\"center\" style=\"color: red;\">Unauthorized user ,please register as user !</h4></body><html>");
						}
					}
					else {
						out.print("<html><body><h6 align=\"center\"  style=\"color: red;\">please select role ! Sign Up agian.</h6></body><html>");
					}
				}
				else {
					out.print("<html><body><h6 align=\"center\"  style=\"color: red;\">invalid mail! Sign Up agian.</h6></body><html>");
				}

			}else {
				out.print("<html><body><h6 align=\"center\"  style=\"color: red;\">invalid name ! Sign Up agian.</h6></body><html>");
			}
			request.getRequestDispatcher("login.html").include(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
