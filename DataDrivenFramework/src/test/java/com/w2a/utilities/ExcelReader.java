package com.w2a.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	private XSSFWorkbook wb = null;
	private XSSFSheet sh = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	
	
	public ExcelReader (String path)  {
		
		this.path=path;
		
		try {
			
			fis = new FileInputStream(path);
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			
			
			wb = new XSSFWorkbook(fis);
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sh = wb.getSheetAt(0);
		
		try {
			
			fis.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
}
