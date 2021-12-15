package com.exult.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exult.dto.DoctorsDTO;
import com.exult.entity.Doctors;
import com.exult.service.DoctorsService;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/docAPI")
public class DoctorsAPI {

	@Autowired
	private DoctorsService doctorService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/details")
	public ResponseEntity<List<Doctors>> doctorDetails(@RequestBody DoctorsDTO admin) {
		try {
			List<Doctors> docsFromDB =  doctorService.docDetails();
			return new ResponseEntity<List<Doctors>>(docsFromDB, HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
}
