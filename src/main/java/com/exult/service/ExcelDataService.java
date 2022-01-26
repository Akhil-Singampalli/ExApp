package com.exult.service;

import java.io.InputStream;
import java.util.List;

import com.exult.dto.PatientsDTO;
import com.exult.entity.Patients;

public interface ExcelDataService {
	
	Integer saveExcelData(List<Patients> patients);

	List<PatientsDTO> getExcelDataAsList(InputStream inputStream);
}
