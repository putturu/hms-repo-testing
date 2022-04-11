package com.sapient.aem.dao;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.model.PatientCaseSheet;

public interface PatientCaseSheetDAO {
	public abstract PatientCaseSheet getPatientCaseSheetById(Integer patientCaseSheetId) throws SQLException;
	public abstract List<PatientCaseSheet> getPatientCasesheet() throws SQLException;
	public abstract Integer addPatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException;
	public abstract String updatePatientCaseSheet(PatientCaseSheet patientCaseSheet) throws SQLException;
	public abstract String deletePatientCaseSheet(Integer patientCaseSheetId) throws SQLException;
	public abstract List<PatientCaseSheet> getPatientCaseSheetByDoctorId(Integer doctorId) throws SQLException;
	public abstract List<PatientCaseSheet> getPatientCaseSheetByPatientCaseSheetId(Integer patientCaseSheetId) throws SQLException;
}
