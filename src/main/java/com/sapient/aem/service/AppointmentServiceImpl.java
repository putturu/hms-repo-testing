package com.sapient.aem.service;



import java.sql.SQLException;

import com.sapient.aem.dao.AppointmentDAO;
import com.sapient.aem.dao.AppointmentDaoImpl;
import com.sapient.aem.model.Appointment;



public class AppointmentServiceImpl implements AppointmentService{
	private AppointmentDAO appointmentDAO=new AppointmentDaoImpl();
	@Override
	public String addAppointment(Appointment appointment) throws Exception {
		try {
			String result=appointmentDAO.addAppointment(appointment);
			return result;
		}catch(SQLException e) {
			throw new Exception(e);
		}
	}
}