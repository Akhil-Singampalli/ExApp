package com.exult.entity;

import java.util.List;
import java.util.Objects;
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
	
	@Column(name = "imgDataId")
	private String img_data_id;
	
	@Column(name = "presDataId")
	private String pres_data_id;
	
	@Column(name = "billsDataId")
	private String bills_data_id;
	
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


	public String getImg_data_id() {
		return img_data_id;
	}


	public void setImg_data_id(String img_data_id) {
		this.img_data_id = img_data_id;
	}


	public String getPres_data_id() {
		return pres_data_id;
	}


	public void setPres_data_id(String pres_data_id) {
		this.pres_data_id = pres_data_id;
	}


	public String getBills_data_id() {
		return bills_data_id;
	}


	public void setBills_data_id(String bills_data_id) {
		this.bills_data_id = bills_data_id;
	}


	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatientsData other = (PatientsData) obj;
		return Objects.equals(bills_data_id, other.bills_data_id) && Objects.equals(desk_data_id, other.desk_data_id)
				&& Objects.equals(doc_data_id, other.doc_data_id)
				&& Objects.equals(id_patient_data, other.id_patient_data)
				&& Objects.equals(img_data_id, other.img_data_id) && Objects.equals(pres_data_id, other.pres_data_id);
	}

	
	
}
