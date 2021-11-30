package com.exult.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOCTORS")
public class Doctors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer doctorId;
	private String doctorName;
	private String emailId;
	private String contactNumber;
	private String password;
	
	
	public Integer getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
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
	public String toString() {
		return "Doctors [doctorId=" + doctorId + ", doctorName=" + doctorName + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, doctorId, doctorName, emailId, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctors other = (Doctors) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(doctorId, other.doctorId)
				&& Objects.equals(doctorName, other.doctorName) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(password, other.password);
	}
	
}
