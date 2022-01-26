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
		
		
		Optional<Patients> optPatient = patientRepo.findById(appointmentDTO.getAptPatientId());
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		
		
		Optional<Doctors> optdoctor = doctorRepo.findById(appointmentDTO.getAptDoctorId());
		Doctors doctor = optdoctor.orElseThrow(()-> new ExappException(""));
		
//		Optional<Admin> optAdmin = adminRepo.findById(1);
//		Admin admin = optAdmin.orElseThrow(() -> new ExappException(""));
		
		
		if(optPatient != null) {
			
			Appointment newAppointment = new Appointment();
			
			newAppointment.setAptDate(appointmentDTO.getAptDate());
			newAppointment.setAptTime(appointmentDTO.getAptTime());
			newAppointment.setAptStatus("Pending");
			newAppointment.setPatient(patient);
			newAppointment.setDoctor(doctor);
//			newAppointment.setAdmin(admin);
			

			
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
		
		Optional<Patients> optPatient = patientRepo.findById(appointment.getPatient().getIdPatient());
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		
		appointment.setAptStatus("Confirm");
		
		String patsubject = "Appointment Confirmed";
		String body = "Hi "+ patient.getPatientName() +" Your appointment request for "+ appointment.getDoctor().getDoctorName() + " on " + appointment.getAptDate()+ " at "+ appointment.getAptTime() + " is Confirmed !!! ";
		
		emailSenderService.sendNotification(patient.getEmailId(), body, patsubject);
		return null;
	}

	@Override
	public AppointmentDTO cancelAppointmentDTO(Integer aptId) throws ExappException {
		
		Optional<Appointment> optApt = appointmentRepo.findById(aptId);
		Appointment appointment = optApt.orElseThrow(()->new ExappException(""));
		
		Optional<Patients> optPatient = patientRepo.findById(appointment.getPatient().getIdPatient());
		Patients patient = optPatient.orElseThrow(()-> new ExappException("AppointmentService.INVALID_PATIENT_DOCTOR"));
		
		appointment.setAptStatus("Cancelled");
		
		String patsubject = "Appointment Cancelled";
		String body = "Hi "+ patient.getPatientName() +" Your appointment request for "+ appointment.getDoctor().getDoctorName() + " on " + appointment.getAptDate()+ " at "+ appointment.getAptTime() + " is Cancelled !!! ";
		
		emailSenderService.sendNotification(patient.getEmailId(), body, patsubject);
		return null;
		
	}

	@Override
	public List<AppointmentDTO> viewAppointment(Integer userId) throws ExappException {
		
//		Optional<List<Appointment>> optAptP = appointmentRepo.findByPatient(userId);
//		Optional<List<Appointment>> optAptD = appointmentRepo.findByDoctor(userId);
//		List<Appointment> aptP = optAptP.orElseThrow(() -> new ExappException(""));
//		List<Appointment> aptD = optAptD.orElseThrow(() -> new ExappException(""));
//		
//		if(optAptP == null && optAptD == null) {
//			throw new ExappException("");
//		}
//		List<AppointmentDTO> aptList = new ArrayList<>();
//		return aptList;
		
		return null;
		
	}

}
