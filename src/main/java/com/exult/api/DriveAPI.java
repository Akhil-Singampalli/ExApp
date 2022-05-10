package com.exult.api;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import com.google.api.client.auth.oauth2.Credential;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;

import com.google.api.client.googleapis.services.CommonGoogleClientRequestInitializer;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;




@CrossOrigin
@RestController
@RequestMapping("/driveAPI")
public class DriveAPI {

	
	
	private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	
	private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);  
	
	private static final String USER_IDENTITY_KEY = "Akhil";
	
	@Value("${google.oauth.callback.uri}")
	private String CALLBACK_URI;

	@Value("${google.secret.key.path}")
	private Resource gdSecretKeys;

	@Value("${google.credentials.folder.path}")
	private Resource credentialsFolder;
	
	
	
	@GetMapping("/folder")
	public String CreateDeskFolder(Integer patirntId) throws Exception {
//		MultipartFile multipartFile = uploadedFile;
		
		Credential credential = GoogleCredential.fromStream(gdSecretKeys.getInputStream()).createScoped(SCOPES);
		
		GoogleClientRequestInitializer keyInitializer = new CommonGoogleClientRequestInitializer();
		
		Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, null).setHttpRequestInitializer(credential).setGoogleClientRequestInitializer(keyInitializer)
                .setApplicationName("ExultStore")
                .build();
		
		File fileMetadata = new File();
		fileMetadata.setName(patirntId.toString());
		fileMetadata.setParents(Collections.singletonList("1HlCViZoqau3NXcIcw3sYGEx0CFOVAj3I"));
		fileMetadata.setMimeType("application/vnd.google-apps.folder");

		File file = service.files().create(fileMetadata)
		    .setFields("id")
		    .execute();
		System.out.println("Folder ID: " + file.getId());
		
		return file.getId();
	}
}