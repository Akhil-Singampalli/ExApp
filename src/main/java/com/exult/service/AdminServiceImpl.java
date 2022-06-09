package com.exult.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.dto.AdminDTO;
import com.exult.dto.DataFieldDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.dto.PatientsDataDTO;
import com.exult.entity.Admin;
import com.exult.entity.DataField;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.entity.PatientsData;
import com.exult.exception.ExappException;
import com.exult.repository.AdminRepo;
import com.exult.repository.DataFieldRepo;
import com.exult.repository.DoctorRepo;
import com.exult.repository.PatientDataRepo;
import com.exult.repository.PatientRepo;
import com.google.common.collect.Iterables;

@Service(value = "adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private DoctorRepo docRepo;
	
	@Autowired
	private PatientRepo patRepo;
	
	@Autowired
	private PatientDataRepo patientDataRepo; 
	
	@Autowired
	private DataFieldRepo dataFieldRepo;

	@Override
	public AdminDTO authenticateAdmin(String contactNumber, String password) throws ExappException {
		
		Optional<Admin> Admin = adminRepo.findByContactNumber(contactNumber);
		Admin optAdmin = Admin.orElseThrow(() -> new ExappException(""));
		
		if(optAdmin == null) {
			throw new ExappException("PatientService.INVALID_CREDENTIALS");
		}
		
		String passwordFromDB = optAdmin.getPassword();
		
		if(optAdmin != null) {
			try {
		
				if(password.equals(passwordFromDB)){
					

					AdminDTO adminObj = new AdminDTO();
			
					adminObj.setContactNumber(optAdmin.getContactNumber());
					adminObj.setEmailId(optAdmin.getEmailId());
					adminObj.setAdminId(optAdmin.getAdminId());
					adminObj.setAdminName(optAdmin.getAdminName());
			
					return adminObj;
				}else
					throw new ExappException("AdminService.INVALID_CREDENTIALS");
			}catch (Exception e) {
				throw new ExappException("AdminService.HASH_FUNCTION_EXCEPTION");
			}
		} else {
			throw new ExappException("AdminService.INVALID_CREDENTIALS");
		}
			
	}

	@Override
	public String registerAdmin(AdminDTO admin) throws ExappException {
		Optional<Admin> optPatientC = adminRepo.findByContactNumber(admin.getContactNumber());
		Admin optPatientE = adminRepo.findByEmailId(admin.getEmailId());
		
		if(optPatientC != null || optPatientE != null) {
			throw new ExappException("PatientService.EXISTING_CONTACT_NUMBER");
		}
		else {
			Admin adminNew = new Admin();
			
			adminNew.setContactNumber(admin.getContactNumber());
			adminNew.setEmailId(admin.getEmailId());
			adminNew.setPassword(admin.getPassword());
			adminNew.setAdminName(admin.getAdminName());
			
			adminRepo.save(adminNew);
		}
		return "success";
	}

	@Override
	public String addDoctor(DoctorsDTO doc) throws ExappException {
		Optional<Doctors> optDocC = docRepo.findByContactNumber(doc.getContactNumber());
		Optional<Doctors> optDocE = docRepo.findByEmailId(doc.getEmailId());		
		
		if(optDocC.isPresent() && optDocE.isPresent()) {
			throw new ExappException("");
		}
		else {
			Doctors docNew = new Doctors();
			
			docNew.setDoctorName(doc.getDoctorName());
			docNew.setEmailId(doc.getEmailId());
			docNew.setContactNumber(doc.getContactNumber());
			docNew.setPassword(doc.getPassword());
			
			docRepo.save(docNew);
		}
		return "success";
	}

//	@Override
//	public String patientTempEdit(PatientsDataDTO patientsDataTemp) throws ExappException {
//		
//		Iterable<Patients> patientsAll = patRepo.findAll();
//		List<DataField> list = new ArrayList<DataField>();
//		PatientsData patientsData = new PatientsData();
//		
//		
//		for(Patients patient : patientsAll) {
//			
//			patientsData.setDataField(list);
//			patientsData.setIdPatient(patient.getIdPatient());
//			
//			patient.setContactNumber(patient.getContactNumber());
//			patient.setEmailId(patient.getEmailId());
//			patient.setPassword(patient.getPassword());
//			patient.setPatientName(patient.getPatientName());
//			patient.setAppointment(patient.getAppointment());
//			
//			patient.setIdPatient(patient.getIdPatient());
//			patient.setPatientsData(patientsData);
//			
//			System.out.println(patient);
//			
////			patRepo.save(patient);
//		}
//		
//		return "success";
//	}

	@Override
	public String patientTempEdit(List<DataFieldDTO> newDatafields) throws ExappException {
		
		
		Iterable<Patients> patientAll = patRepo.findAll();
		
		List<DataFieldDTO> sampleDataFields = getPatientTempEdit();
		List<DataFieldDTO> newdataFieldList = newDatafields ;
		
		for(Patients patient : patientAll) {

			PatientsData patientsData = patient.getPatientsData();
			
					for(DataFieldDTO dataField : newdataFieldList) {
						
						if(!sampleDataFields.contains(dataField)) {
							System.out.println(dataField.getFieldName());
							
							Optional<DataField> optdataold = dataFieldRepo.findByFieldName(dataField.getFieldName());
							
							DataField dataold = optdataold.get();
							
							dataFieldRepo.delete(dataold);
						}
						
						
				patientDataRepo.save(patientsData);
				}
					
				patRepo.save(patient);
		}
		
		
												
		for(Patients patient : patientAll) {

			PatientsData patientsData = patient.getPatientsData();
			
					for(DataFieldDTO dataField : newdataFieldList) {
						
						Optional<DataField> optdataold = dataFieldRepo.findByFieldName(dataField.getFieldName());
						
						boolean olddataflag = optdataold.isPresent();
						
						
				if(olddataflag) {	
						
						DataField dataold = optdataold.get();
						System.out.println(dataold.getFieldName());

						dataold.setFieldId(dataold.getFieldId());
						dataold.setFieldName(dataField.getFieldName());
						dataold.setFieldType(dataField.getFieldType());
						dataold.setFieldValue(dataold.getFieldValue());
						
						dataold.setPatientData(dataold.getPatientData());
						
						dataFieldRepo.save(dataold);
	
					}
					else{
						
						DataField datanew = new DataField();
							
						datanew.setFieldName(dataField.getFieldName());
						datanew.setFieldType(dataField.getFieldType());
						datanew.setFieldValue(dataField.getFieldValue());
						datanew.setPatientData(patientsData);
						
						dataFieldRepo.save(datanew);
					}
				patientDataRepo.save(patientsData);
				}
					
				patRepo.save(patient);
		}
		
		return null;
	
	}

	@Override
	public List<DataFieldDTO> getPatientTempEdit() throws ExappException {
		Iterable<PatientsData> patdatas = patientDataRepo.findAll(); 
		
		if (patdatas.iterator().hasNext()) {
			List<DataField> dataFields = dataFieldRepo.findByPatientData(patdatas.iterator().next());
			System.out.println("temp");
		
		
		
		List<DataFieldDTO> dataFieldDTOs = new ArrayList<DataFieldDTO>();
		
		for (DataField field : dataFields) {
			DataFieldDTO dataFieldDTO = new DataFieldDTO();
			
			dataFieldDTO.setFieldId(field.getFieldId());
			dataFieldDTO.setFieldName(field.getFieldName());
			dataFieldDTO.setFieldType(field.getFieldType());
			dataFieldDTO.setFieldValue(field.getFieldValue());
			
			dataFieldDTOs.add(dataFieldDTO);
		}
		
		
		return dataFieldDTOs;
		
		}
		return null;
	}
}

