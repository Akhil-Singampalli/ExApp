package com.exult.service;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.util.OauthConfig;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;

@Service
public class DriveAuthorizationServiceImpl implements DriveAuthorizationService{
	
	public static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
	public static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

	public static final List<String> SCOPES = Collections.singletonList(DriveScopes.DRIVE);

	public static final String USER_IDENTIFIER_KEY = "MY_TEST_USER";
	public static final String APPLICATION_NAME = "ExultApp";
	public static final String PARENT_FOLDER_NAME = "OAuth Demo App Uploaded";
	
	private GoogleAuthorizationCodeFlow flow;
	private FileDataStoreFactory dataStoreFactory;

	@Autowired
	public OauthConfig config;

	@PostConstruct
	public void init() throws Exception {
		InputStreamReader reader = new InputStreamReader(config.getDriveSecretKeys().getInputStream());
		dataStoreFactory = new FileDataStoreFactory(config.getCredentialsFolder().getFile());

		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, reader);
		flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, clientSecrets,
				SCOPES).setDataStoreFactory(dataStoreFactory).build();
	}

	@Override
	public boolean isUserAuthenticated() throws Exception {
		Credential credential = getCredentials();
		if (credential != null) {
			boolean isTokenValid = credential.refreshToken();
//			logger.debug("isTokenValid, " + isTokenValid);
			return isTokenValid;
		}
		return false;
	}

	@Override
	public Credential getCredentials() throws IOException {
		return flow.loadCredential(USER_IDENTIFIER_KEY);
	}

	@Override
	public String authenticateUserViaGoogle() throws Exception {
		GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();
		String redirectUrl = url.setRedirectUri(config.getCALLBACK_URI()).setAccessType("offline").build();
//		logger.debug("redirectUrl, " + redirectUrl);
		return redirectUrl;
	}

	@Override
	public void exchangeCodeForTokens(String code) throws Exception {
		// exchange the code against the access token and refresh token
		GoogleTokenResponse tokenResponse = flow.newTokenRequest(code).setRedirectUri(config.getCALLBACK_URI()).execute();
		flow.createAndStoreCredential(tokenResponse, USER_IDENTIFIER_KEY);
	}

	@Override
	public void removeUserSession(HttpServletRequest request) throws Exception {
//		HttpSession session = request.getSession(false);
//        session = request.getSession(true);
//        if (session != null) {
//            session.invalidate();
//            logger.info("Logged Out...");
//        }
		// revoke token and clear the local storage
		dataStoreFactory.getDataStore(config.getCredentialsFolder().getFilename()).clear();
	}

}
