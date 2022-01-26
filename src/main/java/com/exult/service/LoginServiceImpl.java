package com.exult.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.dto.AdminDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.dto.UserDTO;
import com.exult.entity.Admin;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;
import com.exult.repository.AdminRepo;
import com.exult.repository.DoctorRepo;
import com.exult.repository.PatientRepo;

@Service(value = "loginService")
@Transactional
public class LoginServiceImpl implements LoginService{

	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private DoctorRepo doctorRepo;

	@Override
	public UserDTO authUser(String contactNumber, String password) throws ExappException {
		
		Optional<Patients> optPatients = patientRepo.findByContactNumber(contactNumber);
		Patients patient = optPatients.orElseThrow(() -> new ExappException(""));
		Doctors optDoctors = doctorRepo.findByContactNumber(contactNumber);
		Admin optAdmin = adminRepo.findByContactNumber(contactNumber);
		
		if(optPatients == null && optDoctors == null && optAdmin == null) {
		throw new ExappException("PatientService.INVALID_CREDENTIALS");
		}
		
		if(optPatients != null) {
			try {
				String passwordFromDB = patient.getPassword();
				if(password.equals(passwordFromDB)){
					

					UserDTO userObj = new UserDTO();
			
					userObj.setContactNumber(patient.getContactNumber());
					userObj.setEmailId(patient.getEmailId());
					userObj.setUserId(patient.getIdPatient());
					userObj.setUserName(patient.getPatientName());
			
					return userObj;
				}else
					throw new ExappException("PatientService.INVALID_CREDENTIALS");
			}catch (Exception e) {
				throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
			}
			
		}
		
		if(optDoctors != null) {
			try {
				String passwordFromDB = optDoctors.getPassword();
				if(password.equals(passwordFromDB)){
					

					UserDTO userObj = new UserDTO();
			
					userObj.setContactNumber(optDoctors.getContactNumber());
					userObj.setEmailId(optDoctors.getEmailId());
					userObj.setUserId(optDoctors.getDoctorId());
					userObj.setUserName(optDoctors.getDoctorName());
			
					return userObj;
				}else
					throw new ExappException("PatientService.INVALID_CREDENTIALS");
			}catch (Exception e) {
				throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
			}
			
		}
		
		if(optAdmin != null) {
			try {
				String passwordFromDB = optAdmin.getPassword();
				if(password.equals(passwordFromDB)){
					

					UserDTO userObj = new UserDTO();
			
					userObj.setContactNumber(optAdmin.getContactNumber());
					userObj.setEmailId(optAdmin.getEmailId());
					userObj.setUserId(optAdmin.getAdminId());
					userObj.setUserName(optAdmin.getAdminName());
			
					return userObj;
				}else
					throw new ExappException("PatientService.INVALID_CREDENTIALS");
			}catch (Exception e) {
				throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
			}
		} else {
			throw new ExappException("PatientService.INVALID_CREDENTIALS");
		}	
		}
		
	}
	
//	@Override
//	public PatientsDTO authenticatePatient(String contactNumber, String password) throws ExappException {
//		
//		Patients optPatients = patientRepo.findByContactNumber(contactNumber);
//		
////		if(optPatients == null) {
////			throw new ExappException("PatientService.INVALID_CREDENTIALS");
////		}
//		
//		if(optPatients != null) {
//			try {
//				String passwordFromDB = optPatients.getPassword();
//				if(password.equals(passwordFromDB)){
//					
//
//					PatientsDTO patientObj = new PatientsDTO();
//			
//					patientObj.setContactNumber(optPatients.getContactNumber());
//					patientObj.setEmailId(optPatients.getEmailId());
//					patientObj.setPatientId(optPatients.getPatientId());
//					patientObj.setPatientName(optPatients.getPatientName());
//			
//					return patientObj;
//				}else
//					throw new ExappException("PatientService.INVALID_CREDENTIALS");
//			}catch (Exception e) {
//				throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
//			}
//			
//			
//			
//		} else {
//			throw new ExappException("PatientService.INVALID_CREDENTIALS");
//		}
//			
//	}
//
//	@Override
//	public DoctorsDTO authenticateDoctor(String contactNumber, String password) throws ExappException {
//		
//		Doctors optDoctors = doctorRepo.findByContactNumber(contactNumber);
//		
////		if(optDoctors == null) {
////			throw new ExappException("PatientService.INVALID_CREDENTIALS");
////		}
//		
//		if(optDoctors != null) {
//			try {
//				String passwordFromDB = optDoctors.getPassword();
//				if(password.equals(passwordFromDB)){
//					
//
//					DoctorsDTO doctorObj = new DoctorsDTO();
//			
//					doctorObj.setContactNumber(optDoctors.getContactNumber());
//					doctorObj.setEmailId(optDoctors.getEmailId());
//					doctorObj.setDoctorId(optDoctors.getDoctorId());
//					doctorObj.setDoctorName(optDoctors.getDoctorName());
//			
//					return doctorObj;
//				}else
//					throw new ExappException("PatientService.INVALID_CREDENTIALS");
//			}catch (Exception e) {
//				throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
//			}
//		} else {
//			throw new ExappException("PatientService.INVALID_CREDENTIALS");
//		}
//	}
//
//	@Override
//	public AdminDTO authenticateAdmin(String contactNumber, String password) throws ExappException {
//		
//		Admin optAdmin = adminRepo.findByContactNumber(contactNumber);
//		
////		if(optAdmin == null) {
////			throw new ExappException("PatientService.INVALID_CREDENTIALS");
////		}
//		
//		if(optAdmin != null) {
//			try {
//				String passwordFromDB = optAdmin.getPassword();
//				if(password.equals(passwordFromDB)){
//					
//					AdminDTO adminObj = new AdminDTO();
//			
//					adminObj.setContactNumber(optAdmin.getContactNumber());
//					adminObj.setEmailId(optAdmin.getEmailId());
//					adminObj.setAdminId(optAdmin.getAdminId());
//					adminObj.setAdminName(optAdmin.getAdminName());
//			
//					return adminObj;
//				}else
//					throw new ExappException("PatientService.INVALID_CREDENTIALS");
//			}catch (Exception e) {
//				throw new ExappException("PatientService.HASH_FUNCTION_EXCEPTION");
//			}
//		} else {
//			throw new ExappException("PatientService.INVALID_CREDENTIALS");
//		}
//	}


