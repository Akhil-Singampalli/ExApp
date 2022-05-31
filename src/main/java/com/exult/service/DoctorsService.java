package com.exult.service;

import java.util.List;

import com.exult.dto.DataFieldDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;

public interface DoctorsService {

	public List<DoctorsDTO> docDetails()throws ExappException;
	
	public PatientsDTO patientDatasearch(Integer patientId)throws ExappException;
	
	public String updatePatientData(Integer patientId,List<DataFieldDTO> dataFieldDTO)throws ExappException;
	
	public List<PatientsDTO> PatientsData(Integer doctorId)throws ExappException;

	public DoctorsDTO getDoctor(Integer docId)throws ExappException;
}
