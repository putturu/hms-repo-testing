package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.Doctor;
import com.sapient.aem.model.PatientHistory;

public interface PatientSearchService {
	public abstract List<Doctor> searchByDoctorNameAndSpecialization(String doctorName) throws SQLException;
	public abstract List<PatientHistory> getHistoryByPatientId(Integer patientId) throws SQLException;
	public abstract List<Doctor> searchBySpecializationAndLocation(String specialization, String location) throws SQLException;

}
