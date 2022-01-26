package com.exult.service;

import java.util.List;

import com.exult.dto.AppointmentDTO;
import com.exult.exception.ExappException;

public interface AppointmentService {

	public String bookAppointment(AppointmentDTO appointmentDTO) throws ExappException;
	
	public AppointmentDTO confirmAppointment(Integer aptId) throws ExappException;
	
	public AppointmentDTO cancelAppointmentDTO(Integer aptId) throws ExappException;
	
	public List<AppointmentDTO> viewAppointment(Integer appointmentDTO) throws ExappException;
	
}
