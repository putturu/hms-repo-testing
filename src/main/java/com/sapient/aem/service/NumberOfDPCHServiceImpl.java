package com.sapient.aem.service;

import java.sql.SQLException;

import com.sapient.aem.dao.DoctorDAO;
import com.sapient.aem.dao.DoctorDaoImpl;
import com.sapient.aem.dao.NumberOfDPCHDAO;
import com.sapient.aem.dao.NumberOfDPCHDaoImpl;
import com.sapient.aem.dao.PatientCaseSheetDAO;
import com.sapient.aem.dao.PatientCaseSheetDaoImpl;
import com.sapient.aem.dao.PatientDAO;
import com.sapient.aem.dao.PatientDaoImpl;
import com.sapient.aem.dao.PatientHistoryDAO;
import com.sapient.aem.dao.PatientHistoryDaoImpl;
import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.exception.PatientCaseSheetException;
import com.sapient.aem.exception.PatientException;
import com.sapient.aem.exception.PatientHistoryException;

public class NumberOfDPCHServiceImpl implements NumberOfDPCHService{
	private NumberOfDPCHDAO numberOfDPCHDAO =new NumberOfDPCHDaoImpl();
	@Override
	public Integer countOfDoctors() throws DoctorException {
		try {
			Integer count = numberOfDPCHDAO.countOfDoctors();
			return count;
		}catch(SQLException e) {
			throw new DoctorException(e.getMessage(),e);
		}
	}

	@Override
	public Integer countOfPatients() throws PatientException {
		try {
			Integer count = numberOfDPCHDAO.countOfPatients();
			return count;
		}catch(SQLException e) {
			throw new PatientException(e.getMessage(),e);
		}
	}

	@Override
	public Integer pateintHistoryCount() throws PatientHistoryException {
		try {
			Integer count = numberOfDPCHDAO.pateintHistoryCount();
			return count;
		}catch(SQLException e) {
			throw new PatientHistoryException(e.getMessage(),e);
		}
	}

	@Override
	public Integer pateintCaseSheetCount() throws PatientCaseSheetException {
		try {
			Integer count = numberOfDPCHDAO.pateintCaseSheetCount();
			return count;
		}catch(SQLException e) {
			throw new PatientCaseSheetException(e.getMessage(),e);
		}
	}

}
