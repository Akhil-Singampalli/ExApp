package com.exult.service;

import com.exult.exception.ExappException;

public interface EmailSenderService {

	public void sendNotification(String to,String body,String subject) throws ExappException;
}
