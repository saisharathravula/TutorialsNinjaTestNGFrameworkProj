package com.tutorialsninja.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	
	public static final int PAGE_LOAD_TIME=5; 
	
public static String generateEmail_TimeAndDateStamp() {
		
		Date date = new Date();
		String timeStamp = date.toString().replace(" ","_").replace(":","_");
		return "amotoori"+timeStamp+"@gmail.com";
		
	}

	public static Object[][] getTestDataFromExcelSheet(String sheetName) {
		File excelFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\TutorialsNinjaTestData.xlsx");
		XSSFWorkbook workbook = null;
		
		try  {
			
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
			
		}catch(Throwable e) {
			
			e.printStackTrace();
		
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows][cols];
		
		for(int r=0;r<rows;r++) {
			
			XSSFRow row = sheet.getRow(r+1);
			
			for(int c=0;c<cols;c++) {
				
				XSSFCell cell = row.getCell(c);
				CellType cellType = cell.getCellType();
				
				switch(cellType) {
				
				case STRING :
					data[r][c] = cell.getStringCellValue();
					break;
					
				case NUMERIC :
					data[r][c] = Integer.toString((int) cell.getNumericCellValue());
					break;
					
				case BOOLEAN :
					data[r][c] = cell.getBooleanCellValue();
					break;
					
					
					
				}
				
				
			}
			
		}
		
		return data;
		
	}
	
	public static String captureScreenshot(WebDriver driver,String testName) {
		

		File sourceScreenshor = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshot = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		try {
			FileHandler.copy(sourceScreenshor, new File(destinationScreenshot));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return destinationScreenshot;
	}

}
