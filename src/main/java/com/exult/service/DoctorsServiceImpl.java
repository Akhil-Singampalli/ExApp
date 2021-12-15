package com.exult.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exult.entity.Doctors;
import com.exult.exception.ExappException;
import com.exult.repository.DoctorRepo;

@Service(value = "doctorService")
@Transactional
public class DoctorsServiceImpl implements DoctorsService {
	
	@Autowired
	private DoctorRepo doctorRepo;

	@Override
	public List<Doctors> docDetails() throws ExappException {
		
		List<Doctors> docs = (List<Doctors>) doctorRepo.findAll();
		
		return docs;
	}

}
