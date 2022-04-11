package com.Westside.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	static FileInputStream fis;
	static FileOutputStream fos;
	static XSSFWorkbook wb;
	static XSSFSheet ws;
	static XSSFRow row;
	static XSSFCell cell;
	
	public static int getLastRowNum(String XLFile, String XLSheet) throws IOException {
		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);	
		int lastRowNum = ws.getLastRowNum();
		wb.close();
		fis.close();
		return lastRowNum;
	}
	
	public static int getLastCellNum(String XLFile, String XLSheet, int rowNum) throws IOException {
		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);
		row = ws.getRow(rowNum);
		int cellNum = row.getLastCellNum();
		wb.close();
		fis.close();
		return cellNum;		
	}
	
	public static String getCellValue(String XLFile, String XLSheet, int rowNum, int cellNum) throws IOException {
		fis = new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);
		row = ws.getRow(rowNum);
		cell = row.getCell(cellNum);
		String cellValue;

		try {
			DataFormatter formatter = new DataFormatter();
			cellValue = formatter.formatCellValue(cell);
		}
		
		catch(Exception e) {
			cellValue = "";
		}
		
		return cellValue;		
	}
	
	public static void setCellValue(String XLFile, String XLSheet, int rowNum, int cellNum, String value) throws IOException{
		fis= new FileInputStream(XLFile);
		wb = new XSSFWorkbook(fis);
		ws = wb.getSheet(XLSheet);
		row = ws.getRow(rowNum);
		if(row == null || row.getLastCellNum() <=0) {
			row = ws.createRow(rowNum);
		}
		
		cell = row.createCell(cellNum);
		cell.setCellValue(value);
		
		fos= new FileOutputStream(XLFile);
		wb.write(fos);		
		wb.close();
		fis.close();
		fos.close();
	}
	
	
}
