package com.exult.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import com.exult.entity.Doctors;
import com.exult.entity.Patients;


public class AppointmentDTO {

	private Integer aptId;
	private String aptDate;
	private String aptTime;
	private String aptStatus;
	
	private String aptPatient;

	private String aptDoctor;

	
	public Integer getAptId() {
		return aptId;
	}

	public void setAptId(Integer aptId) {
		this.aptId = aptId;
	}

	public String getAptDate() {
		return aptDate;
	}

	public void setAptDate(String aptDate) {
		this.aptDate = aptDate;
	}

	public String getAptTime() {
		return aptTime;
	}

	public void setAptTime(String aptTime) {
		this.aptTime = aptTime;
	}


	

	public String getAptPatient() {
		return aptPatient;
	}

	public void setAptPatient(String aptPatient) {
		this.aptPatient = aptPatient;
	}

	public String getAptDoctor() {
		return aptDoctor;
	}

	public void setAptDoctor(String aptDoctor) {
		this.aptDoctor = aptDoctor;
	}

	public String getAptStatus() {
		return aptStatus;
	}

	public void setAptStatus(String aptStatus) {
		this.aptStatus = aptStatus;
	}

	

		
	
	
}
