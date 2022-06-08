package com.exult.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.api.DriveAPI;
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

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

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
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DriveAPI driveAPI;

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
		
		
		Optional<Patients> optPatientC = patientRepo.findByContactNumber(patient.getContactNumber());
		Optional<Patients> optPatientE = patientRepo.findByEmailId(patient.getEmailId());
		List<DataFieldDTO> sampleDataFields = adminService.getPatientTempEdit();
		
		
		if(optPatientC.isPresent() || optPatientE.isPresent()) {
			
			System.out.println("here");
			throw new ExappException("PatientService.EXISTING_CONTACT_NUMBER");
		}
		else {
			
			Patients patientNew = new Patients();
			
			patientNew.setIdPatient(patient.getPatientId());
			patientNew.setPatientName(patient.getPatientName());
			patientNew.setContactNumber(patient.getContactNumber());
			patientNew.setEmailId(patient.getEmailId());
			patientNew.setPassword(patient.getPassword());
			
	
			PatientsData patientsData = new PatientsData();
			
			List<DataField> datafieldlist = new ArrayList<>();
			
			
			for(DataFieldDTO fieldDTO : sampleDataFields) {
				
				DataField dataField = new DataField();
				
				dataField.setFieldName(fieldDTO.getFieldName());
				dataField.setFieldValue(fieldDTO.getFieldValue());
				dataField.setFieldType(fieldDTO.getFieldType());
				
				dataField.setPatientData(patientsData);
				
				dataFieldRepo.save(dataField);
				
				datafieldlist.add(dataField);
			}	
			
			
			patientDataRepo.save(patientsData);
			
			patientNew.setPatientsData(patientsData);
			
			patientRepo.save(patientNew);
			
			
			driveAPI.CreateDeskFolder(patientNew.getIdPatient());
				
			
			String body = "Hi"+" "+patientNew.getPatientName()+" you have been successfully registered to Exult Clinic";
			emailSenderService.sendNotification(patient.getEmailId(),body ,"Exult Registration" );
			
			HttpResponse<String> response = Unirest.post("https://api.msg91.com/api/v5/flow/")
					  .header("authkey", "312379AYnyiHzkHSVm6161ac34P1")
					  .header("content-type", "application/JSON")
					  .body("{\n  \"flow_id\": \"61701531163abd49a820db42\",\n  \"sender\": \"exults\",\n  \"mobiles\": \"919515050278 \",\n  \"VAR1\": \"VALUE 1\",\n  \"VAR2\": \"VALUE 2\"\n}")
					  .asString();
		}
		return "success";
	}

	@Override
	public List<DataField> fetchPatientData(Integer patientId) throws ExappException {
		
		
		Optional<Patients> optPat = patientRepo.findById(patientId);
		Patients patient = optPat.orElseThrow(()-> new ExappException(""));
		
		List<DataField> dataFields = dataFieldRepo.findByPatientData(patient.getPatientsData());
		
		
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
			
			
			
			return dataFields;
		
		
				
	}
	
	@Override
	public PatientsData fetchPatientFoldders(Integer patientId) throws ExappException {
		
		
		Optional<Patients> optPat = patientRepo.findById(patientId);
		Patients patient = optPat.orElseThrow(()-> new ExappException(""));
		
		PatientsData patFolders = patient.getPatientsData();
		
		
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
			
			
			
			return patFolders;
		
		
				
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
