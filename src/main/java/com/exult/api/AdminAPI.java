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

import com.exult.dto.AdminDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.service.AdminService;



@Validated
@CrossOrigin
@RestController
@RequestMapping("/adminAPI")
public class AdminAPI {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "/Login",method = RequestMethod.POST)
	public ResponseEntity<AdminDTO> authenticatePatient(@RequestBody AdminDTO admin) {
		try {
			AdminDTO adminFromDB = adminService.authenticateAdmin(admin.getContactNumber(), admin.getPassword());
			return new ResponseEntity<AdminDTO>(adminFromDB, HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/adminRegister", method = RequestMethod.POST)
	public ResponseEntity<String> registerAdmin(@RequestBody @Valid AdminDTO admin){
		try {
			adminService.registerAdmin(admin);
			return new ResponseEntity<String>("UserAPI.REGISTER_USER_SUCCESS1"+"UserAPI.REGISTER_USER_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/docRegister", method = RequestMethod.POST)
	public ResponseEntity<String> registerDoctor(@RequestBody @Valid DoctorsDTO doc){
		try {
			adminService.addDoctor(doc);
			return new ResponseEntity<String>("UserAPI.REGISTER_USER_SUCCESS1"+"UserAPI.REGISTER_USER_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}

}
