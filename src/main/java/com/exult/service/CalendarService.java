package com.exult.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.exult.dto.AppointmentDTO;
import com.exult.exception.ExappException;

public interface CalendarService {

	public String CreateEvent(String patMail,String docMail,String slot) throws ExappException, IOException;
}
