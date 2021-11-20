package com.exult.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.dto.PatientsDTO;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;
import com.exult.repository.PatientRepo;

@Service(value = "patientService")
@Transactional
public class PatientsServiceImpl  implements PatientsService{

	@Autowired
	private PatientRepo patientRepo;

	@Override
	public PatientsDTO authenticatePatient(String contactNumber, String password) throws ExappException {
		
		Patients optPatients = patientRepo.findByContactNumber(contactNumber);
		
		if(optPatients == null) {
			throw new ExappException("PatientService.INVALID_CREDENTIALS");
		}
		
		String passwordFromDB = optPatients.getPassword();
		
		if(optPatients != null) {
			try {
		
				if(password.equals(passwordFromDB)){
					

					PatientsDTO patientObj = new PatientsDTO();
			
					patientObj.setContactNumber(optPatients.getContactNumber());
					patientObj.setEmailId(optPatients.getEmailId());
					patientObj.setPatientId(optPatients.getPatientId());
					patientObj.setPatientName(optPatients.getPatientName());
			
					return patientObj;
				}else
					throw new ExappException("PatientService.INVALID_CREDENTIALS");
			}catch (Exception e) {
				throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
			}
		} else {
			throw new ExappException("PatientService.INVALID_CREDENTIALS");
		}
			
	}

	@Override
	public String registerPatient(PatientsDTO patient) throws ExappException {
		
		Patients optPatientC = patientRepo.findByContactNumber(patient.getContactNumber());
		Patients optPatientE = patientRepo.findByEmailId(patient.getEmailId());
		
		if(optPatientC != null || optPatientE != null) {
			throw new ExappException("PatientService.EXISTING_CONTACT_NUMBER");
		}
		else {
			Patients patientNew = new Patients();
			
			patientNew.setContactNumber(patient.getContactNumber());
			patientNew.setEmailId(patient.getEmailId());
			patientNew.setPassword(patient.getPassword());
			patientNew.setPatientName(patient.getPatientName());
			
			patientRepo.save(patientNew);
		}
		return "success";
	}
	
}
