package com.sapient.aem.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.PatientSearchService;
import com.sapient.aem.service.PatientSearchServiceImpl;

/**
 * Servlet implementation class DoctorSearchBySpecializationAndLocationServlet
 */
@WebServlet("/DoctorSearchBySpecializationAndLocationServlet")
public class DoctorSearchBySpecializationAndLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static PatientSearchService patientSearchService=new PatientSearchServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String location=request.getParameter("location");
			Integer patientId = Integer.parseInt(request.getParameter("patientId"));
			String specialization=request.getParameter("specialization");
			List<Doctor> doctorList=patientSearchService.searchBySpecializationAndLocation(specialization, location);
			if(doctorList!=null) {
			request.setAttribute("patientId", patientId);
			request.setAttribute("doctor", doctorList);
			request.getRequestDispatcher("./WEB-INF/views/display-doctors.jsp").forward(request, response);
			}
			else {
				String message="No result found !";
				request.setAttribute("message", message);
				request.getRequestDispatcher("./WEB-INF/views/display-doctors.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



}
