package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.dao.DoctorDAO;
import com.sapient.aem.dao.DoctorDaoImpl;
import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.model.Doctor;

public class DoctorServiceImpl implements DoctorService{
	private DoctorDAO doctorDao=new DoctorDaoImpl(); 

	@Override
	public Doctor getDoctorById(Integer doctorId) throws DoctorException {
		try {
			Doctor doctor= doctorDao.getDoctorById(doctorId);
			return doctor; 
		}catch(SQLException e) {

			throw new DoctorException(e.getMessage(),e);
		}
	}

	@Override
	public List<Doctor> getAllDoctors() throws DoctorException {
		try {
			List<Doctor> doctorList= doctorDao.getAllDoctors();
			return doctorList; 
		}catch(SQLException e) {

			throw new DoctorException(e.getMessage(),e);
		}
	}

	@Override
	public Integer addDoctor(Doctor doctor) throws DoctorException {
		try {
			Integer result=doctorDao.addDoctor(doctor);

			return result;
		}catch(SQLException e) {
			throw new DoctorException(e.getMessage(),e);
		}

	}


	@Override
	public String updateDoctor(Doctor doctor) throws DoctorException {
		try {
			String result= doctorDao.updateDoctor(doctor);
			return result; 
		}catch(SQLException e) {
			throw new DoctorException(e.getMessage(),e);
		}
	}

	@Override
	public String deleteDoctor(Integer doctorId) throws DoctorException {
		try {
			String result= doctorDao.deleteDoctor(doctorId);			
			return result; 
		}catch(SQLException e) {
			//converting SQLException to EmployeeException
			throw new DoctorException(e.getMessage(),e);
		}
	}

	@Override
	public List<Doctor> searchDoctor(String string) throws DoctorException {
		try {
			List<Doctor> doctorList= doctorDao.searchDoctor(string);
			return doctorList; 
		}catch(SQLException e) {
			throw new DoctorException(e.getMessage(),e);
		}
	}

	@Override
	public Integer countOfDoctors() throws DoctorException {
		try {
			Integer count = doctorDao.countOfDoctors();
			return count;
		}catch(SQLException e) {
			throw new DoctorException(e.getMessage(),e);
		}
	}

	@Override
	public Integer getDoctorIdByUserName(String userName) throws DoctorException {
		try {
			Integer doctorId=doctorDao.getDoctorIdByUserName(userName);
			return doctorId;
		}catch(SQLException e) {
			throw new DoctorException(e.getMessage(),e);
		}
	}


}
