package com.exult.dto;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.exult.entity.Appointment;
import com.exult.entity.PatientsData;

public class PatientsDTO {

	private Integer IdPatient;
	@Pattern(regexp ="([A-Za-z])+(\\s[A-Za-z]+)*", message = "{invalid.customer.format}")
	@NotNull
	private String patientName;
	@NotNull(message = "{email.abscent}")
	@Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+" ,message = "{invalid.email.format}")
	private String emailId;
	@Pattern(regexp = "[6-9][0-9]{9}",message = "{invalid.contactnumber.format}")
	private String contactNumber;
	
	private String password;
	
	
	private PatientsDataDTO patientData;
	
	private DataFieldDTO dataFieldDTO;

	public Integer getPatientId() {
		return IdPatient;
	}

	public void setPatientId(Integer patientId) {
		this.IdPatient = patientId;
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

	public PatientsDataDTO getPatientData() {
		return patientData;
	}

	public void setPatientDataDTO(PatientsDataDTO patientData2) {
		this.patientData = patientData2;
	}

	public DataFieldDTO getDataFieldDTO() {
		return dataFieldDTO;
	}

	public void setDataFieldDTO(DataFieldDTO dataFieldDTO) {
		this.dataFieldDTO = dataFieldDTO;
	}
	
	
	
}
