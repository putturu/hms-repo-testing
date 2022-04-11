package com.sapient.aem.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.service.DoctorService;
import com.sapient.aem.service.DoctorServiceImpl;

/**
 * Servlet implementation class GotoBookAppointmentServlet
 */
@WebServlet("/GotoBookAppointmentServlet")
public class GoToBookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DoctorService doctorService = new DoctorServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			Integer doctorId = Integer.parseInt(request.getParameter("id"));
			Integer patientId = Integer.parseInt(request.getParameter("patientId"));
			String userName = request.getParameter("userName");
			request.setAttribute("patientId", patientId);
			Doctor doctor = doctorService.getDoctorById(doctorId);
			request.setAttribute("doctor", doctor);
			request.getRequestDispatcher("./WEB-INF/views/book-appointment.jsp").forward(request, response);
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
