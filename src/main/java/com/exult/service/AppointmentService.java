package com.exult.service;

import java.time.LocalDateTime;
import java.util.List;

import com.exult.dto.AppointmentDTO;
import com.exult.exception.ExappException;

public interface AppointmentService {

	public String bookAppointment(AppointmentDTO appointmentDTO) throws ExappException;
	
	public String confirmAppointment(Integer aptId,String googleEvent) throws ExappException;
	
	public AppointmentDTO cancelAppointment(Integer aptId) throws ExappException;
	
	public AppointmentDTO editAppointment(Integer aptId,AppointmentDTO aptDTO) throws ExappException;
	
	public List<AppointmentDTO> viewAppointment(Integer appointmentDTO) throws ExappException;

	public List<AppointmentDTO> viewAllAppointment()throws ExappException;

	public AppointmentDTO fetchAppointment(Integer aptId) throws ExappException;

	public List<AppointmentDTO> getAptReminders(LocalDateTime date) throws ExappException;
	
	
}
