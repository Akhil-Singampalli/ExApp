package com.exult.repository;

import org.springframework.data.repository.CrudRepository;

import com.exult.entity.Doctors;
import com.exult.entity.Patients;

public interface DoctorRepo extends CrudRepository<Doctors, Integer > {

	public Doctors findByContactNumber(String contactNumber);
	
	public Doctors findByEmailId(String emailId);
}
