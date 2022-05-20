package com.exult.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patientData")
public class PatientsData {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpatientData")
	private Integer id_patient_data;
	
	@Column(name = "deskDataId")
	private String desk_data_id;
	
	@Column(name = "docDataId")
	private String doc_data_id;
//	
//	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//	@JoinColumn(name = "datafieldIddatafield")
//	private List<DataField> dataField;
	
//	
//	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "patientsData")
//	@JoinColumn(name ="patientPatientDataIdpatientData")
//	private Patients patients;

	

	public Integer getId_patient_data() {
		return id_patient_data;
	}


	public void setId_patient_data(Integer id_patient_data) {
		this.id_patient_data = id_patient_data;
	}


	public String getDesk_data_id() {
		return desk_data_id;
	}


	public void setDesk_data_id(String desk_data_id) {
		this.desk_data_id = desk_data_id;
	}


	public String getDoc_data_id() {
		return doc_data_id;
	}


	public void setDoc_data_id(String doc_data_id) {
		this.doc_data_id = doc_data_id;
	}

	
	
}
