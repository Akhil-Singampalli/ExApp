package com.exult.dto;


import java.util.List;
import java.util.Objects;

import javax.persistence.Id;

import com.exult.entity.DataField;
import com.exult.entity.Patients;

public class PatientsDataDTO {

	
	private Integer id_patient_data;
	
	public Integer getId_patient_data() {
		return id_patient_data;
	}

	public void setId_patient_data(Integer id_patient_data) {
		this.id_patient_data = id_patient_data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_patient_data);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientsDataDTO other = (PatientsDataDTO) obj;
		return Objects.equals(id_patient_data, other.id_patient_data);
	}

	@Override
	public String toString() {
		return "PatientsDataDTO [id_patient_data=" + id_patient_data + ", getId_patient_data()=" + getId_patient_data()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	

	

	
	
	
	
}
