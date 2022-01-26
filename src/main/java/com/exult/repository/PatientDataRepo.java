package com.exult.repository;

import org.springframework.data.repository.CrudRepository;

import com.exult.entity.PatientsData;

public interface PatientDataRepo extends CrudRepository<PatientsData, Integer>{

}
