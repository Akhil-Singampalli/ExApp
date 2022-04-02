package com.exult.api;

import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exult.service.DriveAuthorizationService;
import com.exult.service.DriveService;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.DriveScopes;


@CrossOrigin
@Controller
@RequestMapping("/driveAPI")
public class DriveAPI {

	
	
	private static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	
	private static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	
	private static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);  
	
	private static final String USER_IDENTITY_KEY = "MY_DUMMY_USER";
	
	@Value("${google.oauth.callback.uri}")
	private String CALLBACK_URI;

	@Value("${google.secret.key.path}")
	private Resource gdSecretKeys;

	@Value("${google.credentials.folder.path}")
	private Resource credentialsFolder;
	
	private GoogleAuthorizationCodeFlow flow;
	
	@PostConstruct
	public void init() throws Exception {
		
		GoogleClientSecrets secrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(gdSecretKeys.getInputStream()));
		flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, secrets, SCOPES)
				.setDataStoreFactory(new FileDataStoreFactory(credentialsFolder.getFile())).build();
		
	}
	@Autowired
	public DriveAuthorizationService authorizationService;

	@Autowired
	public DriveService driveService;

	
	@GetMapping("/check")
	public String showHomePage() throws Exception {
		
		boolean isUserAuthenticated = false;
		
		Credential credential= flow.loadCredential(USER_IDENTITY_KEY);
		
		if (credential != null) {
			boolean tokenValid = credential.refreshToken();
			
			if(tokenValid) {
				isUserAuthenticated = true;
				return "redirect:/home";
			}

			
		} 

			return "redirect:/login";
		
	}

	
	@GetMapping("/login")
	public String goToLogin() {
		System.out.println("here");
		return "index.html";
		
	}

	
	@GetMapping("/home")
	public String goToHome() {
		return "home.html";
	}

	
	@GetMapping("/googlesignin")
	public void doGoogleSignIn(HttpServletResponse response) throws Exception {

		
		GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
		String redirectURL = url.setRedirectUri(CALLBACK_URI).setAccessType("offline").build();
		response.sendRedirect(redirectURL);
	}

	
	@GetMapping("/oauth/callback")
	public String saveAuthorizationCode(HttpServletRequest request) throws Exception {

		String code = request.getParameter("code");

		if (code != null) {
			saveToken(code);
			
			return "redirect:/";
		}
		return "redirect:/login";
	}

	private void saveToken(String code) throws Exception{
		GoogleTokenResponse response = flow.newTokenRequest(code).setRedirectUri(CALLBACK_URI).execute();
		flow.createAndStoreCredential(response, USER_IDENTITY_KEY);
	
	}


	/**
	 * Handles logout
	 * 
	 * @return
	 * @throws Exception 
	 */
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) throws Exception {
//		logger.debug("Logout invoked...");
		authorizationService.removeUserSession(request);
		return "redirect:/login";
	}

	/**
	 * Handles the files being uploaded to GDrive
	 * 
	 * @param request
	 * @param uploadedFile
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/upload")
	public String uploadFile(HttpServletRequest request, @ModelAttribute MultipartFile uploadedFile) throws Exception {
		MultipartFile multipartFile = uploadedFile;
		Credential credential =  flow.loadCredential(USER_IDENTITY_KEY);
		

		
		return "redirect:/home?status=success";
	}
}