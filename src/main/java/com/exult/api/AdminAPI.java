package com.exult.api;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.exult.dto.AdminDTO;
import com.exult.dto.DataFieldDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDataDTO;
import com.exult.service.AdminService;
import com.exult.service.ExcelDataService;
import com.exult.service.FileUploaderService;



@Validated
@CrossOrigin
@RestController
@RequestMapping("/adminAPI")
public class AdminAPI {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private FileUploaderService fileUploaderService;
	
	@Autowired
	private ExcelDataService excelDataService;
	
	@RequestMapping(value = "/Login",method = RequestMethod.POST)
	public ResponseEntity<AdminDTO> authenticateAdmin(@RequestBody AdminDTO admin) {
		try {
			AdminDTO adminFromDB = adminService.authenticateAdmin(admin.getContactNumber(), admin.getPassword());
			return new ResponseEntity<AdminDTO>(adminFromDB, HttpStatus.OK);
		}catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/adminRegister", method = RequestMethod.POST)
	public ResponseEntity<String> registerAdmin(@RequestBody @Valid AdminDTO admin){
		try {
			adminService.registerAdmin(admin);
			return new ResponseEntity<String>("UserAPI.REGISTER_USER_SUCCESS1"+"UserAPI.REGISTER_USER_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@RequestMapping(value = "/docRegister", method = RequestMethod.POST)
	public ResponseEntity<String> registerDoctor(@RequestBody DoctorsDTO doc){
		try {
			adminService.addDoctor(doc);
			return new ResponseEntity<String>("UserAPI.REGISTER_USER_SUCCESS1"+"UserAPI.REGISTER_USER_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping(value = "/patTempEdt")
	public ResponseEntity<String> patientDataTempEdit(@RequestBody List<DataFieldDTO> patientsdata){
		try {
			adminService.patientTempEdit(patientsdata);
			return new ResponseEntity<String>("UserAPI.REGISTER_USER_SUCCESS1"+"UserAPI.REGISTER_USER_SUCCESS2",HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	@GetMapping(value = "/sampPatTempEdt")
	public ResponseEntity<List<DataFieldDTO>> getPatientDataTempEdit(){
		try {
			List<DataFieldDTO> sampPatTemp = adminService.getPatientTempEdit();
			return new ResponseEntity<List<DataFieldDTO>>(sampPatTemp,HttpStatus.OK);
		}catch (Exception e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,environment.getProperty(e.getMessage()));
		}
	}
	
	 @PostMapping("/uploadFile")
	    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

//	        fileUploaderService.uploadFile(file);
		 	try {
				excelDataService.getExcelDataAsList(file.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        redirectAttributes.addFlashAttribute("message",
	            "You have successfully uploaded '"+ file.getOriginalFilename()+"' !");
	        try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
	        return "redirect:/";
	    }

}
