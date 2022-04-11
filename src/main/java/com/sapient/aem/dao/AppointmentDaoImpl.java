package com.sapient.aem.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Appointment;



public class AppointmentDaoImpl implements AppointmentDAO {



	@Override
	public String addAppointment(Appointment appointment) throws SQLException {
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.ADD_APPOINTMENT);

			preparedStatement.setDate(1,java.sql.Date.valueOf(appointment.getAppointmentDate()));
			preparedStatement.setTime(2,java.sql.Time.valueOf(appointment.getAppointmentTime()));
			preparedStatement.setString(3,appointment.getAppointmentLocation());
			preparedStatement.setInt(4,appointment.getDoctorId());
			preparedStatement.setInt(5,appointment.getPatientId());


			int n=preparedStatement.executeUpdate();

			if(n>0) {
				return "Appointment is Booked Succesfully";
			}else {
				throw new SQLException("Unable to book Appointment");
			}
		}catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());

		}finally {
			connection.close();
		}
	}





}