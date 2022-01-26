package com.exult.service;

import javax.mail.MessagingException;
import javax.naming.Context;

import org.springframework.core.io.Resource;

import com.exult.exception.ExappException;

public interface EmailSenderService {

	public void sendNotification(String to,String body,String subject) throws ExappException;
	
	public void sendAppointmentMail(String to, String subject, String patientName,String time,String date,Integer aptId) throws ExappException, MessagingException;
}
