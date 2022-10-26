package com.exult.service;

import java.util.List;

import com.exult.dto.AdminDTO;
import com.exult.dto.DataFieldDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.dto.PatientsDataDTO;
import com.exult.exception.ExappException;
import com.exult.util.OauthConfig;

public interface AdminService {

	public AdminDTO authenticateAdmin(String contactNumber,String password) throws ExappException;
	
	public String registerAdmin(AdminDTO admin) throws ExappException;
	public String addDoctor(DoctorsDTO doc) throws ExappException;
	public String patientTempEdit(List<DataFieldDTO> datafield) throws ExappException;

	public List<DataFieldDTO> getPatientTempEdit() throws ExappException;

	public OauthConfig setOauthConfig(OauthConfig config) throws ExappException;
}
