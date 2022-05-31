package com.exult.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.exult.dto.DataFieldDTO;
import com.exult.entity.DataField;
import com.exult.entity.PatientsData;

public interface DataFieldRepo extends CrudRepository<DataField, Integer >{

	List<DataField> findByPatientData(PatientsData patientsData);

	Optional<DataField> findByFieldName(String fieldName);

	Optional<DataField> findByFieldName(Integer fieldId);

	

	

}
