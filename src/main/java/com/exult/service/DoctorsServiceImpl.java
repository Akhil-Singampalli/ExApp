package com.exult.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.dto.DataFieldDTO;
import com.exult.dto.PatientsDTO;
import com.exult.entity.DataField;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;
import com.exult.repository.DoctorRepo;
import com.exult.repository.PatientRepo;

@Service(value = "doctorService")
@Transactional
public class DoctorsServiceImpl implements DoctorsService {
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private PatientRepo patRepo;

	@Override
	public List<Doctors> docDetails() throws ExappException {
		
		List<Doctors> docs = (List<Doctors>) doctorRepo.findAll();
		
		return docs;
	}

	@Override
	public PatientsDTO patientDatasearch(Integer patientId) throws ExappException {
		
		
		return null;
	}

	@Override
	public String updatePatientData(Integer patientId,DataFieldDTO dataFieldDTO) throws ExappException {
		Optional<Patients> optpat = patRepo.findById(patientId);
		Patients patient = optpat.orElseThrow(() -> new ExappException(""));
		
		if(patient != null ) {
			DataField dataField = new DataField();
					
			
			patRepo.save(patient);
		}
		return null;
	}

	@Override
	public List<Patients> PatientsData(Integer doctorId) throws ExappException {
		
		List<Patients> pats = (List<Patients>) patRepo.findAll();
		
		return pats;
	}

}
