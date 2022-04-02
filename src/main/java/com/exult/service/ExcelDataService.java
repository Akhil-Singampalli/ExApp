package com.exult.service;

import java.io.InputStream;
import java.util.List;

import com.exult.dto.PatientsDTO;
import com.exult.entity.Patients;

public interface ExcelDataService {
	
	public Integer saveExcelData(List<Patients> patients);

	 public List<PatientsDTO> getExcelDataAsList(InputStream inputStream);
}
