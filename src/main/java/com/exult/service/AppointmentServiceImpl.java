package com.exult.service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.exult.dto.AppointmentDTO;
import com.exult.entity.Admin;
import com.exult.entity.Appointment;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;
import com.exult.repository.AdminRepo;
import com.exult.repository.AppointmentRepo;
import com.exult.repository.DoctorRepo;
import com.exult.repository.PatientRepo;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Service("AppointmentService")
@Transactional
public class AppointmentServiceImpl implements AppointmentService {
	
	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private AppointmentRepo appointmentRepo;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@Autowired
	private CalendarService calendarService;
	
	
	@Override
	public String bookAppointment(AppointmentDTO appointmentDTO) throws ExappException {
		
		Integer idP = Integer.parseInt(appointmentDTO.getAptPatient());
		Optional<Patients> optPatient = patientRepo.findById(idP);
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		System.out.println(optPatient);
		
		Integer idD = Integer.parseInt(appointmentDTO.getAptDoctor());
		Optional<Doctors> optdoctor = doctorRepo.findById(idD);
		Doctors doctor = optdoctor.orElseThrow(()-> new ExappException(""));
		System.out.println(optdoctor);

		
		
		if(optPatient.isPresent()) {
			
			Appointment newAppointment = new Appointment();
			
			newAppointment.setAptDate(appointmentDTO.getAptDate());
			newAppointment.setAptTime(appointmentDTO.getAptTime());
			newAppointment.setAptStatus("Pending");
			newAppointment.setDoctorId(doctor.getDoctorId());
			newAppointment.setPatientId(patient.getIdPatient());
			newAppointment.setAdminId(1);
			

			System.out.println(newAppointment);
			appointmentRepo.save(newAppointment);
			
			String patsubject = "Appointment Request";
			String docsubject = "Appointment Acknowledgement";
			
			String body = "Hi "+ patient.getPatientName() +" Your appointment request for "+ doctor.getDoctorName() + " on " + appointmentDTO.getAptDate()+ " at "+ appointmentDTO.getAptTime() + " was submitted succesfully ";
			HttpResponse<String> response = Unirest.post("https://api.msg91.com/api/v5/flow/")
					  .header("authkey", "312379Aay5EN3Wmolq627385a5P1")
					  .header("content-type", "application/JSON")
					  .body("{\n  \"flow_id\": \"627381e28e6dc861e86cbb62\",\n  \"sender\": \"EXULTC\",\n \"short_url\": \"1\",\n  \"mobiles\": \"91"+patient.getContactNumber()+" \",\n  \"name\": \""+doctor.getDoctorName()+"\",\n  \"place\": \"Visakhapatnam\"\n,  \"date\": \""+appointmentDTO.getAptDate()+"\"\n, \"time\": \""+appointmentDTO.getAptTime()+"\"\n}")
					  .asString();

				emailSenderService.sendMail(patient.getEmailId(), body, patsubject);
//				try {
//					emailSenderService.sendAppointmentMail(doctor.getEmailId(), docsubject, patient.getPatientName(), newAppointment.getAptTime(), newAppointment.getAptDate(), newAppointment.getAptId());
//				} catch (ExappException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (MessagingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}			
		}
		return "appointment booked";
	}
 
