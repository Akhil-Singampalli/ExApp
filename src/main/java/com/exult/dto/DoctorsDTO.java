package com.exult.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DoctorsDTO {
	
	private Integer doctorId;
	@Pattern(regexp ="([A-Za-z])+(\\s[A-Za-z]+)*", message = "{invalid.customer.format}")
	@NotNull
	private String doctorName;
	@NotNull(message = "{email.abscent}")
	@Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+" ,message = "{invalid.email.format}")
	private String emailId;
	@Pattern(regexp = "[6-9][0-9]{9}",message = "{invalid.contactnumber.format}")
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
		DoctorsDTO other = (DoctorsDTO) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(doctorId, other.doctorId)
				&& Objects.equals(doctorName, other.doctorName) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "DoctorsDTO [doctorId=" + doctorId + ", doctorName=" + doctorName + ", emailId=" + emailId
				+ ", contactNumber=" + contactNumber + ", password=" + password + "]";
	}

		
	
}
