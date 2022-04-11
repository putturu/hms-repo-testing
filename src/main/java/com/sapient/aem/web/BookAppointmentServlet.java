package com.sapient.aem.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.aem.model.Appointment;
import com.sapient.aem.service.AppointmentService;
import com.sapient.aem.service.AppointmentServiceImpl;

/**
 * Servlet implementation class BookAppointmentServlet
 */
@WebServlet("/BookAppointmentServlet")
public class BookAppointmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AppointmentService appointmentService = new AppointmentServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer doctorId = Integer.parseInt(request.getParameter("doctorId"));
			LocalDate date = LocalDate.parse(request.getParameter("appointmentDate"));
			LocalTime time = LocalTime.parse(request.getParameter("appointmentTime"));
			String location = request.getParameter("location");
			Integer patientId = Integer.parseInt(request.getParameter("patientId"));
			Appointment appointment = new Appointment(date,time,location,patientId,doctorId);
			String message=appointmentService.addAppointment(appointment);
			request.setAttribute("message", message);
			request.getRequestDispatcher("./WEB-INF/views/patient-dashboard.jsp").forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
