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

import com.sapient.aem.model.PatientCaseSheet;

public class PatientCaseSheetDaoImpl implements PatientCaseSheetDAO {
	@Override
	public PatientCaseSheet getPatientCaseSheetById(Integer patientCaseSheetId) throws SQLException {
		Connection connection=null;
		try {
			//JNDI
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.GET_PATIENT_CASE_SHEET_BY_ID);

			preparedStatement.setInt(1, patientCaseSheetId);
			ResultSet resultSet= preparedStatement.executeQuery();
			if(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				//copy contents contents of resultset object into employee object
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				return patientCaseSheet;				
			}else {
				return null;
			}

		}catch(SQLException e) {
			//			e.printStackTrace();
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}

	private void populatePatientCaseSheet(ResultSet resultSet, PatientCaseSheet patientCaseSheet) throws SQLException{
		
		patientCaseSheet.setPatientCaseSheetId(resultSet.getInt("patient_case_sheet_id"));
		patientCaseSheet.setPatientName(resultSet.getString("patient_name"));
		patientCaseSheet.setCaseSheetOpenDate(resultSet.getDate("case_sheet_open_date").toLocalDate());
		patientCaseSheet.setCaseSheetCloseDate(resultSet.getDate("case_sheet_close_date").toLocalDate());
		patientCaseSheet.setHostipalDetails(resultSet.getString("hostipal_details"));
		patientCaseSheet.setHealthStatistics(resultSet.getString("health_statistics"));
		patientCaseSheet.setSymptoms(resultSet.getString("symptoms"));
		patientCaseSheet.setPrescription(resultSet.getString("prescription"));
		patientCaseSheet.setDiet(resultSet.getString("diet"));
		patientCaseSheet.setStatus(resultSet.getString("status"));
		patientCaseSheet.setPatientId(resultSet.getInt("patient_id"));
		patientCaseSheet.setDoctorId(resultSet.getInt("doctor_id"));

	}

	@Override
	public List<PatientCaseSheet> getPatientCasesheet() throws SQLException {
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			Statement statement= 
					connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);

