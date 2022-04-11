package com.sapient.aem.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.model.PatientCaseSheet;
import com.sapient.aem.service.PatientCaseSheetService;
import com.sapient.aem.service.PatientCaseSheetServiceImpl;

/**
 * Servlet implementation class ListOfPatientcaseSheets
 */
@WebServlet("/ListOfPatientcaseSheets")
public class ListOfPatientcaseSheets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientCaseSheetService patientCaseSheetService= new PatientCaseSheetServiceImpl();
	private Logger logger= Logger.getLogger(ListOfPatientcaseSheets.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			List<PatientCaseSheet> patientCaseSheetList=  patientCaseSheetService.getPatientCasesheet();

			request.setAttribute("patientCaseSheetList", patientCaseSheetList);
			request.getRequestDispatcher("WEB-INF/views/list-of-patient-case-sheets.jsp")
			.include(request, response);

		}catch(PatientCaseSheetException e) {
			logger.error(e.getMessage(),e);
		}catch(Exception e) {
			logger.error(e.getMessage(),e);
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
