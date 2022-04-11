package com.sapient.aem.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.exception.PatientException;
import com.sapient.aem.exception.PatientHistoryException;
import com.sapient.aem.service.NumberOfDPCHService;
import com.sapient.aem.service.NumberOfDPCHServiceImpl;

/**
 * Servlet implementation class AdminHomeServlet
 */
@WebServlet("/AdminHomeServlet")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NumberOfDPCHService numberOfDPCHService = new NumberOfDPCHServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer doctors;
		try {
			doctors = numberOfDPCHService.countOfDoctors();
			Integer patients = numberOfDPCHService.countOfPatients();
			Integer caseSheets = numberOfDPCHService.pateintCaseSheetCount();
			Integer history = numberOfDPCHService.pateintHistoryCount();
			request.setAttribute("doctors", doctors);
			request.setAttribute("patients", patients);
			request.setAttribute("caseSheets", caseSheets);
			request.setAttribute("history", history);
			request.getRequestDispatcher("WEB-INF/views/admin-dashboard.jsp")
											.forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
