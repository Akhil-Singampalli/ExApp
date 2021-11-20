package com.exult.repository;

import org.springframework.data.repository.CrudRepository;

import com.exult.entity.Patients;

public interface PatientRepo extends CrudRepository<Patients, Integer> {
	
	public Patients findByContactNumber(String contactNumber);

	public Patients findByEmailId(String emailId);

}
