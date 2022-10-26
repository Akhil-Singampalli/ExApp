package com.exult.util;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.exult.entity.Configurations;
import com.exult.repository.ConfigRepo;
 
@Configuration
public class EmailConfig 
{
	@Autowired
	private ConfigRepo configRepo;
	
  @Bean
  public JavaMailSender getJavaMailSender() 
  {
	  Configurations configs = configRepo.findById(1).get();
      JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
      mailSender.setHost("smtp.gmail.com");
      mailSender.setPort(587);
        
      mailSender.setUsername(configs.getSendermail());
      mailSender.setPassword(configs.getMailpassword());
        
      Properties props = mailSender.getJavaMailProperties();
      props.put("mail.transport.protocol", "smtp");
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.debug", "true");
        
      return mailSender;
  }
   
  @Bean
  public SimpleMailMessage emailTemplate()
  {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo("somebody@gmail.com");
    message.setFrom("admin@gmail.com");
      message.setText("FATAL - Application crash. Save your job !!");
      return message;
  }
}