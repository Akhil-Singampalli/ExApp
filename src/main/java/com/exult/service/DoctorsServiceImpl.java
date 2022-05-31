package com.exult.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.dto.DataFieldDTO;
import com.exult.dto.DoctorsDTO;
import com.exult.dto.PatientsDTO;
import com.exult.entity.DataField;
import com.exult.entity.Doctors;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;
import com.exult.repository.DataFieldRepo;
import com.exult.repository.DoctorRepo;
import com.exult.repository.PatientRepo;
import com.mysql.cj.result.Field;

@Service(value = "doctorService")
@Transactional
public class DoctorsServiceImpl implements DoctorsService {
	
	@Autowired
	private DoctorRepo doctorRepo;
	
	@Autowired
	private PatientRepo patRepo;
	
	@Autowired
	private DataFieldRepo dataFieldRepo;

	@Override
	public List<DoctorsDTO> docDetails() throws ExappException {
		
		Iterable<Doctors> docs = doctorRepo.findAll();
		
		List<DoctorsDTO> docslist = new ArrayList<>();
		
		
		
		for(Doctors doctor : docs) {
			
			DoctorsDTO doctorsDTO = new DoctorsDTO();
			
			doctorsDTO.setContactNumber(doctor.getContactNumber());
			doctorsDTO.setDoctorName(doctor.getDoctorName());
			doctorsDTO.setEmailId(doctor.getEmailId());
			doctorsDTO.setPassword(doctor.getPassword());
			doctorsDTO.setDoctorId(doctor.getDoctorId());
			
		
			docslist.add(doctorsDTO);
	
		}
	
		
		return docslist;
	}

	@Override
	public PatientsDTO patientDatasearch(Integer patientId) throws ExappException {
		
		
		return null;
	}

	@Override
	public String updatePatientData(Integer patientId,List<DataFieldDTO> dataFieldDTOlist) throws ExappException {
		Optional<Patients> optpat = patRepo.findById(patientId);
		Patients patient = optpat.orElseThrow(() -> new ExappException(""));
		
		List<DataField> dataField = dataFieldRepo.findByPatientData(patient.getPatientsData());
		
		if(patient != null ) {
			for(DataFieldDTO fieldDTO : dataFieldDTOlist) {
				DataField field = dataFieldRepo.findById(fieldDTO.getFieldId()).get();
				
				field.setFieldValue(fieldDTO.getFieldValue());
				
				dataFieldRepo.save(field);
			}		
		}
		return "Patient Data Updated Successfully";
	}

	@Override
	public List<PatientsDTO> PatientsData(Integer doctorId) throws ExappException {
		
		Iterable<Patients> pats =  patRepo.findAll();
		
		List<PatientsDTO> allpats = new ArrayList<PatientsDTO>();
		
		for (Patients pat : pats) {
			PatientsDTO patDTO = new PatientsDTO();
			patDTO.setContactNumber(pat.getContactNumber());
			patDTO.setEmailId(pat.getEmailId());
			patDTO.setPassword(pat.getPassword());
			patDTO.setPatientName(pat.getPatientName());
			patDTO.setPatientId(pat.getIdPatient());
			
			allpats.add(patDTO);
		}
		
//		System.out.println(pats.toString());
		
		return allpats;
	}

	@Override
	public DoctorsDTO getDoctor(Integer docId) throws ExappException {
		
		Optional<Doctors> optDoc = doctorRepo.findById(docId);
		
		Doctors doc = optDoc.orElseThrow(() -> new ExappException(null));
		
		DoctorsDTO doctorsDTO =new DoctorsDTO();
		
		doctorsDTO.setContactNumber(doc.getContactNumber());
		doctorsDTO.setDoctorName(doc.getDoctorName());
		doctorsDTO.setEmailId(doc.getEmailId());
		doctorsDTO.setDoctorId(doc.getDoctorId());
		
		return doctorsDTO;
	}

}
