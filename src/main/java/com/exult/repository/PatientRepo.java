package com.exult.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exult.dto.PatientsDTO;
import com.exult.entity.Patients;

public interface PatientRepo extends CrudRepository<Patients, Integer> {
	
	public Optional<Patients> findByContactNumber(String contactNumber);

	public Optional<Patients> findByEmailId(String emailId);


}
