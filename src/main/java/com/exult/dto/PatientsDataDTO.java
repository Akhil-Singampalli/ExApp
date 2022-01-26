package com.exult.dto;


import java.util.List;
import java.util.Objects;

import javax.persistence.Id;

import com.exult.entity.DataField;
import com.exult.entity.Patients;

public class PatientsDataDTO {

	
	private Integer id_patient_data;
	
	private List<DataFieldDTO> dataField;

	private PatientsDTO patients;
	
	

	public Integer getId_patient_data() {
		return id_patient_data;
	}

	public void setId_patient_data(Integer id_patient_data) {
		this.id_patient_data = id_patient_data;
	}

	public PatientsDTO getPatients() {
		return patients;
	}

	public void setPatients(PatientsDTO patients) {
		this.patients = patients;
	}

	public List<DataFieldDTO> getDataField() {
		return dataField;
	}

	public void setDataField(List<DataFieldDTO> dataField) {
		this.dataField = dataField;
	}

	@Override
	public String toString() {
		return "PatientsDataDTO [id_patient_data=" + id_patient_data + ", dataField=" + dataField + ", patients="
				+ patients + ", getId_patient_data()=" + getId_patient_data() + ", getPatients()=" + getPatients()
				+ ", getDataField()=" + getDataField() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataField, id_patient_data, patients);
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
		return Objects.equals(dataField, other.dataField) && Objects.equals(id_patient_data, other.id_patient_data)
				&& Objects.equals(patients, other.patients);
	}
	
	
	
}
