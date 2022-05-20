package com.exult.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DOCTOR")
public class Doctors {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "iddoctor")
	private Integer IdDoctor;
	@Column(name = "docname")
	private String doctorName;
	@Column(name = "emailid")
	private String emailId;
	@Column(name = "contactnumber")
	private String contactNumber;
	private String password;
		
	
	public Integer getDoctorId() {
		return IdDoctor;
	}
	public void setDoctorId(Integer doctorId) {
		this.IdDoctor = doctorId;
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
		return "Doctors [doctorId=" + IdDoctor + ", doctorName=" + doctorName + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, IdDoctor, doctorName, emailId, password);
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
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(IdDoctor, other.IdDoctor)
				&& Objects.equals(doctorName, other.doctorName) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(password, other.password);
	}
	
}
