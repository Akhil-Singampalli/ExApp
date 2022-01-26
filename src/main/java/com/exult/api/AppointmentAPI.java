package com.exult.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exult.dto.AppointmentDTO;
import com.exult.dto.PatientsDTO;
import com.exult.service.AppointmentService;

@CrossOrigin
@RestController
@RequestMapping("/aptAPI")
public class AppointmentAPI {

	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private Environment environment;
	
	@PostMapping(value = "/bookApt")
	public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDTO appointment){
		try {
			appointmentService.bookAppointment(appointment);
			return new ResponseEntity<String>("aptAPI.APPOINTMENT_PATIENT_SUCCESS1"+"aptAPI.APPOINTMENT_PATIENT_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/confirmApt/{aptId}",method = RequestMethod.PUT)
	public ResponseEntity<String> confirmAppointment(@PathVariable Integer aptId){
		try {
			appointmentService.confirmAppointment(aptId);
			return new ResponseEntity<String>("aptAPI.APPOINTMENT_PATIENT_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
}
