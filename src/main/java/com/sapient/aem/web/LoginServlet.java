package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.exception.PatientException;
import com.sapient.aem.exception.PatientHistoryException;
import com.sapient.aem.exception.UserException;
import com.sapient.aem.model.Role;
import com.sapient.aem.service.NumberOfDPCHService;
import com.sapient.aem.service.NumberOfDPCHServiceImpl;
import com.sapient.aem.service.PatientService;
import com.sapient.aem.service.PatientServiceImpl;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger= Logger.getLogger(LoginServlet.class);
	private UserService userService= new UserServiceImpl();
	private NumberOfDPCHService numberOfDPCHService = new NumberOfDPCHServiceImpl();
	private PatientService patientService = new PatientServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out= response.getWriter();
		try {
			String username= request.getParameter("username");
			String password=  request.getParameter("password");
			String role= request.getParameter("role");
			Role myRole=null;
			if(role.equals("ADMIN")) {
				myRole= Role.ADMIN;
			}else if(role.equals("DOCTOR")) {
				myRole=Role.DOCTOR;
			}else if(role.equals("PATIENT")) {
				myRole=Role.PATIENT;
			}
			else {
				myRole=null;
			}
			if(userService.isValidUser(username, password, myRole)==true) {
				HttpSession session= request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("role", role);
				logger.info(username+" logged at"+ new Date());

				if(role.equals("ADMIN")) {
					Integer doctors = numberOfDPCHService.countOfDoctors();
					Integer patients = numberOfDPCHService.countOfPatients();
					Integer caseSheets = numberOfDPCHService.pateintCaseSheetCount();
					Integer history = numberOfDPCHService.pateintHistoryCount();
					request.setAttribute("doctors", doctors);
					request.setAttribute("patients", patients);
					request.setAttribute("caseSheets", caseSheets);
					request.setAttribute("history", history);
					request.getRequestDispatcher("WEB-INF/views/admin-dashboard.jsp")
													.forward(request, response);
				}else if(role.equals("DOCTOR")) {
					request.getRequestDispatcher("WEB-INF/views/doctor-dashboard.jsp")
					.forward(request, response);
				}else if(role.equals("PATIENT")){
					Integer patientId=patientService.getPatientIdByUserName(username);
					request.setAttribute("patientId",patientId);
					request.getRequestDispatcher("WEB-INF/views/patient-dashboard.jsp")
					.forward(request, response);
				}
				else {
					out.println("<html><body><h2>"+"Invalid Role"+"</h2></body></html>");
				}
			
			
			}else {
				out.println("<html><body><h2>"+"Invalid Credentials. Login Again"+"</h2></body></html>");
				request.getRequestDispatcher("login.html").include(request, response);
				
			}
			
		}catch(UserException e) {
			logger.error(e.getMessage(),e);
		} catch (DoctorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PatientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PatientCaseSheetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PatientHistoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
