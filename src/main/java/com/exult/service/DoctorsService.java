package com.exult.service;

import java.util.List;

import com.exult.dto.DataFieldDTO;
import com.exult.dto.PatientsDTO;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;

public interface DoctorsService {

	public List<Doctors> docDetails()throws ExappException;
	
	public PatientsDTO patientDatasearch(Integer patientId)throws ExappException;
	
	public String updatePatientData(Integer patientId,DataFieldDTO dataFieldDTO)throws ExappException;
	
	public List<Patients> PatientsData(Integer doctorId)throws ExappException;
}
