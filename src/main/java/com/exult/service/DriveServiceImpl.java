package com.exult.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exult.entity.Patients;
import com.exult.entity.PatientsData;
import com.exult.repository.PatientDataRepo;
import com.exult.repository.PatientRepo;
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

@Service
public class DriveServiceImpl implements DriveService{
	
private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	
	private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);  
	
	private static final String USER_IDENTITY_KEY = "exult";
	
	@Value("${google.oauth.callback.uri}")
	private String CALLBACK_URI;

	@Value("${google.secret.key.path}")
	private Resource gdSecretKeys;

	@Value("${google.credentials.folder.path}")
	private Resource credentialsFolder;

	@Autowired
	private PatientRepo patientRepo;
	
	@Autowired
	private PatientDataRepo patientDataRepo;
	
	@Override
	public String createFolders(Integer patId) throws Exception {
		
		
Credential credential = GoogleCredential.fromStream(gdSecretKeys.getInputStream()).createScoped(SCOPES);
		
		Optional<Patients> pat = patientRepo.findById(patId);
		PatientsData patData = pat.get().getPatientsData();
		
		GoogleClientRequestInitializer keyInitializer = new CommonGoogleClientRequestInitializer();
		
		Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, null).setHttpRequestInitializer(credential).setGoogleClientRequestInitializer(keyInitializer)
                .setApplicationName("ExultStore")
                .build();
		
		File fileMetadata = new File();
		fileMetadata.setName(patId.toString());
		fileMetadata.setParents(Collections.singletonList("1HlCViZoqau3NXcIcw3sYGEx0CFOVAj3I"));
		fileMetadata.setMimeType("application/vnd.google-apps.folder");

		File file = service.files().create(fileMetadata)
		    .setFields("id")
		    .execute();
		System.out.println(file.getId());
		
		File ImagesFolder = new File();
		ImagesFolder.setName("Images");
		ImagesFolder.setParents(Collections.singletonList(file.getId()));
		ImagesFolder.setMimeType("application/vnd.google-apps.folder");
		System.out.println("Folder ID: " + ImagesFolder.getId());
		
		File Imagesfile = service.files().create(ImagesFolder)
			    .setFields("id")
			    .execute();
		
		File PrescriptionsFolder = new File();
		PrescriptionsFolder.setName("Prescriptions");
		PrescriptionsFolder.setParents(Collections.singletonList(file.getId()));
		PrescriptionsFolder.setMimeType("application/vnd.google-apps.folder");
		System.out.println("Folder ID: " + PrescriptionsFolder.getId());
		
		File Prescriptionsfile = service.files().create(PrescriptionsFolder)
			    .setFields("id")
			    .execute();
		
		File BillsFolder = new File();
		BillsFolder.setName("Bills");
		BillsFolder.setParents(Collections.singletonList(file.getId()));
		BillsFolder.setMimeType("application/vnd.google-apps.folder");
		System.out.println("Folder ID: " + BillsFolder.getId());
		
		File Billsfile = service.files().create(BillsFolder)
			    .setFields("id")
			    .execute();
		
		patData.setDesk_data_id(file.getId());
		patData.setImg_data_id(Imagesfile.getId());
		patData.setPres_data_id(Prescriptionsfile.getId());
		patData.setBills_data_id(Billsfile.getId());
		
		patientDataRepo.save(patData);
		
		return "success";
	}
	

	

	
	
}
