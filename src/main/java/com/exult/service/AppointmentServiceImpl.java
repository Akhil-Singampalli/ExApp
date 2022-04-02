package com.exult.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
			try {
				emailSenderService.sendNotification(patient.getEmailId(), body, patsubject);
				emailSenderService.sendAppointmentMail(doctor.getEmailId(), docsubject, patient.getPatientName(), newAppointment.getAptTime(), newAppointment.getAptDate(), newAppointment.getAptId());
			} catch (ExappException e) {
				
			} catch (MessagingException e) {
			
			}			
		}
		return "appointment booked";
	}

	@Override
	public AppointmentDTO confirmAppointment(Integer aptId) throws ExappException {
		
		Optional<Appointment> optApt = appointmentRepo.findById(aptId);
		Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
		
		Optional<Patients> optPatient = patientRepo.findById(appointment.getPatientId());
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		
		appointment.setAptStatus("Confirm");
		
		String patsubject = "Appointment Confirmed";
		String body = "Hi "+ patient.getPatientName() +" Your appointment request for "+ appointment.getDoctorId() + " on " + appointment.getAptDate()+ " at "+ appointment.getAptTime() + " is Confirmed !!! ";
		
		emailSenderService.sendNotification(patient.getEmailId(), body, patsubject);
		return null;
	}

	@Override
	public AppointmentDTO cancelAppointment(Integer aptId) throws ExappException {
		
		Optional<Appointment> optApt = appointmentRepo.findById(aptId);
		Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
		
		Optional<Patients> optPatient = patientRepo.findById(appointment.getPatientId());
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		
		appointment.setAptStatus("Cancelled");
		
		appointmentRepo.delete(appointment);
		
		String patsubject = "Appointment Cancelled";
		String body = "Hi "+ patient.getPatientName() +" Your appointment request for "+ appointment.getDoctorId() + " on " + appointment.getAptDate()+ " at "+ appointment.getAptTime() + " is Cancelled !!! ";
		
		emailSenderService.sendNotification(patient.getEmailId(), body, patsubject);
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
	public AppointmentDTO editAppointment(Integer aptId, AppointmentDTO aptDTO) throws ExappException {
		
		Optional<Appointment> optApt = appointmentRepo.findById(aptId);
		Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
		
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



