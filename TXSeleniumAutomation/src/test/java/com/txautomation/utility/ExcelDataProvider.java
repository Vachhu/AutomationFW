/**
 * 
 */
package com.txautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author vramdasbandekar
 *
 */
public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
		
		File src= new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read excel file"+e.getMessage());;
		}
	}
	
	public String getStringdata(int index,int row,int col) {
		
		return wb.getSheetAt(index).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public String getStringdata(String SheetName,int row,int col) {
		
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
		
	}
	
	public double getNumericData(String SheetName,int row,int col) {
		
		return wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
		
	}

}
