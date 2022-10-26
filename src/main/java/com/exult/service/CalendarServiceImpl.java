package com.exult.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.exult.dto.AppointmentDTO;
import com.exult.entity.Appointment;
import com.exult.entity.Patients;
import com.exult.entity.PatientsData;
import com.exult.exception.ExappException;
import com.exult.repository.ConfigRepo;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.CalendarScopes;

import com.google.api.services.calendar.model.CalendarList;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;
import com.google.api.services.calendar.model.EventReminder;
import com.google.api.services.calendar.model.Events;
import com.google.api.services.drive.DriveScopes;



@PropertySource("classpath:application.properties")
@Service
public class CalendarServiceImpl implements CalendarService {

	private static final List<String> SCOPES = Collections.singletonList(CalendarScopes.CALENDAR); 
	
	private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	
	private static HttpRequestInitializer httpRequestInitializer ;
	
	private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	
//	@Value("${spring.cloud.gcp.credentials.location}")
//	private Resource calSecretKeys;

	
	@Autowired
	private ConfigRepo configRepo;
	
	@Override
	public String CreateEvent(String patMail,String docMail,String slot) throws ExappException, IOException{
		
			try {
				
				
			    
				Event event = new Event()
					    .setSummary("Appointment")
					    .setLocation("Exult Clinic")
					    .setDescription("OP");
				
				
//				String startEvent = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(slot);
				SimpleDateFormat olddateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
				SimpleDateFormat newdateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
				
				Date oldstartEvent = olddateFormat.parse(slot);
				System.out.println(oldstartEvent);
				String newstartEvent = newdateFormat.format(oldstartEvent);
				
				System.out.println(newstartEvent);
					DateTime startDateTime = new DateTime(newstartEvent);
					
					EventDateTime start = new EventDateTime()
					    .setDateTime(startDateTime)
					    .setTimeZone("Asia/Kolkata");
					event.setStart(start);
					
					
				
				DateTime endDateTime = new DateTime(new Date(oldstartEvent.getTime() + (10 * 60 * 1000) ));
				System.out.println(endDateTime);
				EventDateTime end = new EventDateTime()
				    .setDateTime(endDateTime)
				    .setTimeZone("Asia/Kolkata");
				event.setEnd(end);

				String[] recurrence = new String[] {"RRULE:FREQ=DAILY;COUNT=1"};
				event.setRecurrence(Arrays.asList(recurrence));

				EventAttendee[] attendees = new EventAttendee[] {
				    new EventAttendee().setEmail(patMail),
				    new EventAttendee().setEmail("exultclinic00@gmail.com"),
				};
				event.setAttendees(Arrays.asList(attendees));

				EventReminder[] reminderOverrides = new EventReminder[] {
				    new EventReminder().setMethod("email").setMinutes(24 * 60),
				    new EventReminder().setMethod("popup").setMinutes(10),
				};
				Event.Reminders reminders = new Event.Reminders()
				    .setUseDefault(false)
				    .setOverrides(Arrays.asList(reminderOverrides));
				event.setReminders(reminders);

				String calendarId = docMail;

//			    
				Calendar calendarService =  calendarServiceBuilder();
				event = calendarService.events().insert(calendarId, event).execute();
				System.out.printf("Event created: %s\n", event.getHtmlLink());
				return event.getHtmlLink();
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
			

		return null;
	}
	
	public Calendar calendarServiceBuilder() throws ExappException {
		

		String confJsonString = configRepo.findById(1).get().getJsonconf();
		
//		GoogleCredentials credential;
//		try {
////			credential = GoogleCredential.fromStream(new ByteArrayInputStream(confJsonString.getBytes())).createScoped(SCOPES);
//			
//			credential = ServiceAccountCredentials.fromStream(new ByteArrayInputStream(confJsonString.getBytes())).createScoped(SCOPES);
//			
//			System.out.println(credential);
//			
////			GoogleCredential cred = new GoogleCredential.Builder()
////					.setTransport(HTTP_TRANSPORT)
////					.setJsonFactory(JSON_FACTORY)
////					.setServiceAccountId("bookappoint@exultstore.iam.gserviceaccount.com")
////					.setServiceAccountScopes(SCOPES)
////					.setServiceAccountPrivateKeyId("cf97bf46a40cf3391e486d6ed4866a4c5fbb2ada")
////					.build();
////			
//			
//			
//
//		      Calendar calendarService = new com.google.api.services.calendar.Calendar.Builder(
//		         HTTP_TRANSPORT,JSON_FACTORY,httpRequestInitializer).setApplicationName("ExultStore").build();
//		      
//		     
//		      return calendarService;
//		} catch (IOException e) {
//			
//			e.printStackTrace();
//		}
//		return null;
		
		 GoogleCredential credential = null;
			

		    try {

//		    	credential = GoogleCredential.fromStream(new ByteArrayInputStream(confJsonString.getBytes())).createScoped(SCOPES);
			    HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();

			    JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
			    
		      InputStream jsonFileStream = new ByteArrayInputStream(confJsonString.getBytes());
//		          DriveSample.class.getClassLoader().getResourceAsStream("client_secrets.json");

		      GoogleCredential readJson = GoogleCredential
		          .fromStream(jsonFileStream, HTTP_TRANSPORT, JSON_FACTORY).createScoped(SCOPES);
		      
		      System.out.println(readJson);
			    Calendar calendar = new Calendar.Builder(HTTP_TRANSPORT, JSON_FACTORY, readJson)
			            .setApplicationName("ExultStore")
			            .build();
			    return calendar;

//		      credential = new GoogleCredential.Builder().setTransport(readJsonFile.getTransport())
//		          .setJsonFactory(readJsonFile.getJsonFactory())
//		          .setServiceAccountId(readJsonFile.getServiceAccountId())
//		          .setServiceAccountUser("exultclinic00@gmail.com")
//		          .setServiceAccountScopes(readJsonFile.getServiceAccountScopes())
//		          .setServiceAccountPrivateKey(readJsonFile.getServiceAccountPrivateKey()).build();
		    } catch (IOException | GeneralSecurityException exception) {
		      exception.printStackTrace();
		    }
		    
		    
		    return null;

		
	}
	
	
}
