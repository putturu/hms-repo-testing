package com.sapient.aem.service;

import java.sql.SQLException;
import java.util.List;

import com.sapient.aem.exception.DoctorException;
import com.sapient.aem.model.Doctor;

public interface DoctorService {
	public abstract Doctor getDoctorById(Integer doctorId) throws DoctorException;
	public abstract List<Doctor> getAllDoctors() throws DoctorException;
    public abstract Integer  addDoctor(Doctor doctor) throws DoctorException;
    public abstract String updateDoctor(Doctor doctor) throws DoctorException;
    public abstract String deleteDoctor(Integer doctorId) throws DoctorException;
    public abstract List<Doctor> searchDoctor(String string) throws DoctorException;
    public abstract Integer countOfDoctors() throws DoctorException;
    public abstract Integer getDoctorIdByUserName(String userName) throws DoctorException;
}