			ResultSet resultSet= statement.executeQuery(QueryMapper.GET_ALL_PATIENT_CASE_SHEETS);
			int rowcount=0;
			if ( resultSet.last()) {
				rowcount =  resultSet.getRow();
				resultSet.beforeFirst(); // not  resultSet.first() because the  resultSet.next() below will move on, missing the first element
			}
			List<PatientCaseSheet> patientCaseSheetList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				patientCaseSheetList.add(patientCaseSheet);				
			}

			return patientCaseSheetList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}

	}

	@Override
	public Integer addPatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException {
		String sql= "insert into patient_case_sheet(patient_name,case_sheet_open_date ,case_sheet_close_date ,hostipal_details ,health_statistics,symptoms,prescription,diet,status,patient_id,doctor_id)values(?,?,?,?,?,?,?,?,?,?,?)";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(QueryMapper.ADD_PATIENT_CASE_SHEET);

			//replace the place holders
			preparedStatement.setString(1, patientCaseSheet.getPatientName());
			preparedStatement.setString(2,patientCaseSheet.getCaseSheetOpenDate().toString());
			preparedStatement.setString(3,patientCaseSheet.getCaseSheetCloseDate().toString());
			preparedStatement.setString(4, patientCaseSheet.getHostipalDetails());
			preparedStatement.setString(5, patientCaseSheet.getHealthStatistics());
			preparedStatement.setString(6, patientCaseSheet.getSymptoms());
			preparedStatement.setString(7, patientCaseSheet.getPrescription());
			preparedStatement.setString(8, patientCaseSheet.getDiet());
			preparedStatement.setString(9, patientCaseSheet.getStatus());
			preparedStatement.setInt(10, patientCaseSheet.getPatientId());
			preparedStatement.setInt(11, patientCaseSheet.getDoctorId());
			int n=preparedStatement.executeUpdate();


			if(n>0) {
				return this.getMaxId();
			}else {
				throw new SQLException("Unable to add record");
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
	public String updatePatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException {
		String sql="update patient_case_sheet set patient_name=?, case_sheet_open_date =?,case_sheet_close_date=?,hostipal_details=?,health_statistics=?, symptoms=?,prescription=?,diet=?,status=?,patient_id=?,doctor_id=? where patient_case_sheet_id=?";
		Connection connection=null;
		try {
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			
			preparedStatement.setString(1, patientCaseSheet.getPatientName());
			preparedStatement.setString(2,patientCaseSheet.getCaseSheetOpenDate().toString());
			preparedStatement.setString(3,patientCaseSheet.getCaseSheetCloseDate().toString());
			preparedStatement.setString(4, patientCaseSheet.getHostipalDetails());
			preparedStatement.setString(5, patientCaseSheet.getHealthStatistics());
			preparedStatement.setString(6, patientCaseSheet.getSymptoms());
			preparedStatement.setString(7, patientCaseSheet.getPrescription());
			preparedStatement.setString(8, patientCaseSheet.getDiet());
			preparedStatement.setString(9, patientCaseSheet.getStatus());
			preparedStatement.setInt(10, patientCaseSheet.getPatientId());
			preparedStatement.setInt(11, patientCaseSheet.getDoctorId());
			preparedStatement.setInt(12, patientCaseSheet.getPatientCaseSheetId());

			int n = preparedStatement.executeUpdate();
			if(n>0) {
				return "PatientCaseSheetId: "+ patientCaseSheet.getPatientCaseSheetId()+" updated";
			}else {
				return "Unable to update patientCaseSheetId: "+ patientCaseSheet.getPatientCaseSheetId();
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
	public String deletePatientCaseSheet(Integer patientCaseSheetId) throws SQLException {
		String sql="delete from patient_case_sheet where patient_case_sheet_id=?";
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setInt(1, patientCaseSheetId);
			int n= preparedStatement.executeUpdate();
			if(n>0) {
				return "PatientCaseSheetId"+patientCaseSheetId+" deleted from database";
			}else {
				return "Unable to delete empno: "+patientCaseSheetId;
			}

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	private Integer getMaxId()  throws SQLException{
		String sql="select max( patient_case_sheet_id) from  patient_case_sheet";
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
	public List<PatientCaseSheet> getPatientCaseSheetByDoctorId(Integer doctorId) throws SQLException {
		String sql= "select * from patient_case_sheet where doctor_id=?";
		Connection connection=null;
		try {

			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1,doctorId);

			ResultSet resultSet= preparedStatement.executeQuery();
			
			List<PatientCaseSheet> patientCaseSheetList=new ArrayList<>();			
			while(resultSet.next()) {
				PatientCaseSheet patientCaseSheet= new PatientCaseSheet();
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				patientCaseSheetList.add(patientCaseSheet);				
			}

			return patientCaseSheetList;

		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}

	@Override
	public List<PatientCaseSheet> getPatientCaseSheetByPatientCaseSheetId(Integer patientCaseSheetId)
			throws SQLException {
		String sql="select * from patient_case_sheet where patient_case_sheet_id=?";
		
		PatientCaseSheet patientCaseSheet = new PatientCaseSheet();
		Connection connection=null;
		try{
			Context envContext = (Context) new InitialContext().lookup("java:comp/env");		
			DataSource dataSource = (DataSource) envContext.lookup("jdbc/hmsDB");
			connection= dataSource.getConnection();
			PreparedStatement preparedStatement= connection.prepareStatement(sql);

			preparedStatement.setInt(1, patientCaseSheetId);
			ResultSet resultSet =preparedStatement.executeQuery();
			List<PatientCaseSheet> patientCaseSheetList=new ArrayList<>();
			while(resultSet.next()) {
				populatePatientCaseSheet(resultSet,patientCaseSheet);
				patientCaseSheetList.add(patientCaseSheet);
	
			}
		
			return patientCaseSheetList;
		}catch(SQLException e) {
			throw e;
		}catch(Exception e) {
			throw new SQLException(e.getMessage());
		}finally {
			connection.close();
		}
	}
}
