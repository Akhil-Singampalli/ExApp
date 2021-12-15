package com.exult.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.dto.AdminDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.entity.Admin;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;
import com.exult.repository.AdminRepo;
import com.exult.repository.DoctorRepo;

@Service(value = "adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private DoctorRepo docRepo;

	@Override
	public AdminDTO authenticateAdmin(String contactNumber, String password) throws ExappException {
		
Admin optAdmin = adminRepo.findByContactNumber(contactNumber);
		
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
		Admin optPatientC = adminRepo.findByContactNumber(admin.getContactNumber());
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
		Doctors optDocC = docRepo.findByContactNumber(doc.getContactNumber());
		Doctors optDocE = docRepo.findByEmailId(doc.getEmailId());		
		if(optDocC != null || optDocE != null) {
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
	
}

