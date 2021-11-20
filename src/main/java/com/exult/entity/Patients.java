package com.exult.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PATIENTS")
public class Patients {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer patientId;
	private String patientName;
	private String emailId;
	private String contactNumber;
	private String password;
	
	
	public Integer getPatientId() {
		return patientId;
	}
	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
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
	
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, emailId, password, patientId, patientName);
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
				&& Objects.equals(password, other.password) && Objects.equals(patientId, other.patientId)
				&& Objects.equals(patientName, other.patientName);
	}
	@Override
	public String toString() {
		return "Patients [patientId=" + patientId + ", patientName=" + patientName + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}
	
	
	
}
