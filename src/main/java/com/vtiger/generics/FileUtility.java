package com.vtiger.generics;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {

	public String getPropertydata(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IConstant.propertyFilePath);
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	public String getExceldata(String sheetName, String key, int rowNum, int cellNum) throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet= wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum); 
		String value = cell.getStringCellValue();
		return value;
	}
	/*public String writeExceldata(String sheetName, String key, int rowNum, int cellNum) throws IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream fis = new FileInputStream(IConstant.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet= wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum); 
		 Object value = cell.setCellValue("");
		
	}*/
	
}
