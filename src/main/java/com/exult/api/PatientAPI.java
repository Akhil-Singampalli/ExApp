package com.exult.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exult.dto.PatientsDTO;
import com.exult.service.PatientsService;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/patientAPI")
public class PatientAPI {

	@Autowired
	private PatientsService patientsService;
	
	@Autowired
	private Environment environment;
	
	
	
	@RequestMapping(value = "/patientRegister", method = RequestMethod.POST)
	public ResponseEntity<String> registerPatient(@RequestBody @Valid PatientsDTO patient){
		try {
			patientsService.registerPatient(patient);
			return new ResponseEntity<String>("UserAPI.REGISTER_USER_SUCCESS1"+"UserAPI.REGISTER_USER_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
}
