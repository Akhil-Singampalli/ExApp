package com.exult.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PatientsDTO {

	private Integer patientId;
	@Pattern(regexp ="([A-Za-z])+(\\s[A-Za-z]+)*", message = "{invalid.customer.format}")
	@NotNull
	private String patientName;
	@NotNull(message = "{email.abscent}")
	@Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+" ,message = "{invalid.email.format}")
	private String emailId;
	@Pattern(regexp = "[6-9][0-9]{9}",message = "{invalid.contactnumber.format}")
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
	
	
}
