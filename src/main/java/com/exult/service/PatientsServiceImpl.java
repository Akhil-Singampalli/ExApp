package com.exult.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.dto.DataFieldDTO;
import com.exult.dto.PatientsDTO;
import com.exult.dto.PatientsDataDTO;
import com.exult.entity.DataField;
import com.exult.entity.Patients;
import com.exult.entity.PatientsData;
import com.exult.exception.ExappException;
import com.exult.repository.DataFieldRepo;
import com.exult.repository.PatientDataRepo;
import com.exult.repository.PatientRepo;

@Service(value = "patientService")
@Transactional
public class PatientsServiceImpl  implements PatientsService{

	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private PatientDataRepo patientDataRepo;
	
	@Autowired
	private DataFieldRepo dataFieldRepo;
	
	@Autowired
	private EmailSenderService emailSenderService;

	@Override
	public PatientsDTO authenticatePatient(String contactNumber, String password) throws ExappException {
		
		Optional<Patients> optPatients = patientRepo.findByContactNumber(contactNumber);
		Patients patient = optPatients.orElseThrow(() -> new ExappException(""));
		
		if(patient == null) {
			throw new ExappException("PatientService.INVALID_CREDENTIALS");
		}
		
		String passwordFromDB = patient.getPassword();
		
		try {

			if(password.equals(passwordFromDB)){
				

				PatientsDTO patientObj = new PatientsDTO();
		
				patientObj.setContactNumber(patient.getContactNumber());
				patientObj.setEmailId(patient.getEmailId());
				patientObj.setPatientId(patient.getIdPatient());
				patientObj.setPatientName(patient.getPatientName());
		
				return patientObj;
			}else
				throw new ExappException("PatientService.INVALID_CREDENTIALS");
		}catch (Exception e) {
			throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
		}
			
	}

	@Override
	public String registerPatient(PatientsDTO patient) throws ExappException {
		
		
//		Optional<Patients> optPatientC = patientRepo.findByContactNumber(patient.getContactNumber());
//		Optional<Patients> optPatientE = patientRepo.findByEmailId(patient.getEmailId());
		
		if(false) {
			throw new ExappException("PatientService.EXISTING_CONTACT_NUMBER");
		}
		else {
			Patients patientNew = new Patients();
			
			patientNew.setPatientName(patient.getPatientName());
			patientNew.setContactNumber(patient.getContactNumber());
			patientNew.setEmailId(patient.getEmailId());
			patientNew.setPassword(patient.getPassword());
			
	
			PatientsData patientsData = new PatientsData();
			
			List<DataField> datafieldlist = new ArrayList<>();
			
			DataField dataField = new DataField();
						
			dataField.setFieldName("Name");
			dataField.setFieldType("Type");
			dataField.setFieldValue("Value");
			
			dataField.setPatientData(patientsData);
			
			dataFieldRepo.save(dataField);
			
			datafieldlist.add(dataField);
			
//			for(DataField field : patient.getPatientData().getDataField()) {
//				
//				DataField dataField = new DataField();
//				
//				
//				dataField.setFieldName(field.getFieldName());
//				dataField.setFieldType(field.getFieldType());
//				dataField.setFieldValue(field.getFieldValue());
//				
//				dataField.setPatientData(patientsData);
//				
//				dataFieldRepo.save(dataField);
//				
//				datafieldlist.add(dataField);
//			}

//			patientsData.setDataField(datafieldlist);
		
			
			
			patientDataRepo.save(patientsData);
			
			patientNew.setPatientsData(patientsData);
			
			patientRepo.save(patientNew);
			
			String body = "Hi"+" "+patientNew.getPatientName()+" you have been successfully registered to Exult Clinic";
			emailSenderService.sendNotification(patient.getEmailId(),body ,"Exult Registration" );
		}
		return "success";
	}

	@Override
	public List<DataField> fetchPatientData(Integer patientId) throws ExappException {
		
		
		Optional<Patients> optPat = patientRepo.findById(patientId);
		Patients patient = optPat.orElseThrow(()-> new ExappException(""));
		
		List<DataField> dataFields = dataFieldRepo.findByPatientData(patient.getPatientsData());
		
//		
//		if(dataFieldDTOs != null && patient != null) {
//			
//			PatientsDTO patientDTO = new PatientsDTO();
//			patientDTO.setPatientName(patient.getPatientName());
//			patientDTO.setEmailId(patient.getEmailId());
//			patientDTO.setContactNumber(patient.getContactNumber());
//			
//			
//			PatientsDataDTO patientsDataDTO = new PatientsDataDTO();
//			patientsDataDTO.setId_patient_data(patient.getPatientsData().getId_patient_data());
//			
//			
//			
//			patientDTO.setPatientDataDTO(patientsDataDTO);
//			
			
			
			return dataFields;
		
		
				
	}

	@Override
	public PatientsDTO fetchPatient(Integer patientId) throws ExappException {
		
		Optional<Patients> patOptional = patientRepo.findById(patientId);
		Patients patients = patOptional.orElseThrow(() -> new ExappException(""));
		
		if(patOptional != null) {
			PatientsDTO patientsDTO = new PatientsDTO();
			
			patientsDTO.setContactNumber(patients.getContactNumber());
			patientsDTO.setEmailId(patients.getEmailId());
			patientsDTO.setPatientId(patientId);
			patientsDTO.setPatientName(patients.getPatientName());
			
			return patientsDTO;
		}else {
			return null;
		}
		
	}
	
}
