package com.vtechsolution01.orangehrm.utility;

import java.io.File;
import java.io.FileInputStream;


//import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	static XSSFWorkbook workbook;

	public ExcelDataProvider(String filePath) throws Exception {
		
			
			FileInputStream fins = new FileInputStream(filePath);
			workbook = new XSSFWorkbook(fins);

		

	}

	public static int getRowCount(String sheetname) {
		return workbook.getSheet(sheetname).getLastRowNum();
	}

	public static int getColsCount(String sheetname) {
		return workbook.getSheet(sheetname).getRow(0).getLastCellNum();
	}

	public static int getRowCount(int index) {
		return workbook.getSheetAt(index).getLastRowNum();
	}

	public static int getColsCount(int index) {
		return workbook.getSheetAt(index).getRow(0).getLastCellNum();
	}

	public static String getStringCellData(String sheetname, int row, int clo) {
		return workbook.getSheet(sheetname).getRow(row).getCell(clo).getStringCellValue();
	}

	public static String getStringCellData(int index, int row, int clo) {
		return workbook.getSheetAt(index).getRow(row).getCell(clo).getStringCellValue();
	}

	public static int getNumericCellData(String sheetname, int row, int clo) {
		return (int) workbook.getSheet(sheetname).getRow(row).getCell(clo).getNumericCellValue();
	}

	public static int getNumericCellData(int index, int row, int clo) {
		return (int) workbook.getSheetAt(index).getRow(row).getCell(clo).getNumericCellValue();
	}
}
