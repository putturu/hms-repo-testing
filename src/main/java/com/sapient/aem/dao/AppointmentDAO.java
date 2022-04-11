package com.sapient.aem.dao;



import java.sql.SQLException;



import com.sapient.aem.model.Appointment;



public interface AppointmentDAO {
public abstract String addAppointment(Appointment appointment) throws SQLException;
}