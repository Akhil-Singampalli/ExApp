package com.exult.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import com.exult.exception.ExappException;

@Service(value = "emailSenderService")
@Transactional
public class EmailSenderServiceImpl implements EmailSenderService {
	
	@Autowired
	private JavaMailSender notificationSender;
	
	@Autowired
	private MailProperties  mailProperties;
	
//	@Autowired
//	private MimeMessageHelper helper;
	
	

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

	@Override
	public void sendAppointmentMail(String to, String subject, String patientName,String time,String date,Integer aptId)
			throws ExappException, MessagingException {
		
		MimeMessage mail = notificationSender.createMimeMessage();
		String body = "<!DOCTYPE html>\r\n"
				+ "\r\n"
				+ "<html lang=\"en\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\">\r\n"
				+ "<head>\r\n"
				+ "<title></title>\r\n"
				+ "<meta charset=\"utf-8\"/>\r\n"
				+ "<meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\"/>\r\n"
				+ "<!--[if mso]><xml><o:OfficeDocumentSettings><o:PixelsPerInch>96</o:PixelsPerInch><o:AllowPNG/></o:OfficeDocumentSettings></xml><![endif]-->\r\n"
				+ "<!--[if !mso]><!-->\r\n"
				+ "<link href=\"https://fonts.googleapis.com/css?family=Lato\" rel=\"stylesheet\" type=\"text/css\"/>\r\n"
				+ "<!--<![endif]-->\r\n"
				+ "<style>\r\n"
				+ "		* {\r\n"
				+ "			box-sizing: border-box;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		body {\r\n"
				+ "			margin: 0;\r\n"
				+ "			padding: 0;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		a[x-apple-data-detectors] {\r\n"
				+ "			color: inherit !important;\r\n"
				+ "			text-decoration: inherit !important;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		#MessageViewBody a {\r\n"
				+ "			color: inherit;\r\n"
				+ "			text-decoration: none;\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		p {\r\n"
				+ "			line-height: inherit\r\n"
				+ "		}\r\n"
				+ "\r\n"
				+ "		@media (max-width:620px) {\r\n"
				+ "			.icons-inner {\r\n"
				+ "				text-align: center;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.icons-inner td {\r\n"
				+ "				margin: 0 auto;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.row-content {\r\n"
				+ "				width: 100% !important;\r\n"
				+ "			}\r\n"
				+ "\r\n"
				+ "			.stack .column {\r\n"
				+ "				width: 100%;\r\n"
				+ "				display: block;\r\n"
				+ "			}\r\n"
				+ "		}\r\n"
				+ "	</style>\r\n"
				+ "</head>\r\n"
				+ "<body style=\"background-color: #f6f5f1; margin: 0; padding: 0; -webkit-text-size-adjust: none; text-size-adjust: none;\">\r\n"
				+ "\r\n"
				+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row row-2\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt;\" width=\"100%\">\r\n"
				+ "<tbody>\r\n"
				+ "<tr>\r\n"
				+ "<td>\r\n"
				+ "<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"row-content stack\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; background-color: #e7dfd3; color: #000000; width: 600px;\" width=\"600\">\r\n"
				+ "<tbody>\r\n"
				+ "<tr>\r\n"
				+ "<td class=\"column\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; font-weight: 400; text-align: left; vertical-align: top; padding-left: 10px; padding-right: 10px; padding-top: 10px; padding-bottom: 10px; border-top: 0px; border-right: 0px; border-bottom: 0px; border-left: 0px;\" width=\"100%\">\r\n"
				+ "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
				+ "<tr>\r\n"
				+ "<td>\r\n"
				+ "<tbody>\r\n"
				+ "<div style=\"font-family: Tahoma, Verdana, sans-serif\">\r\n"
				+ "<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #555555; line-height: 1.2;\">\r\n"
				+ "<p style=\"margin: 0; font-size: 14px; text-align: center;\">APPOINTMENT ACKNOWLEDGEMENT</p>\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "</td>\r\n"
				+ "</tr>\r\n"
				+ "</table>\r\n"
				+ "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
				+ "<tr>\r\n"
				+ "<td>\r\n"
				+ "<tbody>\r\n"
				+ "<div style=\"font-family: Tahoma, Verdana, sans-serif\">\r\n"
				+ "<div style=\"font-size: 14px; font-family: 'Lato', Tahoma, Verdana, Segoe, sans-serif; mso-line-height-alt: 16.8px; color: #555555; line-height: 1.2;\">\r\n"
				+ "<p style=\"margin: 0; font-size: 14px; text-align: center;\">Appointment is requested by"
				+ patientName + " on " + date + " at " + time +" please accept or decline </p>\r\n"
				+ "</div>\r\n"
				+ "</div>\r\n"
				+ "</td>\r\n"
				+ "</tr>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "<table border=\"0\" cellpadding=\"10\" cellspacing=\"0\" class=\"text_block\" role=\"presentation\" style=\"mso-table-lspace: 0pt; mso-table-rspace: 0pt; word-break: break-word;\" width=\"100%\">\r\n"
				+ "<tr>\r\n"
				+ "\r\n"
				+ "<td>\r\n"
				+ "<div align=\"center\">\r\n"
				+ "<a href=\"http://localhost:8080/aptAPI/confirmApt/{" 
				+ aptId 
				+"}\" style=\"text-decoration:none;display:inline-block;color:#555555;background-color:transparent;border-radius:0px;width:auto;border-top:2px solid #555555;border-right:2px solid #555555;border-bottom:2px solid #555555;border-left:2px solid #555555;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\" target=\"_blank\"><span style=\"padding-left:25px;padding-right:25px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"font-size: 16px; line-height: 1.5; word-break: break-word; mso-line-height-alt: 24px;\">Accept</span></span></a>\r\n"
				+ "</div>\r\n"
				+ "</td>\r\n"
				+ "\r\n"
				+ "<td>\r\n"
				+ "<div align=\"center\">\r\n"
				+ "<a href=\"https://www.example.com\" style=\"text-decoration:none;display:inline-block;color:#555555;background-color:transparent;border-radius:0px;width:auto;border-top:1px solid #555555;border-right:1px solid #555555;border-bottom:1px solid #555555;border-left:1px solid #555555;padding-top:5px;padding-bottom:5px;font-family:Arial, Helvetica Neue, Helvetica, sans-serif;text-align:center;mso-border-alt:none;word-break:keep-all;\" target=\"_blank\"><span style=\"padding-left:35px;padding-right:35px;font-size:16px;display:inline-block;letter-spacing:normal;\"><span style=\"font-size: 16px; line-height: 2; word-break: break-word; mso-line-height-alt: 32px;\">Decline</span></span></a>\r\n"
				+ "</div>\r\n"
				+ "</td>\r\n"
				+ "\r\n"
				+ "</tr>\r\n"
				+ "</table>\r\n"
				+ "\r\n"
				+ "</td>\r\n"
				+ "</tr>\r\n"
				+ "</tbody>\r\n"
				+ "</table\r\n"
				+ "\r\n"
				+ "<!-- End -->\r\n"
				+ "</body>\r\n"
				+ "</html>";
		
		MimeMessageHelper helper = new MimeMessageHelper(mail);
		
//		try {
//			helper.setFrom(mailProperties.getProperties().get("from"),mailProperties.getProperties().get("personal"));
//		} catch (UnsupportedEncodingException e) {
////			log.error("error in mail service sendHtmlMail method"+e);
//		}
		helper.setFrom("singampalliakhil@gmail.com");
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(body, true);
		notificationSender.send(mail);


	}
		
	}

