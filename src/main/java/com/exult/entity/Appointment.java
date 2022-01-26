package com.exult.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENT")
public class Appointment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idAppointment")
	private Integer aptId;
	@Column(name = "aptdate")
	private String aptDate;
	@Column(name ="apttime")
	private String aptTime;
	@Column(name= "aptstatus")
	private String aptStatus;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="patientsIdpatient")
	private Patients Patient;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="doctorIddoctor")
	private Doctors Doctor;
	
//	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name="adminIdadmin")
//	private Admin Admin;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="id_patient")
//	private Patients aptPatient;
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="id_doctor")
//	private Doctors aptDoctor;
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="id_admin")
//	private Admin aptAdmin;
	
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
	public Patients getPatient() {
		return Patient;
	}
	public void setPatient(Patients patient) {
		Patient = patient;
	}
	public Doctors getDoctor() {
		return Doctor;
	}
	public void setDoctor(Doctors doctor) {
		Doctor = doctor;
	}
//	public Admin getAdmin() {
//		return Admin;
//	}
//	public void setAdmin(Admin admin) {
//		Admin = admin;
//	}
	
	
	
//	public Admin getAptAdmin() {
//		return aptAdmin;
//	}
//	public void setAptAdmin(Admin aptAdmin) {
//		this.aptAdmin = aptAdmin;
//	}
	
	
	
}
