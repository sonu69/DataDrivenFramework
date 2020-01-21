package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelTest {
	static XSSFSheet sh;

	public static void main(String[] args) throws IOException {
		File fl = new File(".//Data//Test.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		sh = wb.getSheetAt(0);
		System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
		

	}

}
