package com.exult.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.exult.dto.PatientsDTO;
import com.exult.entity.Patients;
import com.exult.exception.ExappException;
import com.exult.repository.PatientRepo;

@Service
public class ExcelDataServiceImpl implements ExcelDataService {

	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	@Autowired
	PatientRepo patientRepo;
	
	@Autowired
	PatientsServiceImpl patientsServiceImpl;

	

	@Override
	public List<PatientsDTO> getExcelDataAsList(InputStream inputStream) {

			List<PatientsDTO> patList = new ArrayList<>();
			
			try {
			      Workbook workbook = new XSSFWorkbook(inputStream);

			      Sheet sheet = workbook.getSheet("Patients");
			      Iterator<Row> rows = sheet.iterator();

			      DataFormatter formatter = new DataFormatter();

			      int rowNumber = 0;
			      while (rows.hasNext()) {
			        Row currentRow = rows.next();

			        // skip header
			        if (rowNumber == 0) {
			          rowNumber++;
			          continue;
			        }

			        Iterator<Cell> cellsInRow = currentRow.iterator();

			        PatientsDTO patient = new PatientsDTO();

			        int cellIdx = 0;
			        while (cellsInRow.hasNext()) {
			          Cell currentCell = cellsInRow.next();

			          switch (cellIdx) {
			          case 0:
			            patient.setPatientName(formatter.formatCellValue(currentCell));
			            break;

			          case 1:
			            patient.setContactNumber(formatter.formatCellValue(currentCell));
			            break;

			          case 2:
			            patient.setEmailId(formatter.formatCellValue(currentCell));
			            break;

			          case 3:
			            patient.setPassword(formatter.formatCellValue(currentCell));
			            break;

			          default:
			            break;
			          }

			          cellIdx++;
			        }

			        try {
						patientsServiceImpl.registerPatient(patient);
					} catch (ExappException e) {
						
						e.printStackTrace();
					}
			        patList.add(patient);
			      }

			      workbook.close();

			      return null;
			      
			    } catch (IOException e) {
			    	
			      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
			    }

	}

	
	private List<Patients> createList(List<String> excelData, int noOfColumns) {

		ArrayList<Patients> invList = new ArrayList<Patients>();

		int i = noOfColumns;
		do {
			PatientsDTO patientsDTO = new PatientsDTO();

			patientsDTO.setPatientName(excelData.get(i));
			patientsDTO.setContactNumber(excelData.get(i + 1));
			patientsDTO.setEmailId(excelData.get(i + 2));
			patientsDTO.setPassword(excelData.get(i + 3));

			try {
				patientsServiceImpl.registerPatient(patientsDTO);
			} catch (ExappException e) {
				
				e.printStackTrace();
			}
			i = i + (noOfColumns);

		} while (i < excelData.size());
		return invList;
	}

	@Override
	public Integer saveExcelData(List<Patients> patients) {
		// TODO Auto-generated method stub
		return null;
	}

}
