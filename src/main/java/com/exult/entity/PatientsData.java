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

//	public List<DataField> getDataField() {
//		return dataField;
//	}
//
//	public void setDataField(List<DataField> dataField) {
//		this.dataField = dataField;
//	}

	public void setId_patient_data(Integer id_patient_data) {
		this.id_patient_data = id_patient_data;
	}

//	public List<DataField> getDataField() {
//		return dataField;
//	}
//
//	public void setDataField(List<DataField> dataField) {
//		this.dataField = dataField;
//	}
//
//	public Patients getPatients() {
//		return patients;
//	}
//
//	public void setPatients(Patients patients) {
//		this.patients = patients;
//	}


	
	
	

//	private String field0;
//	private String field1;
//	private String field2;
//	private String field3;
//	private String field4;
//	private String field5;
//	private String field6;
//	private String field7;
//	private String field8;
//	private String field9;
	
	


//	public Integer getIdPatient() {
//		return IdPatient;
//	}
//
//	public void setIdPatient(Integer idPatient) {
//		IdPatient = idPatient;
//	}
	
	

//	public String getField0() {
//		return field0;
//	}
//
//	public void setField0(String field0) {
//		this.field0 = field0;
//	}
//
//	public String getField1() {
//		return field1;
//	}
//
//	public void setField1(String field1) {
//		this.field1 = field1;
//	}
//
//	public String getField2() {
//		return field2;
//	}
//
//	public void setField2(String field2) {
//		this.field2 = field2;
//	}
//
//	public String getField3() {
//		return field3;
//	}
//
//	public void setField3(String field3) {
//		this.field3 = field3;
//	}
//
//	public String getField4() {
//		return field4;
//	}
//
//	public void setField4(String field4) {
//		this.field4 = field4;
//	}
//
//	public String getField5() {
//		return field5;
//	}
//
//	public void setField5(String field5) {
//		this.field5 = field5;
//	}
//
//	public String getField6() {
//		return field6;
//	}
//
//	public void setField6(String field6) {
//		this.field6 = field6;
//	}
//
//	public String getField7() {
//		return field7;
//	}
//
//	public void setField7(String field7) {
//		this.field7 = field7;
//	}
//
//	public String getField8() {
//		return field8;
//	}
//
//	public void setField8(String field8) {
//		this.field8 = field8;
//	}
//
//	public String getField9() {
//		return field9;
//	}
//
//	public void setField9(String field9) {
//		this.field9 = field9;
//	}
	
	
	
}
