package com.vtiger.testscripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataProvider {
	public static void main(String[] args) {
		try {
			String data	= DataProvider.excelDataProvider("Sheet1");
			System.out.println(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String excelDataProvider(String sheetName) throws Exception {
		String data = null;
		FileInputStream fis = new FileInputStream("C:\\Users\\91854\\Desktop\\Automation\\vtiger\\src\\test\\resources\\Placesforcleartrip.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getPhysicalNumberOfRows();
		int cellcount = wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells(); 
		for (int i = 1; i < rowcount; i++) {
			for (int j = 0; j < cellcount; j++) {
				data = wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
			}
			System.out.println();
		}
		return data;

	}
}