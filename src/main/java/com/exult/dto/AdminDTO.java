package com.exult.dto;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AdminDTO {

	private Integer adminId;
	@Pattern(regexp ="([A-Za-z])+(\\s[A-Za-z]+)*", message = "{invalid.customer.format}")
	@NotNull
	private String adminName;
	@NotNull(message = "{email.abscent}")
	@Pattern(regexp = "[a-zA-Z0-9._]+@[a-zA-Z]{2,}\\.[a-zA-Z][a-zA-Z.]+" ,message = "{invalid.email.format}")
	private String emailId;
	@Pattern(regexp = "[6-9][0-9]{9}",message = "{invalid.contactnumber.format}")
	private String contactNumber;
	
	private String password;

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDTO other = (AdminDTO) obj;
		return Objects.equals(adminId, other.adminId) && Objects.equals(adminName, other.adminName)
				&& Objects.equals(contactNumber, other.contactNumber) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(password, other.password);
	}

	@Override
	public String toString() {
		return "AdminDTO [adminId=" + adminId + ", adminName=" + adminName + ", emailId=" + emailId + ", contactNumber="
				+ contactNumber + ", password=" + password + "]";
	}
	
	
}