	@Override
	public String confirmAppointment(Integer aptId,String googleEvent) throws ExappException {
		
		
		try {
			Optional<Appointment> optApt = appointmentRepo.findById(aptId);
			Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
			
			Optional<Patients> optPatient = patientRepo.findById(appointment.getPatientId());
			Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
			
			Optional<Doctors> optdoctor = doctorRepo.findById(appointment.getDoctorId());
			Doctors doctor = optdoctor.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
			
			
			String slot = appointment.getAptDate() + " " + appointment.getAptTime();
			
			String[] eid = googleEvent.split("eid=");
			System.out.println(eid[1]);
			appointment.setAptStatus(eid[1]);
			appointmentRepo.save(appointment);
			
			String patsubject = "Appointment Confirmed";
			String body = "Hi "+ patient.getPatientName() +" Your appointment request for "+ appointment.getDoctorId() + " on " + appointment.getAptDate()+ " at "+ appointment.getAptTime() + " is Confirmed !!! ";
			
			HttpResponse<String> response = Unirest.post("https://api.msg91.com/api/v5/flow/")
					  .header("authkey", "312379Aay5EN3Wmolq627385a5P1")
					  .header("content-type", "application/JSON")
					  .body("{\n  \"flow_id\": \"6273823cbcc4b523646e6fbd\",\n  \"sender\": \"EXULTC\",\n \"short_url\": \"1\",\n  \"mobiles\": \"91"+patient.getContactNumber()+" \",\n  \"name\": \""+doctor.getDoctorName()+"\",\n  \"place\": \"Visakhapatnam1007\",\n \"date\": \""+appointment.getAptDate()+"\",\n \"time\": \""+appointment.getAptTime()+"\"\n}")
					  .asString();
			
			emailSenderService.sendMail(patient.getEmailId(), body, patsubject);
			
			return "Updated";
			
			
		} catch (ExappException e) {

			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public AppointmentDTO cancelAppointment(Integer aptId) throws ExappException {
		
		Optional<Appointment> optApt = appointmentRepo.findById(aptId);
		Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
		
		Optional<Patients> optPatient = patientRepo.findById(appointment.getPatientId());
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		
		Optional<Doctors> optdoctor = doctorRepo.findById(appointment.getDoctorId());
		Doctors doctor = optdoctor.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		
		
		appointment.setAptStatus("Cancelled");
		
		appointmentRepo.delete(appointment);
		
		String patsubject = "Appointment Cancelled";
		String body = "Hi "+ patient.getPatientName() +" Your appointment request for "+ appointment.getDoctorId() + " on " + appointment.getAptDate()+ " at "+ appointment.getAptTime() + " is Cancelled !!! ";
		
		HttpResponse<String> response = Unirest.post("https://api.msg91.com/api/v5/flow/")
				  .header("authkey", "312379Aay5EN3Wmolq627385a5P1")
				  .header("content-type", "application/JSON")
				  .body("{\n  \"flow_id\": \"627381514b62900fc17375d6\",\n  \"sender\": \"EXULTC\",\n \"short_url\": \"1\",\n  \"mobiles\": \"91"+patient.getContactNumber()+" \",\n  "
				  		+ "\"name\": \""+doctor.getDoctorName()+"\",\n  "
				  				+ "\"place\": \"Visakhapatnam1007\",\n"
				  				+ "\"date\": \""+appointment.getAptDate()+"\",\n"
				  						+ "\"time\": \""+appointment.getAptTime()+"\"\n}")
				  .asString();
		
		emailSenderService.sendMail(patient.getEmailId(), body, patsubject);
		
		return null;
		
	}

	@Override
	public List<AppointmentDTO> viewAppointment(Integer userId) throws ExappException {
		
		Optional<List<Appointment>> optAptP = appointmentRepo.findByPatientid(userId);
		Optional<List<Appointment>> optAptD = appointmentRepo.findByDoctorid(userId);
		System.out.println(optAptD);
		
		List<AppointmentDTO> aptList = new ArrayList<AppointmentDTO>();
		
		if(optAptP.isEmpty() && optAptD.isEmpty()) {
			throw new ExappException("");
		}
		if(optAptD.isPresent()) {
			
			List<Appointment> aptD = optAptD.get();
			
			for(Appointment aptDoc : aptD ) {
				
				Optional<Patients> patient = patientRepo.findById(aptDoc.getPatientId());
				Optional<Doctors> doctor = doctorRepo.findById(aptDoc.getDoctorId());
				
				AppointmentDTO appointmentDTO = new AppointmentDTO();
				
				appointmentDTO.setAptDate(aptDoc.getAptDate());
				appointmentDTO.setAptTime(aptDoc.getAptTime());
				appointmentDTO.setAptStatus(aptDoc.getAptStatus());
				
				
				appointmentDTO.setAptPatient(patient.get().getPatientName());
				appointmentDTO.setAptDoctor(doctor.get().getDoctorName());
				appointmentDTO.setAptId(aptDoc.getAptId());
				
				aptList.add(appointmentDTO);
			}
			
			
		}
		if(optAptP.isPresent()) {
			List<Appointment> aptP = optAptP.get();
			System.out.println(aptP);
			
			for(Appointment aptPat : aptP ) {
				
				Optional<Patients> patient = patientRepo.findById(aptPat.getPatientId());
				Optional<Doctors> doctor = doctorRepo.findById(aptPat.getDoctorId());
				
				
				AppointmentDTO appointmentDTO = new AppointmentDTO();
				
				appointmentDTO.setAptDate(aptPat.getAptDate());
				appointmentDTO.setAptTime(aptPat.getAptTime());
				appointmentDTO.setAptStatus(aptPat.getAptStatus());
				appointmentDTO.setAptPatient(patient.get().getPatientName());
				appointmentDTO.setAptDoctor(doctor.get().getDoctorName());
				appointmentDTO.setAptId(aptPat.getAptId());
				
				System.out.println(appointmentDTO);
				
				aptList.add(appointmentDTO);
			
		}
		
		
	}
		return aptList;
}

	@Override
	public List<AppointmentDTO> viewAllAppointment() throws ExappException {

		Iterable<Appointment> aptAll = appointmentRepo.findAll();
		
		List<AppointmentDTO> aptAllList = new ArrayList<AppointmentDTO>();
		
		
		
		for(Appointment aptPat : aptAll ) {
			
			Optional<Patients> patient = patientRepo.findById(aptPat.getPatientId());
			Optional<Doctors> doctor = doctorRepo.findById(aptPat.getDoctorId());
			
			
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			
			appointmentDTO.setAptDate(aptPat.getAptDate());
			appointmentDTO.setAptTime(aptPat.getAptTime());
			appointmentDTO.setAptStatus(aptPat.getAptStatus());
			appointmentDTO.setAptPatient(patient.get().getPatientName());
			appointmentDTO.setAptDoctor(doctor.get().getDoctorName());
			appointmentDTO.setAptId(aptPat.getAptId());
			
			System.out.println(appointmentDTO);
			
			aptAllList.add(appointmentDTO);
		
		
	}
		return aptAllList;
	}
	
	@Override
	public List<AppointmentDTO> getAptReminders(LocalDateTime date) throws ExappException {
		
//		LocalDateTime timeNow;
//		
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//			timeNow = LocalDateTime.parse(date, formatter);
//			System.out.println(timeNow);
		
		
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		System.out.println(formattedDate);
		Optional<List<Appointment>> aptAllOpt = appointmentRepo.findByAptDate(formattedDate);
		List<Appointment> aptAll = aptAllOpt.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		List<AppointmentDTO> aptAllList = new ArrayList<AppointmentDTO>();
		
		
		
		for(Appointment aptPat : aptAll ) {
			
			Optional<Patients> patient = patientRepo.findById(aptPat.getPatientId());
			Optional<Doctors> doctor = doctorRepo.findById(aptPat.getDoctorId());
			
			
			AppointmentDTO appointmentDTO = new AppointmentDTO();
			
			appointmentDTO.setAptDate(aptPat.getAptDate());
			appointmentDTO.setAptTime(aptPat.getAptTime());
			appointmentDTO.setAptStatus(aptPat.getAptStatus());
			appointmentDTO.setAptPatient(patient.get().getPatientName());
			appointmentDTO.setAptDoctor(doctor.get().getDoctorName());
			appointmentDTO.setAptId(aptPat.getAptId());
			
			System.out.println(appointmentDTO);
			
			aptAllList.add(appointmentDTO);
		
		
	}
		return aptAllList;
	}

	@Override
	public AppointmentDTO editAppointment(Integer aptId, AppointmentDTO aptDTO) throws ExappException {
		
		Optional<Appointment> optApt = appointmentRepo.findById(aptId);
		Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
		
		String dateOld = appointment.getAptDate();
		String timeOld = appointment.getAptTime();
		
		Integer idP = Integer.parseInt(aptDTO.getAptPatient());
		Optional<Patients> optPatient = patientRepo.findById(idP);
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		System.out.println(optPatient);
		
		Integer idD = Integer.parseInt(aptDTO.getAptDoctor());
		Optional<Doctors> optdoctor = doctorRepo.findById(idD);
		Doctors doctor = optdoctor.orElseThrow(()-> new ExappException(""));
		System.out.println(optdoctor);
		
		appointment.setAptDate(aptDTO.getAptDate());
		appointment.setAptTime(aptDTO.getAptTime());
		appointment.setDoctorId(Integer.parseInt(aptDTO.getAptDoctor()));
//		appointment.setPatientId(Integer.parseInt(aptDTO.getAptPatient()));
		
		HttpResponse<String> response = Unirest.post("https://api.msg91.com/api/v5/flow/")
				  .header("authkey", "312379Aay5EN3Wmolq627385a5P1")
				  .header("content-type", "application/JSON")
				  .body("{\n  \"flow_id\": \"62737e2b85098f70207fd482\",\n "
				  		+ " \"sender\": \"EXULTC\",\n \"short_url\": \"1\",\n "
				  		+ " \"mobiles\": \"91"+patient.getContactNumber()+" \",\n "
				  				+ " \"name\": \""+doctor.getDoctorName()+"\",\n "
				  						+ " \"place\": \"Visakhapatnam\",\n "
				  						+ " \"dateold\": \""+dateOld+"\",\n"
				  								+ " \"timeold\": \""+timeOld+"\",\n"
				  										+ " \"datenew\": \""+appointment.getAptDate()+"\",\n"
				  												+ "\"timenew\": \""+appointment.getAptTime()+"\"\n}").asString();
		
		appointmentRepo.save(appointment);
		
		
		return null;
	}

	@Override
	public AppointmentDTO fetchAppointment(Integer aptId) throws ExappException {
		
		Optional<Appointment> optApt = appointmentRepo.findById(aptId);
		Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
		
		
		Optional<Patients> optPatient = patientRepo.findById(appointment.getPatientId());
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		System.out.println(optPatient);
		
		Optional<Doctors> optdoctor = doctorRepo.findById(appointment.getDoctorId());
		Doctors doctor = optdoctor.orElseThrow(()-> new ExappException(""));
		System.out.println(optdoctor);
		
		AppointmentDTO appointmentDTO = new AppointmentDTO();
		
		appointmentDTO.setAptDate(appointment.getAptDate());
		appointmentDTO.setAptTime(appointment.getAptTime());
		appointmentDTO.setAptStatus(appointment.getAptStatus());
		appointmentDTO.setAptPatient(patient.getEmailId());
		appointmentDTO.setAptDoctor(doctor.getEmailId());
		appointmentDTO.setAptId(appointment.getAptId());
		
		return appointmentDTO;
	}
}



