package com.w2a.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.w2a.utilities.ExcelReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static WebDriverWait wait;
	public  ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;


	
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		if(driver==null) {
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties"));
			config.load(fis);
			fis = new FileInputStream(new File(System.getProperty("user.dir")+"/src/test/resources/properties/OR.properties"));
			OR.load(fis);
			if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
			else if(config.getProperty("browser").equalsIgnoreCase("fireox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.get(config.getProperty("url"));
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			wait = new WebDriverWait(driver,10);
			htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/sonu"+".html"));
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
		}
	}


	public boolean isElementPresent(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		}
		catch(NoSuchElementException e) {
			return false;
		}
	}


	public String getData(int row, int cell) throws IOException {
		File fl = new File(System.getProperty("user.dir")+"/src/test/resources/excel/Test.xlsx");
		FileInputStream fis = new FileInputStream(fl);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheetAt(0);
		String data = sh.getRow(row).getCell(cell).getStringCellValue();
		return data;
	}


	@AfterSuite
	public void tearDown() {
		if(driver!=null) {
			driver.quit();
		}
	}
}
