package com.exult.service;

import com.exult.dto.PatientsDTO;
import com.exult.exception.ExappException;

public interface PatientsService {

	public PatientsDTO authenticatePatient(String contactNumber,String password) throws ExappException;
	
	public String registerPatient(PatientsDTO patient) throws ExappException;
	
}
