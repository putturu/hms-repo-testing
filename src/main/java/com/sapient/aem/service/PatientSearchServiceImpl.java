package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.PatientSearchDAO;
import com.sapient.aem.dao.PatientSearchDaoImpl;
import com.sapient.aem.exception.PatientHistoryException;
import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public class PatientSearchServiceImpl implements PatientSearchService{
	private static PatientSearchDAO patientSearchDAO = new PatientSearchDaoImpl();
	@Override
	public List<Doctor> searchByDoctorNameAndSpecialization(String doctorName) throws SQLException {
		try {
			List<Doctor> result= patientSearchDAO.searchByDoctorNameAndSpecialization(doctorName);
			return result; 
		}catch(SQLException e) {
			throw new SQLException(e.getMessage(),e);
		}
	}
	@Override
	public List<PatientHistory> getHistoryByPatientId(Integer patientId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Doctor> searchBySpecializationAndLocation(String specialization, String location) throws SQLException {
		try {
			List<Doctor> result= patientSearchDAO.searchBySpecializationAndLocation(specialization,location);
			return result;	
		}catch(SQLException e) {
			throw new SQLException(e.getMessage(),e);
		}
	}

}
