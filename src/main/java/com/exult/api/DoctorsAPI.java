package com.exult.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exult.dto.DataFieldDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.service.DoctorsService;
import com.exult.service.DoctorsServiceImpl;


@CrossOrigin(origins = "http://82.180.162.253", maxAge = 3600)
@RestController
@RequestMapping("/docAPI")
public class DoctorsAPI {

	@Autowired
	private DoctorsServiceImpl doctorService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/details")
	public ResponseEntity<List<DoctorsDTO>> allDoctorDetails() {
		try {
			List<DoctorsDTO> docsFromDB =  doctorService.docDetails();
			return new ResponseEntity<List<DoctorsDTO>>(docsFromDB, HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "/doctor/{docId}")
	public ResponseEntity<DoctorsDTO> fetchDoctor(@PathVariable Integer docId) {
		try {
			DoctorsDTO docsFromDB =  doctorService.getDoctor(docId);
			return new ResponseEntity<DoctorsDTO>(docsFromDB, HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "/patdata/{doctorId}")
	public ResponseEntity<List<PatientsDTO>> patientsData(@PathVariable Integer doctorId) {
		try {
			List<PatientsDTO> patsFromDB =  doctorService.PatientsData(doctorId);
			return new ResponseEntity<List<PatientsDTO>>(patsFromDB, HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@PutMapping(value = "/dataUpdate/{patientId}")
	public ResponseEntity<String> updatePatientData(@PathVariable Integer patientId,@RequestBody List<DataFieldDTO> dataFieldDTOlist) {
		try {
			doctorService.updatePatientData(patientId,dataFieldDTOlist);
			return new ResponseEntity<String>("success", HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
}
