package com.exult.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.exult.entity.PatientsData;
import com.google.common.base.Optional;

public interface PatientDataRepo extends CrudRepository<PatientsData, Integer>{

//	@Query(value="SELECT idpatientData FROM patientData ORDER BY RAND() LIMIT 1")
//	public Integer pickRandomRecord();
	
	
//	public java.util.Optional<PatientsData> findTopByPatientDataOrderById(Integer patData);
	
	
}
