package com.exult.api;

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
import com.exult.dto.PatientsDTO;
import com.exult.dto.UserDTO;
import com.exult.service.LoginService;
import com.exult.service.PatientsService;

@Validated
@CrossOrigin(origins = "http://82.180.162.253", maxAge = 3600)
@RestController
@RequestMapping("/loginAPI")
public class LoginAPI {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public ResponseEntity<UserDTO> authenticateUser(@RequestBody UserDTO user) {
		try {						
			UserDTO userFromDB = loginService.authUser(user.getContactNumber(), user.getPassword());

				return new ResponseEntity<UserDTO>(userFromDB, HttpStatus.OK);

			
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
		
	}

}
