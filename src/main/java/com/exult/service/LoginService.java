package com.exult.service;

import com.exult.dto.AdminDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.dto.UserDTO;
import com.exult.exception.ExappException;

public interface LoginService {

//	public PatientsDTO authenticatePatient(String contactNumber,String password) throws ExappException;
//	
//	public DoctorsDTO authenticateDoctor(String contactNumber,String password) throws ExappException;
//
//	public AdminDTO authenticateAdmin(String contactNumber,String password) throws ExappException;
	
	public UserDTO authUser(String contactNumber,String password) throws ExappException;
}
