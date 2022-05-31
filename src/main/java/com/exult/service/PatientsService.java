package com.exult.service;

import java.util.List;

import com.exult.dto.DataFieldDTO;
import com.exult.dto.PatientsDTO;
import com.exult.dto.PatientsDataDTO;
import com.exult.entity.DataField;
import com.exult.entity.PatientsData;
import com.exult.exception.ExappException;

public interface PatientsService {

	public PatientsDTO authenticatePatient(String contactNumber,String password) throws ExappException;
	
	public String registerPatient(PatientsDTO patient) throws ExappException;
	
	public List<DataField> fetchPatientData(Integer patientId) throws ExappException;

	public PatientsDTO fetchPatient(Integer patientId) throws ExappException;

	public PatientsData fetchPatientFoldders(Integer patientId) throws ExappException;
}
