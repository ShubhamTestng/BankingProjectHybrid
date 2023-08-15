package com.bankingutility;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bankingproject.base.BaseClass;

public class Utility extends BaseClass {
	
	FileInputStream fis;

	public Utility() {
		
		try {
			this.fis = new FileInputStream(projectpath+"\\src\\test\\resources\\Excel\\BankingProject.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public Object[][] getAllExcelSheetData(String SheetName) throws EncryptedDocumentException, IOException {
		
		  Sheet sh = WorkbookFactory.create(fis).getSheet(SheetName);
		  
		  int rowcount = sh.getLastRowNum();
		  
		  Object excelSheetData[][] = new Object[rowcount][1];
		  
		  HashMap<String,Object> hm = new HashMap<>();
		  
		  for(int i=0 ; i < sh.getLastRowNum(); i++) {
			  
			  int col = sh.getRow(i).getLastCellNum();
			  
			  for(int j=0 ; j < col; j++) {
				  
				  if(sh.getRow(row).getCell(cell).getCellType().toString().equals("String")){
						
					  hm.put(sh.getRow(i).getCell(j).getStringCellValue(), sh.getRow(i+1).getCell(j).getStringCellValue());
					}
					
					else if(sh.getRow(row).getCell(cell).getCellType().toString().equals("Numeric")) {
						
					hm.put(sh.getRow(i).getCell(j).getStringCellValue(), sh.getRow(i+1).getCell(j).getNumericCellValue());
						
					}
				  
				  excelSheetData[i][0] = hm ;
				  
			  }
			  
			  return excelSheetData;
			  
		  }
		  
		  
		
	}
	
	public Object getSingleExcelValue(int row,int cell,String SheetName ) throws EncryptedDocumentException, IOException {
		
	    Sheet sh = WorkbookFactory.create(fis).getSheet(SheetName);
		
	    Object cellvalue="";
		
	
		if(sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("String")) {
			
			cellvalue = sh.getRow(row).getCell(cell).getStringCellValue();
		}
		
		else if(sh.getRow(row).getCell(cell).getCellType().toString().equalsIgnoreCase("Numeric")) {
			
			cellvalue = sh.getRow(row).getCell(cell).getNumericCellValue();
		}
		
		return cellvalue;
		
	}
	
	public String getscreenshot(String screenshotName) throws IOException {
		
	File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	String target = projectpath+"//Screenshot//"+screenshotName+".png";
	
	FileUtils.copyFile(src, new File(target));
	
	return target;
	
	}
	
	/*
    * Images formats supported by XSSF but not by HSSF
    */
	
	public void writeExcel() throws IOException {
		
	XSSFWorkbook workbook = new XSSFWorkbook();
	
	XSSFSheet sheet = workbook.createSheet("login credential");
	
	sheet.createRow(0).createCell(0).setCellValue("email");
	
	FileOutputStream fileOutputStream = new FileOutputStream(projectpath+"\\src\\test\\resources\\Excel\\BankingProject.xlsx");
	
	workbook.write(fileOutputStream);
	
	}
	
    

}
