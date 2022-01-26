package com.exult.repository;

import org.springframework.data.repository.CrudRepository;

import com.exult.entity.Doctors;

public interface DoctorRepo extends CrudRepository<Doctors, Integer > {
	

	public Doctors findByContactNumber(String contactNumber);
	
	public Doctors findByEmailId(String emailId);
	
	public Doctors findByDoctorName(String name);

}
