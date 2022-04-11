package com.sapient.aem.service;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.exception.PatientException;
import com.sapient.aem.exception.PatientHistoryException;

public interface NumberOfDPCHService {
	public abstract Integer countOfDoctors() throws DoctorException;
	public abstract Integer countOfPatients() throws PatientException;
	public abstract Integer pateintHistoryCount() throws PatientHistoryException;
	public abstract Integer pateintCaseSheetCount() throws PatientCaseSheetException;
}
