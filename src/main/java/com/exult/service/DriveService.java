package com.exult.service;

import org.springframework.web.multipart.MultipartFile;

public interface DriveService {

	public void uploadFile(MultipartFile multipartFile) throws Exception;
	
}
