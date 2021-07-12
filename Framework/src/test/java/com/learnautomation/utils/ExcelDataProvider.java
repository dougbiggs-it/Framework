package com.learnautomation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//	This constructor was created so that we don't have to load the file each time.  
//	As soon as we create the object, this constructor will be called.
public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	public ExcelDataProvider() 
	{
		File src = new File("./TestData/testdata.xlsx");
		
		// Surround with try/catch 

		try {
			FileInputStream fis = new FileInputStream(src);
			//XSSFWorkbook wb = new XSSFWorkbook(fis);
			wb = new XSSFWorkbook(fis);  // Make Global to be able to access it outside of this method
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Unable to read Excel file"+e.getMessage());
		}

	}
	
	
	public String getStringData(int SheetIndex, int row, int col) 
	{
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
		
	}

	
	public String getStringData(String SheetName, int row, int col) 
	{
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public double getNumericData(String SheetName, int row, int col)
	{
		return wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
	
	}
}
