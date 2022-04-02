package com.exult.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exult.entity.Doctors;

public interface DoctorRepo extends CrudRepository<Doctors, Integer > {
	

	public Optional<Doctors> findByContactNumber(String contactNumber);
	
	public Optional<Doctors> findByEmailId(String emailId);
	
	public Doctors findByDoctorName(String name);

}
