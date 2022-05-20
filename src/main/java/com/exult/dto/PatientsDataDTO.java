package com.exult.dto;


import java.util.List;
import java.util.Objects;

import javax.persistence.Id;

import com.exult.entity.DataField;
import com.exult.entity.Patients;

public class PatientsDataDTO {

	
	private Integer id_patient_data;
	
	private String desk_data_Id;
	
	private String doc_data_Id;
	
	
	
	public Integer getId_patient_data() {
		return id_patient_data;
	}

	public void setId_patient_data(Integer id_patient_data) {
		this.id_patient_data = id_patient_data;
	}

	
	public String getDesk_data_Id() {
		return desk_data_Id;
	}

	public void setDesk_data_Id(String desk_data_Id) {
		this.desk_data_Id = desk_data_Id;
	}

	public String getDoc_data_Id() {
		return doc_data_Id;
	}

	public void setDoc_data_Id(String doc_data_Id) {
		this.doc_data_Id = doc_data_Id;
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
