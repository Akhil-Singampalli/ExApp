package com.exult.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.exult.exception.ExappException;

@Service(value = "emailSenderService")
@Transactional
public class EmailSenderServiceImpl implements EmailSenderService {
	
	@Autowired
	private JavaMailSender notificationSender;

	@Override
	public void sendNotification(String to, String body, String subject) throws ExappException {
		
		SimpleMailMessage msg = new SimpleMailMessage();
		
		msg.setFrom("singampalliakhil@gmail.com");
		msg.setTo(to);
		msg.setText(body);
		msg.setSubject(subject);
		
		notificationSender.send(msg);
//		System.out.println("Email sent");

	}

}
