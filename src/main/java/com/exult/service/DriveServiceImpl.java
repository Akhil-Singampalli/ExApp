//package com.exult.service;
//
//import java.util.Collections;
//import java.util.List;
//
//import javax.annotation.PostConstruct;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.exult.util.OauthConfig;
//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.http.FileContent;
//import com.google.api.services.drive.Drive;
//import com.google.api.services.drive.model.File;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.drive.DriveScopes;
//
//@Service
//public class DriveServiceImpl implements DriveService{
//	private Logger logger = LoggerFactory.getLogger(DriveServiceImpl.class);
//	
//
//	public static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
//	public static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
//
//	public static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);
//
//	private static final String USER_IDENTITY_KEY = "MY_DUMMY_USER";
//	public static final String APPLICATION_NAME = "ExultApp";
//	public static final String PARENT_FOLDER_NAME = "OAuth Demo App Uploaded";
//
//	
//
//	@Autowired
//	public DriveAuthorizationService authorizationService;
//
//	@Autowired
//	public OauthConfig applicationConfig;
//
//	@PostConstruct
//	public void init() throws Exception {
//		Credential credential =  authorizationService.getCredentials();
//		Drive driveService = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
//				.setApplicationName(APPLICATION_NAME).build();
//	}
//
//	@Override
//	public void uploadFile(MultipartFile multipartFile) throws Exception {
//		logger.debug("Inside Upload Service...");
//
//		Credential credential =  authorizationService.getCredentials();
//		
//		Drive driveService = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
//				.setApplicationName(APPLICATION_NAME).build();
//		
//		String path = applicationConfig.getTemporaryFolder();
//		String fileName = multipartFile.getOriginalFilename();
//		String contentType = multipartFile.getContentType();
//
//		java.io.File transferedFile = new java.io.File(path, fileName);
//		multipartFile.transferTo(transferedFile);
//
//		
//		
//		File fileMetadata = new File();
//		fileMetadata.setName("Invoices");
//		fileMetadata.setMimeType("application/vnd.google-apps.folder");
//
//		File file = driveService.files().create(fileMetadata)
//		    .setFields("id")
//		    .execute();
//		System.out.println("Folder ID: " + file.getId());
//	}
//
//}
