package com.exult.dto;

import java.time.LocalDateTime;
import java.util.Date;

import com.exult.entity.Doctors;
import com.exult.entity.Patients;


public class AppointmentDTO {

	private Integer aptId;
	private String aptDate;
	private String aptTime;
	private String aptStatus;
	
	private Integer aptPatientId;

	private Integer aptDoctorId;

	
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


	public Integer getAptPatientId() {
		return aptPatientId;
	}

	public void setAptPatientId(Integer aptPatientId) {
		this.aptPatientId = aptPatientId;
	}

	public Integer getAptDoctorId() {
		return aptDoctorId;
	}

	public void setAptDoctorId(Integer aptDoctorId) {
		this.aptDoctorId = aptDoctorId;
	}

	public String getAptStatus() {
		return aptStatus;
	}

	public void setAptStatus(String aptStatus) {
		this.aptStatus = aptStatus;
	}

	

		
	
	
}
