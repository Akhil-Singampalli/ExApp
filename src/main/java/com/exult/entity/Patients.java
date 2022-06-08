package com.exult.entity;


import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PATIENTS")
public class Patients {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpatient")
	private Integer idPatient;
	@Column(name = "patientname")
	private String patientName;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "contactnumber")
	private String contactNumber;
	@Column(name = "password")
	private String password;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientDataIdpatientData")
	private PatientsData patientsData;
	
	
	
	
	public Integer getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(Integer patientId) {
		this.idPatient = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public PatientsData getPatientsData() {
		return patientsData;
	}
	public void setPatientsData(PatientsData patientsData) {
		this.patientsData = patientsData;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, emailId, idPatient, password, patientName, patientsData);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patients other = (Patients) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(idPatient, other.idPatient) && Objects.equals(password, other.password)
				&& Objects.equals(patientName, other.patientName) && Objects.equals(patientsData, other.patientsData);
	}
	@Override
	public String toString() {
		return "Patients [patientId=" + idPatient + ", patientName=" + patientName + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}
	
	
	
}
