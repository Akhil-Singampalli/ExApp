package com.exult.api;

import java.util.List;

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

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

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
			
			HttpResponse<String> response = Unirest.post("https://api.msg91.com/api/v5/flow/")
					  .header("authkey", "312379AYnyiHzkHSVm6161ac34P1")
					  .header("content-type", "application/JSON")
					  .body("{\n  \"flow_id\": \"6170120fd0d1872f0d155e7a\",\n  \"sender\": \"exults\",\n  \"mobiles\": \"919515050278 \",\n  \"VAR1\": \"VALUE 1\",\n  \"VAR2\": \"VALUE 2\"\n}")
					  .asString();
			System.out.println(response);
			
			
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
	
	@RequestMapping(value = "/cancelApt/{aptId}",method = RequestMethod.POST)
	public ResponseEntity<String> cancelAppointment(@PathVariable Integer aptId){
		try {
			appointmentService.cancelAppointment(aptId);
			return new ResponseEntity<String>("aptAPI.APPOINTMENT_PATIENT_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/editApt/{aptId}",method = RequestMethod.POST)
	public ResponseEntity<String> editAppointment(@PathVariable Integer aptId,@RequestBody AppointmentDTO aptUpdate){
		try {
			appointmentService.editAppointment(aptId, aptUpdate);
			return new ResponseEntity<String>("aptAPI.APPOINTMENT_PATIENT_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/fetchApt/{aptId}",method = RequestMethod.GET)
	public ResponseEntity<AppointmentDTO> editAppointment(@PathVariable Integer aptId){
		try {
			AppointmentDTO aptDTO =  appointmentService.fetchAppointment(aptId);
			return new ResponseEntity<AppointmentDTO>(aptDTO,HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/getApt/{userId}",method = RequestMethod.GET)
	public ResponseEntity<List<AppointmentDTO>> viewAppointments(@PathVariable Integer userId){
		try {
			List<AppointmentDTO> aptDTO = appointmentService.viewAppointment(userId);
			return new ResponseEntity<List<AppointmentDTO>>(aptDTO,HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/getApts",method = RequestMethod.GET)
	public ResponseEntity<List<AppointmentDTO>> viewAllAppointments(){
		try {
			List<AppointmentDTO> aptsDTO = appointmentService.viewAllAppointment();
			return new ResponseEntity<List<AppointmentDTO>>(aptsDTO,HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
}
