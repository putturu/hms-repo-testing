package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.model.PatientCaseSheet;
import com.sapient.aem.service.PatientCaseSheetService;
import com.sapient.aem.service.PatientCaseSheetServiceImpl;
import com.sapient.aem.service.UserService;
import com.sapient.aem.service.UserServiceImpl;
import com.sapient.aem.service.Validator;

/**
 * Servlet implementation class PatientCaseSheetRegistrationServlet
 */
@WebServlet("/PatientCaseSheetRegistrationServlet")
public class PatientCaseSheetRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientCaseSheetService patientCaseSheetService = new PatientCaseSheetServiceImpl();
	private static UserService userService = new UserServiceImpl();
	private static Validator validator = new Validator();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		try {
			String patientName = request.getParameter("patientName");
			LocalDate caseSheetOpenDate =LocalDate.parse(request.getParameter("caseSheetOpenDate")) ;
			LocalDate caseSheetCloseDate =LocalDate.parse(request.getParameter("caseSheetCloseDate")) ;

			String hostipalDetails = request.getParameter("hostipalDetails");
			String healthStatistics = request.getParameter("healthStatistics");
			String symptoms = request.getParameter("symptoms");
			String prescription = request.getParameter("prescription");
			String diet = request.getParameter("diet");
			String status = request.getParameter("status");
			Integer patientid= Integer.parseInt(request.getParameter("patient-id"));
			Integer doctorid= Integer.parseInt(request.getParameter("doctor-id"));
//			String patientCaseSheetName = request.getParameter("patientCaseSheetName");
			if(validator.isValidName(patientName)) {
					PatientCaseSheet patientCaseSheet =new PatientCaseSheet(patientName,caseSheetOpenDate,caseSheetCloseDate,hostipalDetails,healthStatistics,symptoms,prescription,diet,status,patientid,doctorid);
					Integer patientCaseSheetId=patientCaseSheetService.addPatientCaseSheet(patientCaseSheet);
					if(patientCaseSheetId!=null) {

						String message ="successfully completed !";
						out.print("<html><body><h6 align=\"center\" style=\"color: green;\">"+message+"</h6></body><html>");
					}
					else {
						out.print("<html><body><h6 align=\"center\" style=\"color: red;\">Unable to add doctor</h4></body><html>");
					}
				}
				else {
					out.print("<html><body><h6 align=\"center\" style=\"color: red;\">Unauthorized user ,please register as user !</h4></body><html>");
				}
			
			request.getRequestDispatcher("WEB-INF/views/list-of-patient-case-sheets.jsp").include(request, response);
		}catch(PatientCaseSheetException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
