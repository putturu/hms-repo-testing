package com.sapient.aem.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;
import com.sapient.aem.service.PatientHistoryService;
import com.sapient.aem.service.PatientHistoryServiceImpl;
import com.sapient.aem.service.PatientSearchService;
import com.sapient.aem.service.PatientSearchServiceImpl;

/**
 * Servlet implementation class SearchPatienHistory
 */
@WebServlet("/SearchPatienHistory")
public class SearchPatienHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientHistoryService  patientHistoryService = new PatientHistoryServiceImpl();
	private static  PatientSearchService  patientSearchService = new PatientSearchServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		try {
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
