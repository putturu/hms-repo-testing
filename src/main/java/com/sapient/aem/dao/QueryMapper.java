package com.sapient.aem.dao;

public interface QueryMapper {
	// Doctor
	public static final String GET_DOCTOR_BY_ID = "select * from doctor where doctor_id=?";
	public static final String GET_ALL_DOCTORS = "select * from doctor";
	public static final String ADD_DOCTOR = "insert into doctor(doctor_name,specialization,available_timings,qualification,experience_in_years,mobile,email,location,user_name) values(?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_DOCTOR = "update doctor set email=?,available_timings=?,mobile=? where doctor_id=?";
	public static final String DELETE_DOCTOR = "delete from doctor where doctor_id=?";
	public static final String SEARCH_DOCTOR = "select * from doctor where doctor_name=? or specialization=?";
	public static final String COUNT_OF_DOCTORS = "select count(doctor_id) from doctor";
	public static final String GET_DOCTOR_ID_BY_USERNAME = "select doctor_id from doctor where user_name=?";
	// patient
	public static final String GET_PATIENT_BY_ID = "select * from patient where patient_id= ?";
	public static final String GET_ALL_PATIENTS = "select * from patient";
	public static final String ADD_PATIENT = "insert into patient(patient_name,gender,birthdate,blood_group,mobile,address,email,user_name) values(?,?,?,?,?,?,?,?)";
	public static final String UPDATE_PATIENT = "update hms set mobile=?,address=?,email=? where patient_id=?";
	public static final String DELETE_PATIENT = "delete from patient where patient_id=?";
	public static final String COUNT_OF_PATIENTS = "select count(patient_id) from patient";
	public static final String GET_PATIENT_ID_BY_USERNAME = "select patient_id from patient where user_name=?";
	//patient case sheet
	public static final String GET_PATIENT_CASE_SHEET_BY_ID = "select * from patient_case_sheet where patient_case_sheet_id=?";
	public static final String GET_ALL_PATIENT_CASE_SHEETS = "select * from patient_case_sheet";
	public static final String ADD_PATIENT_CASE_SHEET = "insert into patient_case_sheet(patient_name,case_sheet_open_date ,case_sheet_close_date ,hostipal_details ,health_statistics,symptoms,prescription,diet,status,patient_id,doctor_id)values(?,?,?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_PATIENT_CASE_SHEET = "update patient_case_sheet set patient_name=?, case_sheet_open_date =?,case_sheet_close_date=?,hostipal_details=?,health_statistics=?, symptoms=?,prescription=?,diet=?,status=?,patient_id=?,doctor_id=? where patient_case_sheet_id=?";
	public static final String DELETE_PATIENT_CASE_SHEET = "delete from patient_case_sheet where patient_case_sheet_id=?";
	public static final String SEARCH_PATIENT_CASE_SHEET = "select * from patient_case_sheet where doctor_id=?";
	public static final String COUNT_OF_PATIENT_CASE_SHEETS = "select count(patient_case_sheet_id) from patient_case_sheet";
	//patient history
	public static final String GET_PATIENT_HISTORY_BY_ID = "select * from patient_history where patient_history_id=?";
	public static final String GET_ALL_PATIENT_HISTORY = "select * from patient_history";
	public static final String ADD_PATIENT_HISTORY = "insert into patient_history (patient_name,case_sheet_open_date ,case_sheet_close_date,hostipal_details,health_statistics,symptoms,prescription ,diet ,patient_id) values (?,?,?,?,?,?,?,?,?)";
	public static final String UPDATE_PATIENT_HISTORY = "update patient_history set hostipal_details=?, health_statistics=?, symptoms=?, prescription=?, diet=? where patient_history_id=?";
	public static final String DELETE_PATIENT_HISTORY = "delete from patient_history where patient_history_id=?";
	public static final String SEARCH_PATIENT_HISTORY = "select * from patient_history where patient_name=?";
	public static final String COUNT_PATIENT_HISTORY = "select count(patient_history_id) from patient_history";
	//appointment 
	public static final String ADD_APPOINTMENT = "insert into doctor_patient_appointment(appointment_date,appointment_time,appointment_location,doctor_id,patient_id) values(?,?,?,?,?)";
	//user
	public static final String GET_USER_BY_ID = "select * from user where user_id=?";
	public static final String GET_ALL_USERS = "select * from user";
	public static final String ADD_USER = "insert into user(user_name,password,role) values(?,?,?)";
	public static final String UPDATE_USER = "update user set user_name=?,password=? where user_id=?";
	public static final String DELETE_USER= "delete from user where user_id=?";
	public static final String USER_PASSWORD_FORGOT = "update user set password=? where user_name=? and role=?";
	public static final String USER_IS_VALID_LOGIN = "select * from user where user_name=? and password=? and role=?";
	public static final String USER_IS_VALID_FOR_DATABASE = "select * from user where user_name=? and role=?";
	public static final String GET_USER_ID = "select user_id from user where user_name=? and password=? and role=?";
	
}
