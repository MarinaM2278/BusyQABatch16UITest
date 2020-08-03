package com.busyqa.batch16.uitests.excelReader;

import java.io.FileInputStream; // reading 
import java.io.FileOutputStream; // writing
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	// global variables 
	public FileOutputStream fileout = null; // write the content to the file (excel)
	public String filepath;  // filepath location where the .xlsx file is kept
	public FileInputStream fis;  // read the content from the file (excel)
	public XSSFWorkbook workbook; // workbook variable
	public XSSFSheet sheet;  // sheet variable
	public XSSFRow row;  // row variable
	public XSSFCell cell = null; // column/cell data variable
	int columncount=0; // initialization
	int rownum = 0;
	String str="";
	ArrayList<String> loginValues = new ArrayList<String>();
	int i=0;
	int j=0;

	// 1. Reading the data
	public ArrayList<String> getCellData(String filepath,String excelName,String sheetName, int rowNumber) {
	
		try {
			this.filepath=filepath;
			String filepath1 = filepath+excelName;
			fis = new FileInputStream(filepath1); // reading data / fetching data from a file
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		    rownum=sheet.getLastRowNum(); // 0 to 4 where 0 is the having headers and values are in 1 - 4 rows
			System.out.println("Number of rows: " + rownum); 
			
			columncount = sheet.getRow(0).getLastCellNum();	// 1 - 3
			System.out.println("Number of columns: " + columncount);
			
			row = sheet.getRow(rowNumber);
			loginValues = new ArrayList<String>(); // refreshing purpose (flushing the older values)
			
			for(j=0;j<columncount-1;j++) {
			str = row.getCell(j).getStringCellValue();
			loginValues.add(str); // List will always maintain the order of the inserted values (0- username, 1-password)
			
			}	
		workbook.close();
		fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return loginValues;
	}
	
	public void updateCellData(String filepath,String excelName,String sheetName, int rowNumber, String result) {
		
		try {
			this.filepath=filepath;
			String filepath1 = filepath+excelName;
			fis = new FileInputStream(filepath1);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
			
			columncount = sheet.getRow(0).getLastCellNum(); // 3	
			
			row = sheet.getRow(rowNumber);
			row.createCell(columncount-1).setCellValue(result);
			
			fileout = new FileOutputStream(filepath1);
	        workbook.write(fileout); //actually the data is getting written into the sheet
		    workbook.close();
		    fis.close();
		    fileout.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeCellData(String filepath,String excelName,String sheetName, String message) {
	
		try {
			this.filepath=filepath;
			String filepath1 = filepath+excelName;
			fis = new FileInputStream(filepath1);
			workbook = new XSSFWorkbook(fis);
			
			sheet = workbook.createSheet(sheetName);
		
			rownum=sheet.getLastRowNum(); // row count = -1 (no rows)
			System.out.println(rownum);
			
	
			if (rownum == -1) {
				row = sheet.createRow(0); // creating a header row
				row.createCell(0).setCellValue("Output"); // column header
				
			}
			
			
			row = sheet.createRow(1); // second row
			row.createCell(0).setCellValue(message);
			
			fileout = new FileOutputStream(filepath1);
			
			workbook.write(fileout);
			workbook.close();
			fileout.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
  public void newSheet(String filepath,String excelName,String sheetName) {
	
	try {
		this.filepath=filepath;
		String filepath1 = filepath+excelName;
		fileout = new FileOutputStream(filepath1);
		
		workbook = new XSSFWorkbook();
		
		sheet = workbook.createSheet(sheetName);
		
		for(i = 0; i<=5; i++) { // rows 
			row = sheet.createRow(i);
			for(j = 0; j<3; j++) { // columns
				row.createCell(j).setCellValue("Test");
			}
		}
		
		workbook.write(fileout);
		workbook.close();
		} catch (IOException e) {
		e.printStackTrace();
	}
  }
}





