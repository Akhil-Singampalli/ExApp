package com.exult.entity;


import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idappointment")
	private Integer aptId;
	@Column(name = "aptdate")
	private String aptDate;
	@Column(name ="apttime")
	private String aptTime;
	@Column(name= "aptstatus")
	private String aptStatus;
	
	@Column(name="patientid")
	private Integer PatientId;
	
	@Column(name="doctorid")
	private Integer DoctorId;
	
	@Column(name = "adminid")
	private Integer adminId;
	
	
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

	public String getAptStatus() {
		return aptStatus;
	}
	public void setAptStatus(String aptStatus) {
		this.aptStatus = aptStatus;
	}
	public Integer getPatientId() {
		return PatientId;
	}
	public void setPatientId(Integer patientId) {
		this.PatientId = patientId;
	}
	public Integer getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.DoctorId = doctorId;
	}
		
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(DoctorId, PatientId, aptDate, aptId, aptStatus, aptTime);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(DoctorId, other.DoctorId) && Objects.equals(PatientId, other.PatientId)
				&& Objects.equals(aptDate, other.aptDate) && Objects.equals(aptId, other.aptId)
				&& Objects.equals(aptStatus, other.aptStatus) && Objects.equals(aptTime, other.aptTime);
	}
	@Override
	public String toString() {
		return "Appointment [aptId=" + aptId + ", aptDate=" + aptDate + ", aptTime=" + aptTime + ", aptStatus="
				+ aptStatus + ", PatientId=" + PatientId + ", DoctorId=" + DoctorId + "]";
	}
	
	
	

	
	
	
}
