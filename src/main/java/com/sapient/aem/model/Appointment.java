package com.sapient.aem.model;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {
	private Integer doctorPatientAppointmentId;
	private LocalDate appointmentDate ;
	private LocalTime appointmentTime ;
	private String appointmentLocation;
	private Integer patientId ;
	private Integer doctorId ;

	public Appointment(LocalDate appointmentDate, LocalTime appointmentTime,
			String appointmentLocation, Integer patientId, Integer doctorId) {
		super();
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.appointmentLocation = appointmentLocation;
		this.patientId = patientId;
		this.doctorId = doctorId;
	}

}