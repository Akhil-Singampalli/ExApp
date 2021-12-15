package com.exult.service;

import com.exult.dto.AdminDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.exception.ExappException;

public interface AdminService {

	public AdminDTO authenticateAdmin(String contactNumber,String password) throws ExappException;
	
	public String registerAdmin(AdminDTO admin) throws ExappException;
	public String addDoctor(DoctorsDTO doc) throws ExappException;
}
