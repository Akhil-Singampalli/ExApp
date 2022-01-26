package com.exult.dto;

import java.util.Objects;

public class DataFieldDTO {

	private Integer fieldId;
	
	private String fieldType;
	private String fieldName;
	private String fieldValue;
	

	
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
	public int hashCode() {
		return Objects.hash(fieldId, fieldName, fieldType, fieldValue);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DataFieldDTO other = (DataFieldDTO) obj;
		return Objects.equals(fieldId, other.fieldId) && Objects.equals(fieldName, other.fieldName)
				&& Objects.equals(fieldType, other.fieldType) && Objects.equals(fieldValue, other.fieldValue);
	}
	@Override
	public String toString() {
		return "DataFieldDTO [fieldId=" + fieldId + ", fieldType=" + fieldType + ", fieldName=" + fieldName
				+ ", fieldValue=" + fieldValue + ", getFieldId()=" + getFieldId() + ", getFieldType()=" + getFieldType()
				+ ", getFieldName()=" + getFieldName() + ", getFieldValue()=" + getFieldValue() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
	
	
}
