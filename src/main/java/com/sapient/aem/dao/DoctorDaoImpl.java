package com.sapient.aem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sapient.aem.model.Doctor;

public class DoctorDaoImpl implements DoctorDAO{

	@Override
	public Doctor getDoctorById(Integer doctorId) throws SQLException {
		Connection connection =null;
		try  {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.GET_DOCTOR_BY_ID);
			preparedStatement.setInt(1, doctorId);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				Doctor doctor= new Doctor();

				populateDoctor(resultSet,doctor);
				return doctor;				
			}else {
				return null;
			}

		}catch(SQLException e) {

			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}


	private void populateDoctor(ResultSet resultSet,Doctor doctor) throws SQLException{
		doctor.setDoctorId(resultSet.getInt("doctor_id"));
		doctor.setDoctorName(resultSet.getString("doctor_name"));
		doctor.setSpecialization(resultSet.getString("specialization"));
		doctor.setAvailableTiming(resultSet.getString("available_timings"));
		doctor.setQualification(resultSet.getString("qualification"));
		doctor.setExperienceInYears(resultSet.getInt("experience_in_years"));
		doctor.setMobile(resultSet.getLong("mobile"));
		doctor.setEmail(resultSet.getString("email"));
		doctor.setLocation(resultSet.getString("location"));
		doctor.setUserName(resultSet.getString("user_name"));

	}


	@Override
	public List<Doctor> getAllDoctors() throws SQLException {
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet= statement.executeQuery(QueryMapper.GET_ALL_DOCTORS);
			int rowcount=0;
			if ( resultSet.last()) {
				rowcount =  resultSet.getRow();
				resultSet.beforeFirst(); // not  resultSet.first() because the  resultSet.next() below will move on, missing the first element
			}
			List<Doctor> doctorList=new ArrayList<>();			
			while(resultSet.next()) {
				Doctor doctor=new Doctor();
				populateDoctor(resultSet,doctor);
				doctorList.add(doctor);		
			}

			return doctorList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}

	@Override
	public Integer addDoctor(Doctor doctor) throws SQLException {
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.ADD_DOCTOR);

			preparedStatement.setString(1,doctor.getDoctorName());
			preparedStatement.setString(2,doctor.getSpecialization());
			preparedStatement.setString(3,doctor.getAvailableTiming());
			preparedStatement.setString(4,doctor.getQualification());
			preparedStatement.setInt(5,doctor.getExperienceInYears());
			preparedStatement.setLong(6,doctor.getMobile());
			preparedStatement.setString(7,doctor.getEmail());
			preparedStatement.setString(8,doctor.getLocation());
			preparedStatement.setString(9,doctor.getUserName());

			int n=preparedStatement.executeUpdate();

			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException("Unable to add record");
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
	private Integer getMaxId()  throws SQLException{
		String sql="select max(doctor_id) from doctor";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= connection.createStatement();
			ResultSet resultSet=statement.executeQuery(sql);

			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new SQLException("No records in the table");
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}





	@Override
	public String updateDoctor(Doctor doctor) throws SQLException {
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.UPDATE_DOCTOR);


			preparedStatement.setString(1,doctor.getEmail());
			preparedStatement.setString(2,doctor.getAvailableTiming());
			preparedStatement.setLong(3,doctor.getMobile());
			preparedStatement.setInt(4, doctor.getDoctorId());


			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "DoctorId "+doctor.getDoctorId()+" updated";
			}else {
				return "Unable to update DoctorId: "+doctor.getDoctorId();
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public String deleteDoctor(Integer doctorId) throws SQLException {
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.DELETE_DOCTOR);

			preparedStatement.setInt(1, doctorId);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "DoctorId:"+doctorId+" deleted from database";
			}else {
				return "Unable to delete DoctorId: "+doctorId;
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}


	@Override
	public List<Doctor> searchDoctor(String string) throws SQLException {
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.SEARCH_DOCTOR);
			preparedStatement.setString(1, string);
			preparedStatement.setString(2, string);
			ResultSet resultSet = preparedStatement.executeQuery();
			List<Doctor> doctorList=new ArrayList<>();	
			while(resultSet.next()) {
				Doctor doctor= new Doctor();
				populateDoctor(resultSet,doctor);
				doctorList.add(doctor);				
			}

			return doctorList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}
	}


	@Override
	public Integer countOfDoctors() throws SQLException {
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= connection.createStatement();
			ResultSet resultSet=statement.executeQuery(QueryMapper.COUNT_OF_DOCTORS);

			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new SQLException("No records in the table");
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}


	@Override
	public Integer getDoctorIdByUserName(String userName) throws SQLException {
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(QueryMapper.GET_DOCTOR_ID_BY_USERNAME);
			preparedStatement.setString(1, userName);
			ResultSet resultSet=preparedStatement.executeQuery();
			if(resultSet.next()) {
				return resultSet.getInt(1);
			}else {
				throw new SQLException("No records in the table");
			}
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}



}
