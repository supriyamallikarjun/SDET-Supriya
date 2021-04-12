package com.vtiger.testscripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataProvider {

	@org.testng.annotations.DataProvider(name="TestData")
	public Object[][] selectPlaces() {

		Object[][] obj = getExcelData("./data/Testscript.xlsx","Dataprovider");
		return obj;
	
		}
			
	public String[][] getExcelData(String filename, String sheetname){
				String[][] excelData = null;
				try {

					FileInputStream fis = new FileInputStream(filename);
					Workbook wb = WorkbookFactory.create(fis);
					Sheet sh = wb.getSheet(sheetname);
					Row row = sh.getRow(0);
					int totalNoOfRows = sh.getLastRowNum();
					int totalNoOfCols = row.getLastCellNum();
					excelData = new String[totalNoOfRows-1][totalNoOfCols];
					for (int i = 0; i < totalNoOfRows; i++) {
						for (int j = 0; j < totalNoOfCols; j++) {
							excelData[i-1][j]= sh.getRow(i).getCell(j).getStringCellValue();
						}
						
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				return excelData;
	}
}
