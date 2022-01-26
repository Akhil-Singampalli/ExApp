package com.exult.service;

import java.util.List;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.exult.entity.Patients;

@Service
public class FileUploadServiceImpl implements FileUploaderService {

	public List<Patients> patientsExcelReaderService() {
		return null;
	}
	
	@Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

	
	@Override
	public void uploadFile(MultipartFile file) {
		 try {
//	            Path copyLocation = Paths
//	                .get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
//	            Files.copy(file.getInputStream());
	        } catch (Exception e) {
	            e.printStackTrace();
	            throw new RuntimeException("Could not store file " + file.getOriginalFilename()
	                + ". Please try again!");
	        }
	}

}
