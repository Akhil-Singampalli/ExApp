package com.exult.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DATAFIELD")
public class DataField {

	@Id
	@Column(name = "iddatafield")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer fieldId;
	
	@Column(name = "fieldtype")
	private String fieldType;
	@Column(name="fieldname")
	private String fieldName;
	@Column(name = "fieldvalue")
	private String fieldValue;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="patientDataIdpatientData")
	private PatientsData patientData;
	
	
	
	
public PatientsData getPatientData() {
		return patientData;
	}
	public void setPatientData(PatientsData patientData) {
		this.patientData = patientData;
	}
	//
//	public PatientsData getPatientData() {
//		return patientData;
//	}
//	public void setPatientData(PatientsData patientData) {
//		this.patientData = patientData;
//	}
	//	
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
//	
//	public String getField0() {
//		return field0;
//	}
//	public void setField0(String field0) {
//		this.field0 = field0;
//	}
//	public String getField1() {
//		return field1;
//	}
//	public void setField1(String field1) {
//		this.field1 = field1;
//	}
//	public String getField2() {
//		return field2;
//	}
//	public void setField2(String field2) {
//		this.field2 = field2;
//	}
//	public String getField3() {
//		return field3;
//	}
//	public void setField3(String field3) {
//		this.field3 = field3;
//	}
//	public String getField4() {
//		return field4;
//	}
//	public void setField4(String field4) {
//		this.field4 = field4;
//	}
//	public String getField5() {
//		return field5;
//	}
//	public void setField5(String field5) {
//		this.field5 = field5;
//	}
//	public String getField6() {
//		return field6;
//	}
//	public void setField6(String field6) {
//		this.field6 = field6;
//	}
//	public String getField7() {
//		return field7;
//	}
//	public void setField7(String field7) {
//		this.field7 = field7;
//	}
//	public String getField8() {
//		return field8;
//	}
//	public void setField8(String field8) {
//		this.field8 = field8;
//	}
//	public String getField9() {
//		return field9;
//	}
//	public void setField9(String field9) {
//		this.field9 = field9;
////	}
	public Integer getFieldId() {
		return fieldId;
	}
	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}
	public String getFieldType() {
		return fieldType;
	}
	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataField other = (DataField) obj;
		return Objects.equals(fieldId, other.fieldId) && Objects.equals(fieldName, other.fieldName)
				&& Objects.equals(fieldType, other.fieldType) && Objects.equals(fieldValue, other.fieldValue)
				&& Objects.equals(patientData, other.patientData);
	}
	
	
	
}
